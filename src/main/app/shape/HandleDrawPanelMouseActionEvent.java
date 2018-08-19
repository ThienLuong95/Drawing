package main.app.shape;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.app.shape.action.ActionAddShape;
import main.controller.Executeable;
import main.controller.HandelAtionEvent;

public class HandleDrawPanelMouseActionEvent extends HandelAtionEvent<Shape> implements MouseListener, MouseMotionListener{
	private int lastX, lastY;
	private App app;
	Shape shape;
	public HandleDrawPanelMouseActionEvent(Executeable<Shape> executeable, App app) {
		super(executeable);
		this.app=app;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		shape= App.getShape(new Coordinate(e.getX(), e.getY()), 0,0,0);
		
    }
	@Override
	public void mouseReleased(MouseEvent e) {
			if(shape.getAttribute(2)>0 )
			executeable.execute(new ActionAddShape(shape));
	}
	private int getDistane(int lastX, int x) {
		return x-lastX;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g= app.getDrawPane().getGraphics();
	
		shape.setAttribute(2, getDistane(shape.getAttribute(0), e.getX()));
		shape.setAttribute(3, getDistane(shape.getAttribute(1), e.getY()));
		shape.paint(g);
		app.getDrawPane().repaint(shape.getAttribute(0)+1, shape.getAttribute(1)+1,
				shape.getAttribute(2)-1, shape.getAttribute(3)-1);
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
