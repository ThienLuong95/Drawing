package main.app.shape.action;

import main.app.shape.Shape;
import main.controller.Action;
import main.controller.Controller;
import main.controller.changeable.Changeable;

public class ActionUpdateSape implements Action<Shape>, Changeable {
	private Shape target;
	private int column, value, oldValue;
	private Controller<Shape> controller;
	public ActionUpdateSape(Shape target, int column, int value) {
		super();
		this.target = target;
		this.column = column;
		this.value = value;
	}
	@Override
	public void undo() {
		update();
	}
	@Override
	public void redo() {
		update();
	}
	@Override
	public void executeFor(Controller<Shape> controller) {
		this.controller=controller;
		update();
	}

	private void update() {
		oldValue=target.getAttribute((column));
		Shape newShape= target.clone();
		newShape.setAttribute(column,value);
		controller.update(target, newShape);
		
		value=oldValue;
		target=newShape;
	}
	@Override
	public boolean requireNotifyData() {
		// TODO Auto-generated method stub
		return true;
	}
}
