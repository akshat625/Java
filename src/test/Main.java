package test;
sealed abstract class JavaFramework permits Spring, Hibernate, Quarkus {
    abstract void frameworkInfo();
}

final class Spring extends JavaFramework {
    @Override
    void frameworkInfo() {
        System.out.println("Spring is a Java framework for building enterprise applications.");
    }
}

sealed class Hibernate extends JavaFramework permits JPA {
    @Override
    void frameworkInfo() {
        System.out.println("Hibernate is an ORM framework for handling database interactions.");
    }
}

non-sealed class Quarkus extends JavaFramework {
    @Override
    void frameworkInfo() {
        System.out.println("Quarkus is a cloud-native Java framework optimized for containers.");
    }
}

final class JPA extends Hibernate {
    @Override
    void frameworkInfo() {
        System.out.println("JPA (Java Persistence API) is a specification for ORM in Java.");
    }
}

public class Main {
    public static void main(String[] args) {
        JavaFramework spring = new Spring();
        JavaFramework hibernate = new Hibernate();
        JavaFramework jpa = new JPA();
        JavaFramework quarkus = new Quarkus();

        spring.frameworkInfo();
        hibernate.frameworkInfo();
        jpa.frameworkInfo();
        quarkus.frameworkInfo();
    }
}

