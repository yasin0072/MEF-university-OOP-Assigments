import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
/**
 * @author Yasin Yýlmaz 
 * ID: 041701020
 * @since March 26, 2019
 * Firstly this code takes map data from the text file and creates the same map.
 * In this map there are 4 different area such as food, sea, wall and 
 * After that it tries to create a cat which moves randomly,however this cat can not go to the water or mountain.
 * If the cat is near to any food resource, it eats food directly when the cat eat a food food resource removes from the world.
 *  
 *
 */
public class Yasin_Yilmaz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//StdDraw.enableDoubleBuffering();
		String filename = "world.txt";       

		File worldFile = new File(filename);

		Scanner stdin = null;

		try {

			stdin = new Scanner(worldFile);

		} catch (FileNotFoundException e) {

			System.out.println(filename + ": Input file can not be found!\nExiting program...");

			System.exit(1);
		}
		int counter=0;
		int[] worldSize=new int[2];
		String line = stdin.nextLine();
		while(counter<2) {
			String[] arr=new String[2];
			line = line.trim();
			arr=line.split(" ");
			worldSize[counter]= Integer.parseInt(arr[counter]);
			counter++;
		}
		int[][] worldArray=new int[worldSize[0]][worldSize[1]];
		while(stdin.hasNext()) {
			for(int i = 0 ;i< worldSize[0];i++) {
				line = stdin.nextLine();
				line = line.trim();
				String[] a =new String[worldSize[0]];
				a=line.split(";");
				for(int k = 0; k < a.length ;k++) {
					worldArray[i][k]=Integer.parseInt(a[k]);
				}
			}
		}
		StdDraw.setCanvasSize(600,600);
		StdDraw.setXscale(0,worldSize[0]);
		StdDraw.setYscale(worldSize[0],0);
		for(int i =0;i<worldSize[0];i++) {
			for (int k =0 ; k<worldSize[0];k++) {
				if(worldArray[k][i]==0) {
					StdDraw.setPenRadius(0.0005);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.square(i+0.5, k+0.5,0.49 );
				}else if(worldArray[k][i]==1) {
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledSquare(i+0.5, k+0.5,0.49 );
				}else if(worldArray[k][i]==2) {
					StdDraw.setPenColor(StdDraw.BOOK_BLUE);
					StdDraw.filledSquare(i+0.5, k+0.5,0.49 );
				}else if(worldArray[k][i]==3) {
					StdDraw.setPenColor(StdDraw.MAGENTA);
					StdDraw.filledSquare(i+0.5, k+0.5,0.49 );
				}
			}
		}
		
		Cat a = new Cat(11,12,StdDraw.RED);
		a.draw();
		int stepValue=20000;
		Random r = new Random();
		for (int j =0;j<stepValue;j++) {
			StdDraw.setPenColor(StdDraw.WHITE);
			if(worldArray[a.getY()+1][a.getX()]==3) {
				
				worldArray[a.getY()+1][a.getX()]=0;
				StdDraw.filledSquare(a.getX()+0.5, a.getY()+1+0.5, 0.49);
				a.move(1);
				a.setFoodCount(1);
			}
			else if(worldArray[a.getY()-1][a.getX()]==3) {
				
				worldArray[a.getY()-1][a.getX()]=0;
				StdDraw.filledSquare(a.getX()+0.5, a.getY()-1+0.5, 0.49);
				a.move(0);
				a.setFoodCount(1);
			}else if(worldArray[a.getY()][a.getX()-1]==3) {
				
				worldArray[a.getY()][a.getX()-1]=0;
				StdDraw.filledSquare(a.getX()-1+0.5, a.getY()+0.5, 0.49);
				a.move(2);
				a.setFoodCount(1);
			}else if(worldArray[a.getY()][a.getX()+1]==3) {
				
				worldArray[a.getY()][a.getX()+1]=0;
				StdDraw.filledSquare(a.getX()+1+0.5, a.getY()+0.5, 0.49);
				a.move(3);
				a.setFoodCount(1);
			}else {
				int direction = r.nextInt(4);
				if ((direction == 0) && a.getY()>0 && worldArray[a.getY()-1][a.getX()]!=1 && worldArray[a.getY()-1][a.getX()]!=2) {
					a.move(direction);
				}else if(direction==1 && a.getY()<worldSize[0] && worldArray[a.getY()+1][a.getX()]!=1 && worldArray[a.getY()+1][a.getX()]!=2 ) {
					a.move(direction);
				}else if(direction==2 && a.getX()>0 && worldArray[a.getY()][a.getX()-1]!=1 && worldArray[a.getY()][a.getX()-1]!=2) {
					a.move(direction);
				}else if(direction==3 && a.getY()<worldSize[0] && worldArray[a.getY()][a.getX()+1]!=1 && worldArray[a.getY()][a.getX()+1]!=2) {
					a.move(direction);
				}
			}
			a.draw();
			StdDraw.pause(10);
		}
	}
}


