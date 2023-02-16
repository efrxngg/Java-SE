package edu.java.se.jdbc.postgresql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

public class App {
    private static final ConecctionPostgreSQL CONECCTION = new ConecctionPostgreSQL();

    public static void main(String... args) {
        App app = new App();
        long start = System.currentTimeMillis();
        app.saveAll();
        long finish = System.currentTimeMillis() - start;
        System.out.println("MiliSegundos: " + finish);
    }

    private void saveAll() {
        var connection = CONECCTION.getConnectionPruebas();
        var query = bulkInsertGenerator();
        try {
            var stmt = connection.createStatement();
            if (!stmt.execute(query))
                System.out.println("Usuarios Agregados");

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
//        System.out.println(query);
    }

    String bulkInsertGenerator() {
        var random = new Random();
        int size = names.size();

        StringBuilder result = IntStream.iterate(1, i -> ++i).limit(100)
                .parallel()
                .mapToObj(x -> {
                    var name = names.get(random.nextInt(size));
                    return "('%s', '%s', '%s@gmail.com'), ".formatted(UUID.randomUUID(), name, name);
                })
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);

        int len = result.length();
        result.delete(len - 2, len);
        result.insert(0, "insert into usuario values ");
        return result.toString();
    }

    private final List<String> names = List.of(
            "Abigail", "Bulma", "Carlos", "Dario", "Efren", "Fajardo", "Gian", "Hugo", "Ismael",
            "Jose", "Karla", "Luis", "Mario", "Noriel", "Ñoño", "Oscar", "Pedro", "Quirga", "Roberto", "Samuel",
            "Tadeo", "Usca", "Violeta", "Walter", "Xavier", "Yoel", "Zoe");
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Usuario {

    private UUID id;
    private String name;
    private String correo;

}