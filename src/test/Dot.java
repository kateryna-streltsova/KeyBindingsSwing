package test;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Dot extends JPanel {
	private int x;
	private int y;
	private int r;
	
	public int getX() {
		return x;
	}
	public Dot(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.println(x);
		g.setColor(Color.red);
		g.fillOval(x, y, r, r);
		//g.drawOval(x, y, r, r);
	}
}
