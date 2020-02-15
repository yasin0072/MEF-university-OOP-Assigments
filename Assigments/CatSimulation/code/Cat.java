import java.awt.Color;

public class Cat {
	private int x;
	private int y;
	private Color color;
	private int foodCount=0;
	
	Cat(int x,int y ,Color color){
		this.x=x;
		this.y=y;
		this.color=color;
	}
	public void draw(){
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x+0.5, y+0.5, 0.3);
		StdDraw.show();
	}
	public void move(int direction) {
		StdDraw.setPenColor(StdDraw.WHITE);
		if (direction==0) {
			StdDraw.filledCircle(x+0.5,y+0.5,0.4);
			y-=1;
		}
		else if (direction==1) {
			StdDraw.filledCircle(x+0.5,y+0.5,0.4);
			y+=1;
		}else if (direction==2) {
			StdDraw.filledCircle(x+0.5,y+0.5,0.4);
			x-=1;
		}else if (direction==3) {
			StdDraw.filledCircle(x+0.5,y+0.5,0.4);
			x+=1;
		}
		
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount += foodCount;
	}
}
