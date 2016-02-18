package HW1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JComponent;

@SuppressWarnings("serial")

public class P3 {

/**
 * This function draw a graph, when user enters an odd number, it draws a black grid;
 * when user enters an even number, it draws a colored grid;
 * when user enters an invalid input, it gives notification
 * @param g
 */
public static void draw(Graphics g){  
			Scanner in = new Scanner(System.in);
			System.out.println("Enter Grid Dimension:");
			int GridDimension;
			// if user enter invalid input, inform that he should enter a integer
			if (!in.hasNextInt()){
				System.out.println("Please enter an integer!");
				return;
			}
			GridDimension = in.nextInt();
			
			// Check negative input
			if (GridDimension<=0){
				System.out.println("Please enter a positive integer");
				return;
			}
			// if GridDimension is an odd number, then draw the original grid
			if ( GridDimension%2 != 0 ){
				drawOrigin(g, GridDimension);
			}
			// if GridDimension is an even, draw the grid with colors
			else {
				drawColor(g, GridDimension);
			}
	
}

/**
 * This function draw a grid with color
 * @param g
 * @param GridDimension
 */
private static void drawColor(Graphics g, int GridDimension) {
	for (int row = 0; row<GridDimension/2; row++)
	{
		for (int column = 0; column<GridDimension/2; column++)
		{
			g.setColor(Color.GREEN);
			g.fillOval(row*60 + 50,column*60 + 50, 50,50);
		}
		for (int column = GridDimension/2; column<GridDimension; column++)
		{
			g.setColor(Color.BLACK);
			g.fillOval(row*60 + 50,column*60 + 50, 50,50);
		}
	}
	for (int row = GridDimension/2; row<GridDimension; row++)
	{
		for (int column = 0; column<GridDimension/2; column++)
		{
			g.setColor(Color.BLACK);
			g.fillOval(row*60 + 50,column*60 + 50, 50,50);
		}
		for (int column = GridDimension/2; column<GridDimension; column++)
		{
			g.setColor(Color.RED);
			g.fillOval(row*60 + 50,column*60 + 50, 50,50);
		}
	}
}

/**
 * This function draw the original BLACK grid
 * @param g 
 */
private static void drawOrigin(Graphics g, int GridDimension) {
	for (int row = 0;row<GridDimension;row++)
	{
		for (int column = 0;column<GridDimension;column++)
	    {
			g.setColor(Color.BLACK);
			g.fillOval(row*60 + 50,column*60 + 50, 50,50);	
	    }
	}
}

/**
 * This is the main function that draws frame
 * @param args
 */
public static void main(String[] args)
		{
			JFrame frame = new JFrame();

			final int FRAME_WIDTH = 800;
			final int FRAME_HEIGHT = 800;

			frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JComponent component = new JComponent()
			{
				public void paintComponent(Graphics graph)
				{
					draw(graph);
				}
			};     
			frame.add(component);
			frame.setVisible(true);
		}  
}
