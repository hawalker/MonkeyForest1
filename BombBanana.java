package finalProject;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class BombBanana extends MovingThing
{
	private int speed;
	private Image image;


	public BombBanana()
	{
		this(0,0,0);
	}

	public BombBanana(int x, int y)
	{
		this(x,y,0);
	}
	
	public BombBanana(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/finalProject/bombBanana.jpg"));
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
		 window.drawImage(image,getX(),getY(),30,30,null);

	}

	public String toString()
	{
		return "Bad Banana Speed: " +getSpeed();
	}
}
