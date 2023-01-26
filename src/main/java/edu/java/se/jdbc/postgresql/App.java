package edu.java.se.jdbc.postgresql;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        StringBuilder query = getAllUsers();
        try {
            var stmt = connection.createStatement();
            if (!stmt.execute(query.toString()))
                System.out.println("Usuarios Agregados");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(query);
    }

    public StringBuilder getAllUsers() {
        int cantUsers = 10000;
        var result = new StringBuilder("insert into usuario values ");
        var random = new Random();
        var lenListName = names.size() - 1;

        IntStream.range(0, cantUsers)
                .forEach(x -> {
                    var name = names.get((int) Math.round(random.nextDouble() * lenListName));
                    result.append(
                            String.format("('%s', '%s', '%s@gmail.com'), ", UUID.randomUUID(), name, name));
                });
        int len2 = result.length();
        result.delete(len2 - 2, len2);
        return result;
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