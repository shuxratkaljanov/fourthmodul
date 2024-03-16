package lesson3.github;

public class Immutable {
    private final int value;
    private final String name;
    private final int age;

    public Immutable(int value, String name, int age) {
        this.value = value;
        this.name = name;
        this.age = age;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
