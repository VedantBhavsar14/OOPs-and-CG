
public class Animal {
	String name;
	Animal(String name){
		this.name=name;
	}
	
public void eat() {
	System.out.println(name + "eats");
	}

public void bark() {
	System.out.println(name + "barks");
	}

}

class Dog extends Animal{
	Dog(String name){
		super(name);
	}
	
public void bark() {
	System.out.println(name + "barks");
	}

public void showAction() {
	eat();
	bark();
	}
}

class SingleInheritance{
	public static void main(String[]args) {
		Dog dog = new Dog("Tommy");
		dog.showAction();
	}
}