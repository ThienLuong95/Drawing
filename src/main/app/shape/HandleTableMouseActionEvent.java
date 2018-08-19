package main.app.shape;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import main.controller.Executeable;
import main.controller.HandelAtionEvent;

public class HandleTableMouseActionEvent extends HandelAtionEvent<Shape> implements MouseListener{
	private App app;
	public HandleTableMouseActionEvent(Executeable<Shape> executeable, App app) {
		super(executeable);
		this.app= app;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		handelMouseEvent(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		handelMouseEvent(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private void handelMouseEvent(MouseEvent e) {
		if( e.getSource() instanceof JTable) {
			JTable jTable= (JTable)e.getSource();
			app.setCurrentSelectedTable(jTable);
			if(jTable.getSelectedRowCount()>0) {
				app.setBtnRemoveState(true);
			}
		}
	}
}
