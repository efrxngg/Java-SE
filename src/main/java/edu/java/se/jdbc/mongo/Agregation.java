package edu.java.se.jdbc.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Sorts.descending;
import static java.util.Arrays.asList;

public class Agregation {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://root:root1234@myatlasclusteredu.ks3pl09.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase db = mongoClient.getDatabase("bank");
            MongoCollection<Document> accounts = db.getCollection("accounts");
            matchSortAndProjectStages(accounts);
        }
    }

    private static void matchSortAndProjectStages(MongoCollection<Document> accounts){
        Bson matchStage =
                Aggregates.match(Filters.and(Filters.gt("balance", 1500), Filters.eq("account_type", "checking")));
        Bson sortStage = Aggregates.sort(Sorts.orderBy(descending("balance")));
        Bson projectStage = Aggregates.project(Projections.fields(Projections.include("account_id", "account_type", "balance"), Projections.computed("euro_balance", new Document("$divide", asList("$balance", 1.20F))), Projections.excludeId()));
        System.out.println("Display aggregation results");
        accounts.aggregate(asList(matchStage,sortStage, projectStage)).forEach(document -> System.out.print(document.toJson()));
    }
}
