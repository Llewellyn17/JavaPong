package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball2 {
double xVel, yVel, x, y;

	public Ball2() {
	x = 450;
	y = 270;
	xVel = -4;
	yVel = 0.1;
			
	}
	public void draw (Graphics g) {
	g.setColor(Color.blue);
	g.fillOval((int)x-10, (int)y-10, 20, 20);
	}
	public void checkPaddleCollision(paddle p1, paddle p2) {
		if (x <= 50) {
			if(y>=p1.getY() && y <=p1.getY() + 80)
				xVel = -xVel;
		}else if (x >= 650) {
			if(y>=p2.getY() && y <=p2.getY() + 80)
				xVel = -xVel;
		}
			
	}
	public void move() {
	x -= xVel;
	y += yVel;
	if(y<10)
		yVel = -yVel;
	if(y>490)
		yVel = -yVel;
	if(x>690)
		xVel = -xVel;
	}
	public int getX() {
	return (int)x;
	}
	public int getY() {
	return (int)y;
	}


		
}
