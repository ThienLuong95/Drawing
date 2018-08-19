package main.view;

import java.awt.Graphics;

public interface Painter<T> extends View<T> {
	void paint(Graphics g);
}
