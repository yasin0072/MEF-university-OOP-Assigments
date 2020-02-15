
public class Polynomial2D extends Polynomial{
	private double a;
	private double b;
	private double c;

	Polynomial2D(double a, double b,double c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public double evaluate(double x) {
		return a+b*x+c*Math.pow(x, 2);

	}
	@Override
	public String toString() {
		return "Function: (" + a + ") + (" + b + ")x (" + c +")x^2";
	}
}
