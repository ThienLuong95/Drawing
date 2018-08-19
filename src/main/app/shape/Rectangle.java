package main.app.shape;

import java.awt.Color;
import java.awt.Graphics;

import main.app.shape.enums.ShapeType;

public class Rectangle implements Shape {

	public static final String[] RECTANGLE_ATTRIBUTE_NAME = { "X", "Y", "Width", "Height" };
	private Coordinate position;
	private int width, height;

	public Rectangle(Coordinate position, int width, int height) {
		super();
		this.position = position;
		this.width = width;
		this.height = height;
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
			this.width = value;
		}
		if (position == 3) {
			this.height = value;
		}
	}

	public Shape clone() {
		return new Rectangle(position, width, height);
	}

	public Coordinate getPosition() {
		return position;
	}

	public void setPosition(Coordinate position) {
		this.position = position;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void print() {
		System.out.println(toString());
	}

	@Override
	public void paint(Graphics g) {
		g.drawRect(position.getX(), position.getY(), width, height);
	}

	@Override
	public int getAttribute(int position) {
		if (position == 0)
			return this.position.getX();
		if (position == 1)
			return this.position.getY();
		if (position == 2)
			return this.width;
		if (position == 3)
			return this.height;
		return 0;
	}

	@Override
	public String[] getAttributesName() {
		return RECTANGLE_ATTRIBUTE_NAME;
	}

	@Override
	public String toString() {
		return "Rectangle [" + position + ", " + width + ", " + height + "]";
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.RECTANGLE;
	}

	@Override
	public void clear(Graphics g) {

		g.clearRect(position.getX(), position.getY(), width, height);
		
	}



}
