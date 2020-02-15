import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Yasin Yýlmaz
 * ID: 041701020
 * since 25.03.2019
 * This code makes takes input and makes something according to input
 * if input is "a" it takes more input and create a furniture object
 * if input is "s" show every furnitures
 * if input is "f" it takes an string and if it is same with the designer's name prints him/her furniture
 * if input is "q" it quits the program
 * 
 */
public class week05w {
	public static String inputMessage() {
		Scanner stdin2=new Scanner(System.in);
		System.out.println("Press a to add furniture:\nPress s to show all furniture:\nPress q quit program:\nPress f to search designer\n");
		return stdin2.next();

	}

	public static void main(String[] args) {
		Scanner stdin=new Scanner(System.in);
		String input=inputMessage();


		ArrayList<Furniture> furnitureList=new ArrayList<>();
		while(!input.equals("q")) {

			Furniture furniture=new Furniture();
			Object String;
			if(input.equals("a")) {
				System.out.println("Enter furniture name: ");
				String furnitureName=stdin.next();
				furniture.setFurnitureName(furnitureName);
				System.out.println("Enter furniture price: ");
				int furniturePrice=stdin.nextInt();
				furniture.setPrice(furniturePrice);
				System.out.println("Enter designer's name: ");
				String designerName=stdin.next();
				Person person=new Person(designerName);
				furniture.setPerson(person);
				furnitureList.add(furniture);


			}
			else if (input.equals("s")) {
				System.out.println("List of furniture:\n");
				for(Furniture x:furnitureList) {
					System.out.println(x.toString());
					System.out.println();
				}

			}
			else if (input.equals("f")) {
				System.out.print("Please enter designer name: ");
				String searchName=stdin.next();
				for (Furniture a : furnitureList) {
					if(a.getPerson().toString().equals(searchName)) {
						System.out.println("\nDesigner found\n");
						System.out.println(a.toString());
					}
				}
			}
			System.out.println();
			input=inputMessage();
		}
		stdin.close();
	}
}
