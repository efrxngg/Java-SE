package edu.java.se.data.structure.nonlinear;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

public class BinarySearchTree implements IBST<User> {
    private User value;
    private BinarySearchTree left, right;

    private BinarySearchTree father;

    @Override
    public void insert(User user) {
        insertImpl(user, null);
    }

    private void insertImpl(User user, BinarySearchTree father) {
        if (value == null) {
            this.value = user;
            this.father = father;
        } else {
            if (user.compareTo(value) < 0) {
                if (left == null)
                    left = new BinarySearchTree();
                left.insertImpl(user, this);
            } else if (user.compareTo(value) > 0) {
                if (right == null)
                    right = new BinarySearchTree();
                right.insertImpl(user, this);
            } else {
//                Este es el escenario donde ambos son iguales
                throw new IllegalArgumentException("DUPLICATE ITEM");
            }
        }
    }

    @Override
    public boolean exists(int id) {
        if (value != null) {
            if (id == value.getId()) {
                return true;
            } else if (id < value.getId() && left != null) {
                return left.exists(id);
            } else if (id > value.getId() && right != null) {
                return right.exists(id);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public User get(int id) {
        if (value != null) {
            if (id == value.getId()) {
                return value;
            } else if (id < value.getId()) {
                return left.get(id);
            } else {
                return right.get(id);
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean isSheet() {
        return value != null && left == null && right == null;
    }

    @Override
    public boolean isEmpty() {
        return value == null;
    }

    @Override
    public void preOrden() {
        if (value != null) {
            System.out.println(value);
            if (left != null)
                left.preOrden();
            if (right != null)
                right.preOrden();
        }
    }

    @Override
    public void inOrden() {
        if (value != null) {
            if (left != null)
                left.postOrden();
            System.out.println(value);
            if (right != null)
                right.postOrden();
        }
    }

    @Override
    public void postOrden() {
        if (value != null) {
            if (left != null)
                left.postOrden();
            if (right != null)
                right.postOrden();
            System.out.println(value);
        }
    }

    @Override
    public void delete(int id) {
        if (value != null) {
            if (id == value.getId()) {
                deleteImpl(id);
            } else if (id < value.getId() && left != null) {
                left.delete(id);
            } else if (id > value.getId() && right != null) {
                right.delete(id);
            }
        }
    }

    private void deleteImpl(int id) {
        if (left != null && right != null) {
//            Eliminar con 2 hijos
            BinarySearchTree minimo = right.min();
            this.value = minimo.value;
            right.delete(minimo.value.getId());
        } else if (left != null || right != null) {
//            Eliminar con 1 hijo
            BinarySearchTree sustitute = left != null ? left : right;
            this.value = sustitute.value;
            this.left = sustitute.left;
            this.right = sustitute.right;
        } else {
//            Eliminar con 0 hijos
            if (father != null) {
                if (this == father.left)
                    father.left = null;
                if (this == father.right)
                    father.right = null;
                father = null;
            }
            value = null;
        }
    }

    private BinarySearchTree min() {
        if (left != null && !left.isEmpty()) {
            return left.min();
        } else {
            return this;
        }
    }
}

interface IBST<T extends Comparable> {
    void insert(T user);

    boolean exists(int id);

    T get(int id);

    boolean isSheet();

    boolean isEmpty();

    void preOrden();

    void inOrden();

    void postOrden();

    void delete(int id);
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User implements Comparable<User> {
    private int id;
    private String name;
    private String role;

    @Override
    public int compareTo(User user) {
        return Integer.compare(id, user.getId());
    }
}

class BinarySearchTreeDemo {
    //#region DATA
    private static final User[] users = {
            new User(1, "Efren", "Galarza"),
            new User(2, "Daniel", "Galarza"),
            new User(3, "Elizabeth", "Galarza"),
            new User(4, "Nacha", "Galarza"),
            new User(5, "Gatozilla", "Galarza"),
    };
    //#endregion

    public static void main(String[] args) {
        IBST<User> bst = new BinarySearchTree();
        Stream.of(users)
                .peek(bst::insert)
                .map(User::getId)
                .filter(bst::exists)
                .map(bst::get)
                .forEach(x -> System.out.printf("%s ", x.getName()));
        System.out.println("\nIs empty: " + bst.isEmpty() + "Is sheet: " + bst.isSheet());

        System.out.println("Pre-Orden");
        bst.preOrden();
        System.out.println("In-Orden");
//        bst.delete(1);
        bst.inOrden();
        System.out.println("Post-Orden");
        bst.postOrden();

    }
}
