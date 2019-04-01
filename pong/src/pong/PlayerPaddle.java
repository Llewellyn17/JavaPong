package pong;

import java.awt.Color;
import java.awt.Graphics;

public class PlayerPaddle implements paddle {
	double y, yVel;
	boolean upAccel, downAccel;
	final double GRAVITY = 0.54;
	int player, x;
	
	public PlayerPaddle (int player) {
		upAccel = true ; downAccel = true;
		y = 210; yVel = 0;
		if (player == 1)
			x = 20;
		else
			x = 660;
	}
	public void draw(Graphics g) {
	 g.setColor(Color.white);
	 g.fillRect(10, (int)y, 20, 80);
	}

	public void move() {
		if (upAccel) {
			yVel = -1;
		}
		else if (downAccel) {
			yVel = +1;
		}
		else if (!upAccel && !downAccel) {
			yVel *= GRAVITY;
		}
		if(yVel >= 5)
			yVel = 5;
		else if(yVel >= -5)
			yVel = -5;
		
		if(y<0)
			y = 0;
		if(y>420)
			y = 420;
	}
	public void setUpAccel (boolean input) {
		upAccel = input;
	}
	public void setDownAccel (boolean input) {
		downAccel = input;
	}

	public int getY() {
		return (int)y;
	}
	public void Draw(Graphics g) {
		
	}

}
