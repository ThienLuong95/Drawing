package main.app.shape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import main.app.shape.action.ActionAddShape;
import main.app.shape.action.ActionRedo;
import main.app.shape.action.ActionRemoveShape;
import main.app.shape.action.ActionSetRender;
import main.app.shape.action.ActionUndo;
import main.app.shape.enums.RenderType;
import main.controller.Executeable;
import main.controller.HandelAtionEvent;

public class HandleActionCommandEvent extends HandelAtionEvent<Shape> implements ActionListener {
	private App app;

	public HandleActionCommandEvent(Executeable<Shape> executeable, App app) {
		super(executeable);
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "add":
			Shape shape = App.getShape(new Coordinate(0, 0), 0, 0, 0);
			executeable.execute(new ActionAddShape(shape));
			break;
		case "remove":
			remove();
			app.setBtnRemoveState(false);
			break;
		case "undo":
			executeable.execute(new ActionUndo());
			break;
		case "redo":
			executeable.execute(new ActionRedo());
			break;
		case "2D":
			executeable.execute(new ActionSetRender(RenderType.TWO_D));
			break;
		case "3D":
			executeable.execute(new ActionSetRender(RenderType.THREE_D));
			break;
		default:
			break;
		}
		refesh();
	}

	private void refesh() {
		app.updateBtnUndoReDoState();
		app.repaint();
	}

	private void remove() {
		JTable jTable = app.getCurrentSelectedTable();
		if (jTable == null) {
			return;
		}
		if (jTable.getModel() instanceof ShapeTableDataModel) {
			ShapeTableDataModel model = (ShapeTableDataModel) jTable.getModel();
				List<Shape> shapes=model.getShape(jTable.getSelectedRows());
				if(shapes!= null && shapes.size()>0) {
					executeable.execute(new ActionRemoveShape(shapes));
				}
		}
	}
}
