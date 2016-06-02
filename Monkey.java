package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Monkey extends MovingThing {
	private int speed;
	private Image image;

	public Monkey()
	{
		this(0,0,0);
	}

	public Monkey(int x, int y)
	{
		this(x,y,0);
	}

	public Monkey(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/finalProject/cartoon-monkey.jpg"));
		}
		catch(Exception e)
		{
		
		}
	}


	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),90,90,null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
