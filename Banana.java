package finalProject;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Banana extends MovingThing
{
	private int speed;
	private Image image;

	public Banana()
	{
		this(0,0,0);
	}

	public Banana(int x, int y)
	{
		this(x,y,0);
	}

	public Banana(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/finalProject/banana.jpg"));
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
   	window.drawImage(image,getX(),getY(),60,60,null);
	}

	public String toString()
	{
		return "Banana: " + super.toString() + " Monkey: " + getSpeed();
	}
}
