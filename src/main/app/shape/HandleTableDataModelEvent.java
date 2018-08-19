package main.app.shape;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import main.app.shape.action.ActionUpdateSape;
import main.controller.Executeable;
import main.controller.HandelAtionEvent;

public class HandleTableDataModelEvent extends HandelAtionEvent<Shape> implements TableModelListener {
	private Shape lastTarget;
	private int lastColumn;
	private int lastValue;
	public HandleTableDataModelEvent(Executeable<Shape> executeable) {
		super(executeable);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		TableUpdateEvent event=null;
		if (e instanceof TableUpdateEvent)
			event = (TableUpdateEvent) e;
		if (event ==null) {
			return;
		}
		executeable.execute(new ActionUpdateSape(event.getTarget(), event.getColumn(), event.getValue()));
	}

}
