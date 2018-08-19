package main.app.shape;

import java.awt.Graphics;

import main.app.shape.enums.ShapeType;
import main.view.Paintable;
import main.view.Prinable;

public interface Shape extends Prinable, Paintable{
	int getAttribute(int position);
	void setAttribute(int position, int value);
	String[] getAttributesName();
	ShapeType getShapeType();
	Shape clone();
	void clear(Graphics g);
}
