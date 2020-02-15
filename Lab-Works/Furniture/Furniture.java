
public class Furniture {
	private String furnitureName;
	private int price ;
	private Person person;
	
	Furniture(){
		
	}
	public void setFurnitureName(String furnitureName) {
		this.furnitureName = furnitureName;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getFurnitureName() {
		return furnitureName;
	}
	public int getPrice() {
		return price;
	}
	public Person getPerson() {
		return person;
	}
	public String toString() {
		return "["+furnitureName+" "+price+" "+ person.toString()+"]";
	}
}
