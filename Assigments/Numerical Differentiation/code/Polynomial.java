import java.util.ArrayList;
/**
 * 
 * @author Yasin yýlmaz
 * this class superclass of other classes
 */
public class Polynomial {
	private ArrayList<Double> x=new ArrayList<>();
	private ArrayList<Double> y=new ArrayList<>();
	private final double h=0.0001;

	Polynomial(){}
	public double evaluate (double x) {
		return 0.0;
	}
	public void draw() {
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		for(int i = 0;i<x.size();i++) {
			StdDraw.filledCircle(x.get(i), y.get(i), h*300);
		}
	}
	public ArrayList<Double> derivative (double xMin,double xMax){
		ArrayList<Double> derivativeValues = new ArrayList<>();
		ArrayList<Double> tempX=new ArrayList<>();
		for (double i = xMin; i < xMax ; i += 0.001) {
			int counter=0;
			double temp=Math.abs((evaluate(i+h)-evaluate(i))/h);
			if(temp<0.0004) {
				//System.out.println(temp);
				derivativeValues.add((evaluate(i+h)-evaluate(i))/h);
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.filledCircle(i,evaluate(i) ,0.1);
				tempX.add(i);
			}
		}
		if(tempX.size()>0) {
			System.out.println("Points with zero derivatives:");
			if(tempX.size()>1) {
				if(tempX.size()==2) {
					int a = (int)(tempX.get(tempX.size()-2)*100);
					int b =(int)(tempX.get(tempX.size()-1)*100);
					if(a!=b) {
						System.out.printf(" x: %.2f y: %.2f \n\n",tempX.get(0),evaluate(tempX.get(0)));
						System.out.printf(" x: %.2f y: %.2f \n\n",tempX.get(1),evaluate(tempX.get(1)));
					}else {
						System.out.printf(" x: %.2f y: %.2f \n\n",tempX.get(0),evaluate(tempX.get(0)));
					}
				}else if (((int)(tempX.get(0)*10)!=(int)(tempX.get(tempX.size()-1)*10))){
					System.out.printf(" x: %.2f y: %.2f \n\n",tempX.get(0),evaluate(tempX.get(0)));
					System.out.printf(" x: %.2f y: %.2f \n\n",tempX.get(tempX.size()-1),evaluate(tempX.get(tempX.size()-1)));
				}else {
					System.out.printf(" x: %.2f y: %.2f \n\n",tempX.get(0),evaluate(tempX.get(0)));
				}
			}else {
				System.out.printf(" x: %.2f y: %.2f \n\n",tempX.get(0),evaluate(tempX.get(0)));
			}
		}
		return derivativeValues;

	}
	public void setX(double x) {
		this.x.add(x);
	}
	public void setY(double y) {
		this.y.add(y);
	}
}