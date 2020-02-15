import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

public class Week04NonoverlappingPlates {

	public static Color colors(int a) {
		Color[] colors = new Color[9];
		colors[0]= StdDraw.MAGENTA;
		colors[1]= StdDraw.BLUE;
		colors[2]= StdDraw.YELLOW;
		colors[3]= StdDraw.GREEN;
		colors[4]= StdDraw.BLACK;
		colors[5]= StdDraw.PINK;
		colors[6]= StdDraw.ORANGE;
		colors[7]= StdDraw.RED;
		colors[8]= StdDraw.DARK_GRAY;
		return colors[a];
	}
	public static void setCanvas() {
		int canvasHeight=500;
		int canvasWidth=500;
		StdDraw.setCanvasSize(canvasWidth,canvasHeight);
		StdDraw.setXscale(0,1);
		StdDraw.setYscale(0,1);
	}
	public static Plate[] createPlates(int a) {
		Random randomColor= new Random();
		Random randomValue= new Random();
		Plate[] plateArray = new Plate[a];
		for (int i=0; i<plateArray.length;i++) {
			double radius = randomValue.nextDouble();
			if (radius >= 0.01 && radius <= 0.1) {
				double x = randomValue.nextDouble();
				double y = randomValue.nextDouble();
				int circleColor =randomColor.nextInt(9); 

				if(x+radius <= 1.0 && y+radius <= 1.0 && x-radius >= 0.0 && y-radius >= 0.0) {
					plateArray[i]=new Plate(x,y,radius,colors(circleColor));
					for(int k = i-1 ; k>=0;k--) {
						if (plateArray[k].distance(plateArray[i]) <= (plateArray[k].getR() + plateArray[i].getR())) {
							i-=1;
							break;
						}
					}
				}
				else {
					i-=1;
					continue;
				}
			}
			else {
				i-=1;
				continue;
			}
		}
		//while(true) {
		for (int i = 0 ; i<plateArray.length;i++) {
			//Random secondRandomColor= new Random();
			//int secondCircleColor = secondRandomColor.nextInt(8);
			//plateArray[i].setColor(colors(secondCircleColor));
			plateArray[i].draw();
		}
		return plateArray;
	}

	/*
	 I tried to move circles here 
	 
	public static void moveCircles(Plate[] plates) {
		Random r =new Random();
		int i;
		
		for(i =0; i<plates.length;i++) {
			while (true) {
				double newX=plates[i].getX();
				double newY=plates[i].getY();
				double tempX = r.nextDouble();
				double tempY = r.nextDouble();
				double radius=plates[i].getR();
				if(tempX+newX+radius <= 1.0 && newY+tempY+radius <= 1.0 && newX-tempX-radius>= 0.0 && newY-tempY-radius >= 0.0) {
					if(r.nextInt()%2==0){
						newX+=tempX;
						newY+=tempY;
					}else {
						newX-=tempX;
						newY-=tempY;
					}
					plates[i].setX(newX);
					plates[i].setY(newY);
					plates[i].move();
				}
			}
		}
	}

	 */

	public static void main(String[] args) {
		//StdDraw.enableDoubleBuffering();
		Scanner input=new Scanner(System.in);
		System.out.print("How many filled circles do you want to draw: ");
		int number = input.nextInt();
		setCanvas();
		Plate[] a =createPlates(number);	
		StdDraw.show();
		//moveCircles(a);
	}
}
