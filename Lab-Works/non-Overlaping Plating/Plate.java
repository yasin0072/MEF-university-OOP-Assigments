import java.awt.Color;

public class Plate {

	private double x;
	private double y;
	private double r;
	private Color color;

	Plate(double x, double y, double r,Color color) {
		this.x = x;
		this.y=y;
		this.r=r;
		this.color=color;

	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void draw() {

		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, r);
	}
	
	public double distance(Plate p) {
		double distance;
		double xValue=Math.abs(p.x-x);
		double yValue=Math.abs(p.y-y);
		distance = Math.sqrt(Math.pow(xValue,2) + Math.pow(yValue, 2));
		return distance;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getR() {
		return r;
	}
	public void move() {
		
		StdDraw.pause(200);
		StdDraw.clear();
		StdDraw.filledCircle(x, y, r);
	}
}
