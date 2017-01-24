package lab2;

import java.time.LocalDate;

public class QueueStackTest {

    public static void main(String[] args) {

	Queue queue = new Queue();
	Stack stack = new Stack();

	Person zino = new Person("Zino", LocalDate.of(1997, 12, 25));
	Person viktor = new Person("Viktor", LocalDate.of(1997, 6, 2));
	Person arin = new Person("Artin", LocalDate.of(1996, 4, 1));
	Person martin = new Person("Martin", LocalDate.of(1997, 7, 14));


	/* Queue testing!  */
	System.out.println("Is queue empty? " + queue.isEmpty());

	System.out.println("Adding Zino, Viktor, Artin and Martin to the queue");
	queue.enqueue(zino);
        queue.enqueue(viktor);
        queue.enqueue(arin);
        queue.enqueue(martin);
	System.out.println("This is the size of the queue now: " + queue.size());


	System.out.println("Is queue empty? " + queue.isEmpty());
	System.out.println("Does queue contain the Person object Zino? " + queue.contains(zino));
	System.out.println("Remove Zino from the queue...");
	System.out.println("Removed " + queue.dequeue().getName());
	System.out.println("Does Zino exist in the queue now? " + queue.contains(zino));


	queue.clear();
	System.out.println("Clear queue...");
	System.out.println("Is queue empty? " + queue.isEmpty());



	//newline
	System.out.println("\n");


	/* Stack testing! */
	System.out.println("Is stack empty? " + stack.isEmpty());

	System.out.println("Adding Zino, Viktor, Artin and Martin to the stack");
	stack.push(zino);
        stack.push(viktor);
        stack.push(arin);
        stack.push(martin);
	System.out.println("This is the size of the stack now: " + stack.size());


	System.out.println("Is stack empty? " + stack.isEmpty());
	System.out.println("Does stack contain the Person object Martin? " + stack.contains(martin));
	System.out.println("Remove Martin from the stack...");
	System.out.println("Removed " + stack.pop().getName());
	System.out.println("Does Martin exist in the stack now? " + stack.contains(martin));


	stack.clear();
	System.out.println("Clear stack...");
	System.out.println("Is stack empty? " + stack.isEmpty());
    }

}
