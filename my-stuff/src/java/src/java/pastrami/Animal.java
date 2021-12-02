package src.java.pastrami;

public class Animal {
    String name;
    public Animal(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "sou um animal chamado " + name;
    }
    public String getName() {
        return name;
    }
    public void talk() {
        System.out.println("bark or meow, that is the question");
    }
}