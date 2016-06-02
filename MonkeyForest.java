package finalProject;


import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class MonkeyForest extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private BufferedImage back;


	public MonkeyForest(){
		
		super("MONKEYFOREST");
		setSize(WIDTH,HEIGHT);


		Forest theGame = new Forest();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
		//update(window);
	}
	
	

	public static void main( String args[] ){
		MonkeyForest run = new MonkeyForest();
	}
}