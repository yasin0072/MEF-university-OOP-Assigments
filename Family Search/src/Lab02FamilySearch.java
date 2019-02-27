import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Yasin Yýlmaz
 * ID: 041701020
 * since 18.02.2019
 * this code takes input a father name and try to finds this name's children
 * if it can not find father's name, prints not in the family message
 * if it can find , prints father's children and also prints father name and age
 * 
 */

public class Lab02FamilySearch {
	public static void getNames(String name) {
		String filename = "data.txt";       

		File myFile = new File(filename);

		Scanner myInput = null;

		try {

			myInput = new Scanner(myFile);

		} catch (FileNotFoundException e) {

			System.out.println(filename + ": Input file can not be found!\nExiting program...");

			System.exit(1);

		}
		boolean x =true;

		while(myInput.hasNext()) {

			String line = myInput.nextLine();

			String[] parts = line.split(" ");

			for (int asd=0; asd<parts.length;asd++) {

				if (parts[asd].equals(name)) {
					x=false;
					System.out.print(name + "'s children " + parts[asd-2] );
					System.out.print(" [" + parts[asd+1] + parts[asd+2]+"]\n" );
				}
			}

		}
		if (x)
			System.out.println(name+" is not in the family database.");
	}

	public static void main(String[] args) {

		Scanner fatherInput = new Scanner(System.in);
		System.out.print("Enter father's name:");
		String fatherName=fatherInput.nextLine();
		System.out.println("Searching " + fatherName + " 's children...\n");
		fatherInput.close();
		getNames(fatherName);





	}

}