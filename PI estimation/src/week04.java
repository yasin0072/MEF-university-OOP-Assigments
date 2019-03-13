import java.util.Random;
import java.util.function.DoubleFunction;

public class week04 {
	public static void drawBigCircle() {
		int canvasHeight=500;
		int canvasWidth=500;
		StdDraw.setCanvasSize(canvasWidth,canvasHeight);
		StdDraw.setXscale(0,1);
		StdDraw.setYscale(0,1);
		double bigCircleX=0.5;
		double bigCircleY=0.5;
		double bigCircleRadius=0.5;
		double circleThickness=0.006;
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.setPenRadius(circleThickness);
		StdDraw.circle(bigCircleX, bigCircleY, bigCircleRadius);
		StdDraw.show();
	}
	public static void drawTinyCircles(int number) {
		final double PI=3.1415;
		int counterInside=0;
		for(int i =0; i < number ;i++) {
			double circleRadius=0.005;
			Random x=new Random();
			double circleX=x.nextDouble();
			double circleY=x.nextDouble();
			double absoluteX=Math.abs(circleX-0.5);
			double absoluteY=Math.abs(circleY-0.5);
			if (Math.sqrt((Math.pow( absoluteX,2) + Math.pow(absoluteY, 2)))<0.5) {
				counterInside += 1;
				StdDraw.setPenColor(StdDraw.GREEN);
			}else
				StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledCircle(circleX, circleY, circleRadius);
		
		}
		System.out.println("Ratio of areas=" + 1/(PI*0.5*0.5));
		System.out.println("Ratio of circles= " + number*1.0/counterInside);
		System.out.println("Ratio of inside / total X radius X radius " + counterInside*1.0/(number*0.5*0.5));
		System.out.println("Pi number is= " + PI);
	}

	public static void main(String[] args) {
		drawBigCircle();
		drawTinyCircles(10000);
	}
}

