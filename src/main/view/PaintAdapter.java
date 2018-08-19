package main.view;

import java.awt.Graphics;

public interface PaintAdapter<T> {
	void paint3D(Graphics g);
	void paint2D(Graphics g);
}
