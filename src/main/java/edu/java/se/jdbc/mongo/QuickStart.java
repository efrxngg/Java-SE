package edu.java.se.jdbc.mongo;

import static com.mongodb.client.model.Accumulators.avg;
import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;


import com.mongodb.client.*;
import static com.mongodb.client.model.Aggregates.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.List;

public class QuickStart {
    public static void main(String[] args) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://root:root1234@myatlasclusteredu.ks3pl09.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> collection = database.getCollection("movies");

//            insert
            Document document = new Document()
                    .append("_id", new ObjectId())
                    .append("", null);
            var resultOne = collection.insertOne(document);
            System.out.println(resultOne.getInsertedId());

            collection.insertMany(List.of(new Document()));
//            find
            var cursor = collection
                    .find(and(gte("ingresos", 1000), gte("deudas", 100)))
                    .iterator();

            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }

            Document doc = collection.find(eq("title", "Back to the Future")).first();

            MongoCollection<Document> accounts = database.getCollection("accounts");
            matchStage(accounts);

//            update
            Bson query = eq("account_id", "MDB12234728");
            Bson updates = combine(set("account_status", "active"), inc("balance", 100));
            UpdateResult upResult = collection.updateOne(query, updates);
            System.out.println(upResult.getUpsertedId());

            Bson query2 = eq("account_type", "savings");
            Bson updates2 = combine(set("minimum_balance", 100));
            UpdateResult upResult2 = collection.updateMany(query, updates2);
//            delete
            Bson query3 = eq("account_holder", "john doe");
            DeleteResult delResult = collection.deleteOne(query3);
            System.out.println("Deleted a document:");
            System.out.println("\t" + delResult.getDeletedCount());

            Bson query4 = eq("account_status", "dormant");
            DeleteResult delResult2 = collection.deleteMany(query4);
            System.out.println(delResult2.getDeletedCount());

//            Transacctions

            final ClientSession clientSession = mongoClient.startSession();

            TransactionBody txnBody = new TransactionBody<String>(){
                public String execute() {
                    MongoCollection<Document> bankingCollection = mongoClient.getDatabase("bank").getCollection("accounts");

                    Bson fromAccount = eq("account_id", "MDB310054629");
                    Bson withdrawal = inc("balance", -200);

                    Bson toAccount = eq("account_id", "MDB643731035");
                    Bson deposit = inc("balance", 200);

                    System.out.println("This is from Account " + fromAccount.toBsonDocument().toJson() + " withdrawn " + withdrawal.toBsonDocument().toJson());
                    System.out.println("This is to Account " + toAccount.toBsonDocument().toJson() + " deposited " + deposit.toBsonDocument().toJson());
                    bankingCollection.updateOne(clientSession, fromAccount, withdrawal);
                    bankingCollection.updateOne(clientSession, toAccount, deposit);

                    return "Transferred funds from John Doe to Mary Doe";
                }
            };

            try {
                clientSession.withTransaction(txnBody);
            } catch (RuntimeException e){
                System.out.println(e);
            }finally{
                clientSession.close();
            }
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }

    private static void matchStage(MongoCollection<Document> accounts) {
        Bson matchStage = match(eq("account_id", "MDB310054629"));
        Bson groupStage = group("$account_type", sum("total_balance", "$balance"), avg("average_balance", "$balance"));
        System.out.println("Display aggregation results");
        accounts.aggregate(List.of(matchStage, groupStage)).forEach(document->System.out.print(document.toJson()));
    }

}