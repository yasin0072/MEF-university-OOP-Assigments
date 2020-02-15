public class Circle {

	private double x;
	private double y;
	private double r;

	/**
	 * 
	 * @param x takes a double value
	 * @param y takes a double value
	 * @param r takes a double value
	 * this is a constructor which takes 3 double value and assign them to x y r class variable
	 */
	Circle (double x ,double y ,double r){
		this.x = x;
		this.y = y;
		this.r = r;
	}

	/**
	 * this method tries to draw a circle
	 */
	public void draw() {
		StdDraw.circle(x, y, r);		
	}
	/**
	 * 
	 * @param a  it takes a object
	 * @return   it returns a double value
	 * this method takes a circle object and calculates and returns the distance between the two circles.
	 */
	public double distance(Circle a) {
		double distance;
		double xValue=Math.abs(a.x-x);
		double yValue=Math.abs(a.y-y);
		distance = Math.sqrt(Math.pow(xValue,2) + Math.pow(yValue, 2));
		return distance;
	}
	/**
	 * 
	 * @return it returns a double value
	 * this method returns x value
	 */
	public double getX() {
		return x;
	}
	/**
	 * 
	 * @return it returns a double value
	 * this method returns y value
	 */
	public double getY() {
		return y;
	}
}