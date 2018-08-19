package main.app.shape;

import java.awt.Graphics;

import main.app.shape.enums.ShapeType;

public class Rectangle3D implements Shape3D {
	private Rectangle rectangle;
	private int depth;

	public Rectangle3D(Rectangle rectangle, int depth) {
		super();
		this.rectangle = rectangle;
		this.depth = depth;
	}
	
	@Override
	public void setAttribute(int position, int value) {
		rectangle.setAttribute(position, value);
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public void print() {
		System.out.println();
	}

	@Override
	public void paint(Graphics g) {
		rectangle.paint(g);
	}

	@Override
	public void paint3D(Graphics g) {
		g.fill3DRect(rectangle.getPosition().getX(), rectangle.getPosition().getY(), rectangle.getWidth(),
				rectangle.getHeight(), false);
	}

	@Override
	public int getAttribute(int position) {
		return rectangle.getAttribute(position);
	}

	@Override
	public String[] getAttributesName() {
		return Rectangle.RECTANGLE_ATTRIBUTE_NAME;
	}

	@Override
	public ShapeType getShapeType() {
		return rectangle.getShapeType();
	}

	@Override
	public Shape clone() {
		return new Rectangle3D(rectangle, depth);
	}

	@Override
	public void clear(Graphics g) {
		
	}
}
