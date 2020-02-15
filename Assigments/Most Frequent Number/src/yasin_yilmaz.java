import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

/**
 * @author Yasin Yýlmaz 
 * ID: 041701020
 * @since February 17, 2019
 * Program explanation: Finds and displays the most frequent number in the input text file 
 */
public class yasin_yilmaz {
	/**
	 * 
	 * @param inputFile  it takes a string input which is our data file name
	 * @return  it returns an integer array which is contain numbers
	 * This method takes an data file and checks how many lines it has. Create an array which has same length. 
	 * After that it loads numbers into our array and return that array. 
	 */
	public static int[] loadNumbers(String inputFile) {

		File file = new File(inputFile);
		Scanner input = null;
		Scanner input2 = null;
		try {
			input = new Scanner(file);
			input2 = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println(inputFile + " : Input file can not be found \nThe program is closing...");
			System.exit(1);

		}
		System.out.println("File is available");
		int lineCounter=0; 
		while(input2.hasNext()) {

			String lines ;
			lines = input2.nextLine();
			lineCounter++;
		}
		int[] numbersArray = new int[lineCounter];
		int counter=0; 
		while(input.hasNext()) {

			String line ;
			line = input.nextLine();
			line = line.trim();
			numbersArray[counter]= Integer.parseInt(line);
			counter++;


		}
		return numbersArray;
	}

	/**
	 * 
	 * @param numbers it takes an integer array which has contain numbers
	 * @return this method returns an array which contains frequency
	 * This method uses hashing algorithm. it calculates the most recurrent numbers and assign into the our array.
	 * After that it returns this array.
	 */
	public static int[] computeFrequency(int[] numbers) {
		int[] frequency = new int[1000];
		for(int i =0 ; i<numbers.length ; i++) {
			frequency[numbers[i]] += 1;
		}
		return frequency;
	}
	public static void main(String[] args) {

		//calling loadnumbers method
		int[] numbers = loadNumbers("someData.txt");
		//calling computeFrequency method
		int[] frequency = computeFrequency(numbers);
		
		//this loop try to get most recurrent number
		
		int mostRecurrent = 0;
		for(int i = 0 ; i <frequency.length;i++) {
			if(frequency[i]>= mostRecurrent) {
				mostRecurrent = frequency[i];
			}
		}
		
		//this part prints most frequent number or numbers
		
		System.out.println("Most Frequent Numbers:");
		for(int i=0 ; i<frequency.length;i++ ) {
			if(frequency[i]==mostRecurrent) {
				System.out.println("Number: " + i + ", Frequency: " + frequency[i] );
			}
		}
	}
}