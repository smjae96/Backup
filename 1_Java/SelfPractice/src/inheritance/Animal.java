package inheritance;

public class Animal {
	private String name = "����";
	public int age = 15;
	public Animal() {
		
	}
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
