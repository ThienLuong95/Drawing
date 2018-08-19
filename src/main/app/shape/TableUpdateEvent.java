package main.app.shape;

import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;

public class TableUpdateEvent extends TableModelEvent {

	public static final int TABLE_UPDATE_EVENT_TYPE = 23145;
	private Shape target;
	private int column, value;

	public TableUpdateEvent(TableModel source, Shape target, int column, int value) {
		super(source);
		this.target = target;
		this.column = column;
		this.value = value;
	}

	/**
	 * @return the target
	 */
	public Shape getTarget() {
		return target;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	@Override
	public int getType() {
		return TABLE_UPDATE_EVENT_TYPE;
	}

	private static final long serialVersionUID = -5264021531003579878L;

}
