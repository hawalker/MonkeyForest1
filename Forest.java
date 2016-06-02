package finalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Forest extends Canvas implements KeyListener, Runnable {
	private int score = 0;
	private Monkey monkey;
	private Banana banana;
	private Banana bananaOne;
	private Banana bananaTwo;
	private BombBanana bombOne;
	private BombBanana bombTwo;
	private Coconut coconut;
	private Coconut coconut1;

	private ArrayList<Coconut> coconuts;
	private static int istart = 1;


	private ArrayList<Banana> bananas;
	private ArrayList<BombBanana> bombs;

	private boolean[] keys;
	private BufferedImage back;

	public Forest() {
		bananas = new ArrayList<Banana>();
			bananas.add(new Banana(700, 15, 2));
			bananas.add(new Banana(350, 0, 1));
			bananas.add(new Banana(100, 10, 3));
			bananas.add(new Banana(200, 0, 4));

		keys = new boolean[5];
		monkey = new Monkey(450, 450, 4);
		
		bananaOne = new Banana(250, 0, 3);
		bananaTwo = new Banana(375, 20, 2);
		banana = new Banana(550, 150);
		
		bombTwo = new BombBanana(250, 20, 1);
		bombOne = new BombBanana(550, 205);
		
		coconut = new Coconut(100, 0, 1);
		coconut1 = new Coconut(550, 275);
		coconuts = new ArrayList<Coconut>();
		coconuts.add(new Coconut(200, 50, 2));
		coconuts.add(coconut);

		bombs = new ArrayList<BombBanana>();
		bombs.add(new BombBanana(125, 75, 2));
		bombs.add(bombTwo);

		setBackground(Color.WHITE);

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {

		Graphics2D twoDGraph = (Graphics2D) window;

		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		Graphics graphToBack = back.createGraphics();

		// graphToBack.setColor(Color.BLUE); //GAME SCREEN
		// graphToBack.fillRect(0, 0, 800, 600);

		if (keys[0] == true) {
			if (monkey.getX() > 5) {
				monkey.move("LEFT");
			}
		}
		if (keys[1] == true) {
			if (monkey.getX() < 750) {
				monkey.move("RIGHT");
			}
		}
		if (keys[2] == true) {
			if (monkey.getY() > 10) {
				monkey.move("DOWN");
			}
		}
		if (keys[3] == true) {
			if (monkey.getY() < 500) {
				monkey.move("UP");
			}
		}
		if (keys[4] == true) {
			istart = 1;
			
		}

		if (istart == 1) {
			istart = 0;
			graphToBack.setColor(Color.WHITE); // GAME SCREEN
			graphToBack.fillRect(0, 0, 800, 600);
			twoDGraph.drawImage(back, null, 0, 0);

			graphToBack.setColor(Color.BLACK);
			graphToBack.setFont(new Font("TimesRoman", Font.BOLD, 25));
			graphToBack.drawString("Monkey Forest made by Hannah Walker", 60, 80);

			graphToBack.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			graphToBack.drawString("Welcome to Monkey Forest!! ", 60, 110);
			graphToBack.drawString("To win in Monkey Forest you must reach 20 points.", 60, 150);
			graphToBack.drawString("You get 2 points by eating bananas that look like this -->", 60, 190);
			graphToBack.drawString("But, be wary of bad bananas that make you lose 1 point -->", 60, 220);
			graphToBack.drawString("Also, don't get hit by a coconut or you will die!!!!", 60, 260);

			twoDGraph.drawImage(back, null, 0, 0);
			monkey.draw(window);
			coconut1.draw(window);
			banana.draw(window);
			bombOne.draw(window);

			long start = System.currentTimeMillis();
			long end = start + 10 * 1000; // 60 seconds * 1000 ms/sec
			System.out.println("Waiting 10 seconds ...");
			while (System.currentTimeMillis() < end) {
			}
			System.out.println("*** Finished waiting");
		}

		graphToBack.setColor(Color.BLACK);
		graphToBack.drawString("Monkey Forest", 50, 80);

		graphToBack.setColor(new Color(0, 100, 0)); // GAME SCREEN
		graphToBack.fillRect(0, 0, 800, 600);

		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("Monkey Forest ", 30, 60);

		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("Score: "+score, 30, 90);
		
		for (int i = 0; i < bananas.size(); i++) { // makes the bananas move down
			bananas.get(i).draw(graphToBack);
			if (bananas.get(i).getX() <= 800) {
				if (bananas.get(i).getY() >= 700) {
					// Put random number in new .setX line below
					bananas.get(i).setY(bananas.get(i).getY() - 600);
					int xp = (int) (Math.random() * 800.);
					//System.out.println(xp);
					bananas.get(i).setX(xp);
				}
			}
			bananas.get(i).move("UP");
		}

		for (int i = 0; i < bombs.size(); i++) { // makes the bad bananas move down
			bombs.get(i).draw(graphToBack);
			if (bombs.get(i).getX() <= 800) {
				if (bombs.get(i).getY() >= 700) {
					bombs.get(i).setY(bombs.get(i).getY() - 600);
					int xp = (int) (Math.random() * 800.);
					//System.out.println(xp);
					bombs.get(i).setX(xp);
				}
			}
			bombs.get(i).move("UP");
		}

		for (int i = 0; i < coconuts.size(); i++) { // makes the coconuts move down
			coconuts.get(i).draw(graphToBack);
			if (coconuts.get(i).getX() <= 800) {
				if (coconuts.get(i).getY() >= 700) {
					coconuts.get(i).setY(coconuts.get(i).getY() - 600);
					int xp = (int) (Math.random() * 800.);
					//System.out.println(xp);
					coconuts.get(i).setX(xp);
				}
			}
			coconuts.get(i).move("UP");

		}

		for (int i = 0; i < bananas.size(); i++) {
			bananas.get(i).draw(graphToBack);
			if ((bananas.get(i).getX() > monkey.getX() && bananas.get(i).getX() < monkey.getX() + 50)
					&& (bananas.get(i).getY() > monkey.getY() && bananas.get(i).getY() < monkey.getY() + 50)) {
				System.out.println("yummy!");
				bananas.remove(i);
				score += 2;
				System.out.println("Score: " + score);
				bananas.add(new Banana((int)(Math.random()*800), 0, (int)(Math.random()*3)+1));
			}
		}

		for (int i1 = 0; i1 < coconuts.size(); i1++) {
			coconuts.get(i1).draw(graphToBack);
			monkey.draw(graphToBack);
			if ((coconuts.get(i1).getX() > monkey.getX() && coconuts.get(i1).getX() < monkey.getX() + 50)
					&& (coconuts.get(i1).getY() > monkey.getY() && coconuts.get(i1).getY() < monkey.getY() + 50)) {
				graphToBack.setColor(Color.BLUE);
				graphToBack.fillRect(0, 0, 800, 600);

				graphToBack.setFont(new Font("Courier New", Font.BOLD, 30));
				graphToBack.setColor(Color.RED);
				graphToBack.drawString("YOU LOSE!!!", 200, 200);

				graphToBack.setFont(new Font("Courier New", Font.BOLD, 30));
				graphToBack.setColor(Color.RED);
				graphToBack.drawString("Final Score:  " + score, 200, 300);

				twoDGraph.drawImage(back, null, 0, 0);
				System.out.println("YOU DIED!!!");
				System.out.println("Final Score: " + score);

				long start = System.currentTimeMillis();
				long end = start + 10 * 1000; // 60 seconds * 1000 ms/sec
				System.out.println("Waiting 20 seconds ...");
				while (System.currentTimeMillis() < end) {
				}
				System.out.println("*** Finished waiting");
			}
			coconuts.get(i1).move("UP");
		}

		for (int j = 0; j < bombs.size(); j++) {
			bombs.get(j).draw(graphToBack);
			bombs.get(j).move("UP");
			if ((monkey.getX() < bombs.get(j).getX() && monkey.getX() + 50 > bombs.get(j).getX())
					&& (monkey.getY() < bombs.get(j).getY() && monkey.getY() + 50 > bombs.get(j).getY())) {
				bombs.remove(j);
				System.out.println("OH NO! Bad Banana!!");
				score -= 1;
				System.out.println("Score: " + score);
				bombs.add(new BombBanana((int)(Math.random()*800), 0, (int)(Math.random()*3)+1));

			}
		}

		if (score >= 20){
	
			graphToBack.setColor(Color.MAGENTA);
			graphToBack.fillRect(0, 0, 800, 600);

			graphToBack.setFont(new Font("Courier New", Font.BOLD, 30));
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString("YOU WON!!! \n HOORAY!!", 200, 200);

			long start = System.currentTimeMillis();
			long end = start + 15 * 1000; // 60 seconds * 1000 ms/sec
			System.out.println("Waiting 15 seconds ...");
			score = 0;
			
			twoDGraph.drawImage(back, null, 0, 0);
			monkey.draw(graphToBack);
			while (System.currentTimeMillis() < end) {
			}
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
		monkey.draw(window);

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e) {

	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}
