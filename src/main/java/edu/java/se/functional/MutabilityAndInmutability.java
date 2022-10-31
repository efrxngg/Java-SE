package edu.java.se.functional;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MutabilityAndInmutability {
    public static void main(String[] args) {
        mutable();
        inmutable();
    }

    private static void mutable() {
        UserMutable user = new UserMutable(
                "dario@gmail.com",
                "1234",
                List.of("dari"));
        user.setUsernames(List.of("dario12345"));
        System.out.println(user.toString());
    }

    public static void inmutable() {
        UserInmutable user = new UserInmutable(
                "efrenpgc2602@gmail.com",
                "root1234",
                List.of("efrxngg", "Exxxx"));
        System.out.println(user.toString());
    }

}

@Data
@AllArgsConstructor
final class UserInmutable {

    private final String email;

    private final String password;

    private final List<String> usernames;

    public final List<String> getUsername() {
        return new LinkedList<>(usernames);
    }

}

@Data
@AllArgsConstructor
final class UserMutable {

    private String email;

    private String password;

    private List<String> usernames;

}
