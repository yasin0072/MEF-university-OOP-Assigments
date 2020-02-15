
public class City {
	public String name;
	public double xCoord;
	public double yCoord;

	City(String name, double xCoord, double yCoord) {
		this.name = name;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public double calculateDistance(City destinationCity) {
		double distance;
		double xValue=Math.abs(destinationCity.xCoord-xCoord);
		double yValue=Math.abs(destinationCity.yCoord-yCoord);
		distance = Math.sqrt(Math.pow(xValue,2) + Math.pow(yValue, 2));
		return distance;
	}
	public String toString() {
		return name;
	}
	public void drawMap(City a) {
		StdDraw.filledCircle(xCoord, yCoord, 0.3);
		StdDraw.line(xCoord, yCoord, a.xCoord, a.yCoord);
		StdDraw.text(xCoord, yCoord+1, name);
	}
	/*
	 * public void drawDistance(City a) {
	 
		double x=(this.xCoord+a.xCoord)/2;
		double y=(this.yCoord+a.yCoord)/2;
		StdDraw.setPenColor(StdDraw.RED);
		//StdDraw.text(x, y, );
	}
*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getxCoord() {
		return xCoord;
	}

	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}

	public double getyCoord() {
		return yCoord;
	}

	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}
}
