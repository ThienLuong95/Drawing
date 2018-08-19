package main.app.shape;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import main.app.shape.enums.ShapeType;
import main.model.Model;
import main.model.observer.Observer;

public class ShapeTableDataModel extends AbstractTableModel implements Observer<Shape> {
	private Model<Shape> shapeModel;
	private List<Shape> datas;
	private ShapeType shapeType;
	private static final long serialVersionUID = -1296147117585079900L;

	public ShapeTableDataModel(Model<Shape> shapeModel, ShapeType shapeType) {
		super();
		this.shapeModel = shapeModel;
		shapeModel.registerObserver(this);
		this.shapeType = shapeType;
		dataFilter();

	}

	@Override
	public void update(Model<Shape> model) {
		this.shapeModel = model;
		dataFilter();
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		if (shapeType == ShapeType.CIRCLE)
			return Circle.CIRCLE_ATTRIBUTE_NAMES.length;
		if (shapeType == ShapeType.RECTANGLE)
			return Rectangle.RECTANGLE_ATTRIBUTE_NAME.length;
		return 0;
	}

	@Override
	public int getRowCount() {
		return datas.size();
	}

	@Override
	public String getColumnName(int column) {
		if (shapeType == ShapeType.CIRCLE)
			return Circle.CIRCLE_ATTRIBUTE_NAMES[column];
		if (shapeType == ShapeType.RECTANGLE)
			return Rectangle.RECTANGLE_ATTRIBUTE_NAME[column];
		return super.getColumnName(column);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return Integer.class;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return datas.get(arg0).getAttribute(arg1);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if(getValueAt(rowIndex, columnIndex).equals(aValue)) {
			return;
		}
		fireTableChanged(new TableUpdateEvent(this, datas.get(rowIndex), columnIndex, (Integer) aValue));
	}

	private void dataFilter() {
		datas = new LinkedList<>();
		for (Shape shape : shapeModel.getDatas()) {
			if (shapeType == shape.getShapeType())
				datas.add(shape);
		}

	}

	public List<Shape> getShape(int... indexs) {
		if (indexs == null || indexs.length == 0)
			return null;
		List<Shape> shapes = new LinkedList<>();
		for (int i : indexs) {
			Shape shape = datas.get(i);
			shapes.add(shape);
		}

		return shapes;
	}

}
