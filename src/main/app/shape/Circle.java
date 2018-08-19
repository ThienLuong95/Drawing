package main.app.shape;

import java.awt.Graphics;

import main.app.shape.enums.ShapeType;

public class Circle implements Shape {
	public static final String[] CIRCLE_ATTRIBUTE_NAMES = { "X", "Y", "Radius" };
	private Coordinate position;
	private int radius;

	public Circle(Coordinate position, int radius) {
		super();
		this.position = position;
		this.radius = radius;
	}

	@Override
	public void setAttribute(int position, int value) {
		if (position == 0) {
			this.position.setX(value);
		}
		if (position == 1) {
			this.position.setY(value);
		}
		if (position == 2) {
			this.radius = value;
		}
	}

	@Override
	public Shape clone() {
		return new Circle(position, radius);
	}

	public Coordinate getPosition() {
		return position;
	}

	public void setPosition(Coordinate position) {
		this.position = position;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void print() {
		System.out.println(toString());
	}

	@Override
	public void paint(Graphics g) {
		g.drawOval(position.getX(), position.getY(), radius, radius);
	}

	@Override
	public int getAttribute(int position) {
		if (position == 0)
			return this.position.getX();
		if (position == 1)
			return this.position.getY();
		if (position == 2)
			return this.radius;
		return 0;
	}

	@Override
	public String[] getAttributesName() {
		return CIRCLE_ATTRIBUTE_NAMES;
	}

	@Override
	public String toString() {
		return "Circle [" + position + ", " + radius + "]";
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.CIRCLE;
	}

	@Override
	public void clear(Graphics g) {
		g.fillOval(position.getX(), position.getY(), radius, radius);
	}

}
