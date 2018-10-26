package chapter3;

import java.util.LinkedList;
import java.util.Random;

public class AnimalShelter {
	
	private static class Animal {
		private String name;
		public Animal(String nm) {
			this.name = nm;
		}
		@Override
		public String toString() {
			return "Animal [name=" + name + "]";
		}		
	}
	
	private static class Cat extends Animal {

		public Cat(String nm) {
			super(nm);
		}				
	}
	
	private static class Dog extends Animal {

		public Dog(String nm) {
			super(nm);
		}		
	}
	
	private LinkedList<Dog> dogQueue;
	private LinkedList<Cat> catQueue;
	
	public AnimalShelter() {
		dogQueue = new LinkedList<>();
		catQueue = new LinkedList<>();
		
		
	}
	
	
	public void enqueue(Animal animal) {
		if (animal.getClass() == Cat.class) {
			System.out.println("Enqueue to cat queue.");
			catQueue.add((Cat)animal);
		}
		else if (animal.getClass() == Dog.class) {
			System.out.println("Enqueue to dog queue.");
			dogQueue.add((Dog)animal);
		}
	}
		
	public Dog dequeueDog() {
		if (dogQueue.isEmpty() == false) {
			
			return dogQueue.remove();
		}
		else {
			System.out.println("Dog queue is empty!");
			return null;
		}
	}
	
	public Cat dequeueCat() {
		if (catQueue.isEmpty() == false) {
			return catQueue.remove();
		}
		else {
			System.out.println("Cat queue is empty!");
			return null;
		}
	}
	
	public Animal dequeueAny() {
		Random random = new Random();
		if (random.nextInt(2) % 2 == 0)
			return dequeueDog();
		else
			return dequeueCat();					
	}
		
	public static void main(String[] args) {
		
		AnimalShelter as = new AnimalShelter();
				
		as.enqueue(new Dog("Puppy"));
		as.enqueue(new Dog("Bulldog"));	
		as.enqueue(new Dog("York"));
		as.enqueue(new Dog("Jindo"));
		as.enqueue(new Cat("Garfield"));
		as.enqueue(new Cat("Meercat"));
		as.enqueue(new Cat("Cutecat"));		
		
		/*
		System.out.println(as.dequeueDog());
		System.out.println(as.dequeueDog());
		System.out.println(as.dequeueDog());
		System.out.println(as.dequeueCat());
		System.out.println(as.dequeueCat());
		System.out.println(as.dequeueCat());
		*/
		
		System.out.println(as.dequeueAny());
		System.out.println(as.dequeueAny());
		System.out.println(as.dequeueAny());
		System.out.println(as.dequeueAny());
		
	}
}
