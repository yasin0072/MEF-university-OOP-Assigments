import java.util.Random;

/**
 * @author Yasin Yýlmaz 
 * ID: 041701020
 * @since March 03, 2019
 * Program explanation: it draws circles
 *  after that it draws farthest circle pairs are drawn thicker, together with the connecting line
 */

public class Yasin_Yilmaz {
	/**
	 * 
	 * @param num it takes a integer number
	 * @return it returns an array which contains objects
	 *  This method takes an integer number after that it creates an array of objects.
	 *  Array length is same with the input number. If statement checks the circle
	 *  if circle in the canvas it creates and assigns to array and also draws, if it is not decrease one to i value
	 *  when everything finish returns array of objects
	 */
	public static Circle[] makeCircles(int num) {
		Circle[] circles= new Circle[num];
		Random r= new Random();
		for(int i = 0 ; i < circles.length ; i++) {
			double x =r.nextDouble();
			double y =r.nextDouble();
			double radius =r.nextDouble();
			if(x+radius <= 1.0 && y+radius <= 1.0 && x-radius >= 0.0 && y-radius >= 0.0) {
				circles[i]=new Circle(x,y,radius);
				circles[i].draw();
			}else
				i-=1;
		}
		return circles;
	}
	/**
	 * This method doesn't take and return anything
	 * it just sets the canvas 
	 */
	public static void setCanvas() {
		int canvasHeight=500;
		int canvasWidth=500;
		StdDraw.setCanvasSize(canvasWidth,canvasHeight);
		StdDraw.setXscale(0,1);
		StdDraw.setYscale(0,1);
		StdDraw.setPenRadius(0.003);
	}

	public static void main(String[] args) {
		setCanvas();
		Circle[] arrayOfCircles = makeCircles(100);
		
		//this part calculates the max distance from the distance method which is in the Circle class
		
		double maxDistance=0.0;
		int firstCircleIndex=0;
		int secondCircleIndex=0;
		for(int i = 0 ; i < arrayOfCircles.length ; i++) {
			for(int k= i+1 ;k < arrayOfCircles.length ; k++) {
				double temp = arrayOfCircles[i].distance(arrayOfCircles[k]);
				if (temp>maxDistance) {
					maxDistance=temp;
					firstCircleIndex=i;
					secondCircleIndex=k;
				}
			}
		}
		
		//this part draws the fartest circles with the more thickness
		
		StdDraw.setPenRadius(0.009);
		arrayOfCircles[firstCircleIndex].draw();
		arrayOfCircles[secondCircleIndex].draw();
		
		//this parts gets x and y values from the getter methods
		
		double x1=arrayOfCircles[firstCircleIndex].getX();
		double y1=arrayOfCircles[firstCircleIndex].getY();
		double x2=arrayOfCircles[secondCircleIndex].getX();
		double y2=arrayOfCircles[secondCircleIndex].getY();
		
		//this part draws a red line between the fartest circles.
		
		StdDraw.setPenRadius(0.005);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(x1, y1, x2, y2);
	}
}
