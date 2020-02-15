import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Yasin Yilmaz
 * ID: 041701020
 * @since April 14, 2019
 * Program explanation: This program reads data from text. according to inputs, it creates Polynomial objects.
 * After that it draw graphics of these polynomials. Then it calculates the derivative values.
 * After that it draw filled circles where derivatives are close to zero. Finally it prints all information about graphics.
 */
public class Yasin_Yilmaz {
	/**
	 * 
	 * @param fileName it takes String file which is name of data file such as "functions1.txt"
	 * @return it returns an arraylist which is contain polynomial obejcts
	 */
	public static ArrayList<Polynomial> dataRead(String fileName) {
		String filename = fileName;      
		File dataFile = new File(filename);
		Scanner stdin = null;
		try {
			stdin = new Scanner(dataFile);
		} catch (FileNotFoundException e) {
			System.out.println(filename + ": Input file can not be found!\nExiting program...");
			System.exit(1);
		}
		String line;
		ArrayList<Polynomial> data = new ArrayList<>();
		ArrayList<Double> values;
		String[] tempValues;
		while(stdin.hasNext()) {
			line =stdin.next();
			values=new ArrayList<>();
			tempValues=line.split(",");
			for(String x : tempValues)
				values.add(Double.parseDouble(x));
			if(values.size()==2) {
				Polynomial1D a = new Polynomial1D(values.get(0), values.get(1));
				data.add(a);
			}
			else if (values.size()==3) {
				Polynomial2D a = new Polynomial2D(values.get(0), values.get(1),values.get(2));
				data.add(a);
			}
			else if (values.size()==4) {
				Polynomial3D a = new Polynomial3D(values.get(0), values.get(1),values.get(2),values.get(3));
				data.add(a);
			}
		}
		return data;
	}
	/**
	 * this function just set and draw canvas
	 */
	public static void setCanvas() {
		StdDraw.setCanvasSize(500, 500);
		StdDraw.setXscale(-10.5, 10.5);
		StdDraw.setYscale(-10.5, 10.5);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(0, -10, 0, 10);
		StdDraw.line(-10, 0, 10, 0);
		for(int i =0;i<21;i++) {
			StdDraw.line(0-0.1, i-10, 0+0.1, i-10);
			StdDraw.text(0.5, i-10, String.format("%d", i-10));
		}
		for(int i =0;i<21;i++) {
			StdDraw.line(i-10, 0-0.1, i-10, 0+0.1);
			StdDraw.text(i-10, 0.5,String.format("%d", i-10));
		}
	}
	
	/**
	 * 
	 * @param functions this method takes an arraylist which contains polynomial objects and draws graphics
	 */
	public static void drawGraph(ArrayList<Polynomial> functions) {
		for (Polynomial x : functions) {
			for (double i = -9.9;i<10.0;i+=0.01) {
				double y = x.evaluate(i);
				x.setX(i);
				x.setY(y);
			}
			x.draw();
			System.out.println(x.toString());
			x.derivative(-10, 10);
		}
	}
	public static void main(String[] args) {	
		ArrayList<Polynomial> arrayListOfValuesArrayList =dataRead("functions4.txt");
		setCanvas();
		drawGraph(arrayListOfValuesArrayList);


	}
}
