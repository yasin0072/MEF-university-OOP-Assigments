import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Week06 {

	public static ArrayList<City> readTripFile (String fileName){
		ArrayList<City> tripArrayList=new ArrayList<City>();
		File file = new File(fileName);
		Scanner stdin = null;
		try {
			stdin = new Scanner(file);
		}catch(FileNotFoundException e){
			System.out.printf("Input file (%s) can not be found", fileName);
		}
		String[] tripInfo;
		while(stdin.hasNext()) {
			String line = stdin.nextLine();
			tripInfo=line.split(" ");
			double xCoordinate = Double.parseDouble(tripInfo[1]);
			double yCoordinate = Double.parseDouble(tripInfo[2]);
			String name = tripInfo[0].trim();
			City city =new City(name,xCoordinate,yCoordinate);
			tripArrayList.add(city);
		}
		return tripArrayList;
	}
	public static void printTrip(ArrayList<City> a) {
		System.out.println("Trip details:");
		double totalDistance=0;
		for(int i = 1 ;i<a.size();i++) {
			System.out.printf( "%-15s%-5s%-15s [%5.2f km]",a.get(i-1),"->",a.get(i),a.get(i-1).calculateDistance(a.get(i)));
			System.out.println();
			totalDistance+=a.get(i-1).calculateDistance(a.get(i));
			}
		System.out.printf("\n Total trip distance: " + "%.3f km",totalDistance);
		}
	
	

	public static void main(String[] args) {
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(30, 65);
		StdDraw.setYscale(-13, 35);
		String fileName="trips.txt";
		ArrayList<City> trip= readTripFile(fileName);
		printTrip(trip);
		for(int i = 1;i<trip.size();i++) {
			trip.get(i-1).drawMap(trip.get(i));
		}
		StdDraw.filledCircle(trip.get(trip.size()-1).xCoord, trip.get(trip.size()-1).yCoord, 0.3);
		StdDraw.text(trip.get(trip.size()-1).xCoord,  trip.get(trip.size()-1).yCoord+1,  trip.get(trip.size()-1).name);
		for(int i = 1;i<trip.size();i++) {
			StdDraw.setPenColor(StdDraw.BLUE);
			double x =(trip.get(i-1).xCoord+trip.get(i).xCoord)/2;
			double y =(trip.get(i-1).yCoord+trip.get(i).yCoord)/2;
			StdDraw.setPenColor(StdDraw.RED);
			double temp =trip.get(i-1).calculateDistance(trip.get(i));
			String numberAsString = String.format ("%.2f km", temp);

			String distance = String.valueOf(numberAsString);
			StdDraw.text(x+1, y, distance);
		}
	}

}
