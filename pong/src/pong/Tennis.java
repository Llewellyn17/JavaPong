package pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener{
	final int WIDTH = 700, HEIGHT = 500;
	Thread thread;
	PlayerPaddle p1;
	Ball b1;
	boolean gameStarted;
	public void init() {
		this.resize(WIDTH, HEIGHT);
		gameStarted = false;
		this.addKeyListener(this);
		p1 = new PlayerPaddle(1);
		b1 = new Ball();
		thread = new Thread(this);
		thread.start();
		setFocusable(true);
	}
public void paint (Graphics g) {
	g.setColor(Color.black);
	g.fillRect(0, 0, WIDTH, HEIGHT);
	if(b1.getX() < -10 || b1.getX() >710) {
		g.setColor(Color.red);
		g.drawString("Game Over", 350, 250);
	} else {
	p1.draw(g);
	b1.draw(g);
	}
	if(!gameStarted) {
		g.setColor(Color.white);
		g.drawString("Pong version 0.5", 340, 100);
		g.drawString("       Press Enter to Start", 310, 130);
	}
	
}
public void update(Graphics g) { 
	paint(g);
	}

public void keyPressed(KeyEvent e) { 
	int key = e.getKeyCode();
	if(key == KeyEvent.VK_UP) {
	p1.x = 0;
	p1.y -= 20;
}
	else if (key == KeyEvent.VK_DOWN) {
		p1.x = 0;
		p1.y += 20 ;
	} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		gameStarted = true;
	}
}
	
public void keyReleased(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_UP) {
		p1.setUpAccel(false);
}
	else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		p1.setDownAccel(false);
	}

}

public void run() {
	for(;;) {
		if (gameStarted) {
		p1.move();
		b1.move();
		b1.checkPaddleCollision(p1, p1);
		}
		repaint();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		}
}
public void keyTyped(KeyEvent e) {
	
}
}
