
public class Polynomial1D extends Polynomial{
	private double a;
	private double b;

	Polynomial1D(double a, double b) {
		this.a=a;
		this.b=b;
	}
	public double evaluate (double x) {
		return a+b*x;
	}
	@Override
	public String toString() {
		 return "Function: (" + a + ") + (" + b + ")x";
		
	}
}
