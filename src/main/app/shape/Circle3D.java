package main.app.shape;

import java.awt.Graphics;

import main.app.shape.enums.ShapeType;

public class Circle3D implements Shape3D {
	@Override
	public void setAttribute(int position, int value) {
		circle.setAttribute(position, value);
	}

	private Circle circle;
	private int depht;
	
	public Circle3D(Circle circle, int depht) {
		super();
		this.circle = circle;
		this.depht = depht;
	}
	public Shape clone() {
		return new Circle3D(circle, depht);
	}
	
	@Override
	public ShapeType getShapeType() {
		return circle.getShapeType();
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public int getDepht() {
		return depht;
	}

	public void setDepht(int depht) {
		this.depht = depht;
	}

	@Override
	public void print() {
		circle.print();
	}

	@Override
	public void paint(Graphics g) {
		circle.paint(g);
	}

	@Override
	public void paint3D(Graphics g) {
		g.fillOval(circle.getPosition().getX(), circle.getPosition().getY(), circle.getRadius(), circle.getRadius());
	}

	@Override
	public int getAttribute(int position) {
		return circle.getAttribute(position);
	}
	
	@Override
	public String[] getAttributesName() {
		return Circle.CIRCLE_ATTRIBUTE_NAMES;
	}
	@Override
	public void clear(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
