
public class Polynomial3D extends Polynomial{
	private double a;
	private double b;
	private double c;
	private double d;
	Polynomial3D(double a,double b,double c,double d){
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
	}
	public double evaluate(double x) {
		return a+b*x+c*Math.pow(x, 2)+d*Math.pow(x, 3);
		
	}
	@Override
	public String toString() {
		 return"Function: (" + a + ") + (" + b + ")x (" + c +")x^2 + (" + d + ")x^3";
		
	}
}
