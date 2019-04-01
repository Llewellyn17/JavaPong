package pong;

import java.awt.Graphics;

interface paddle {
	public void Draw(Graphics g);
	public void move();
	public int getY();
}
