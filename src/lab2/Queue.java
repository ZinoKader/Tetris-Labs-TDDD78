package lab2;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    public Queue() {
    }

    private List<Person> elements = new ArrayList<>();

    public int size() {
        return elements.size();
    }

    public Boolean isEmpty() {
        return elements.isEmpty();
    }

    public void clear() {
        elements.clear();
    }

    public Boolean contains(Person person) {
        return elements.contains(person);
    }

    public void enqueue(Person person) {
        elements.add(person);
    }

    public Person dequeue() {
        Person dequeuedPerson = elements.get(0);
        elements.remove(0);
        return dequeuedPerson;
    }

}
