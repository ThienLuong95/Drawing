package main.app.shape.action;

import java.util.List;

import main.app.shape.Shape;
import main.controller.Action;
import main.controller.Controller;
import main.controller.changeable.Changeable;

public class ActionRemoveShape implements Action<Shape>, Changeable{
	private List<Shape> shapes;
	private Controller<Shape> controller;

	public ActionRemoveShape(List<Shape> shapes) {
		super();
		this.shapes = shapes;
	}

	@Override
	public void undo() {
		if (controller == null) {
			return;
		}
		controller.insert(shapes);
	}

	@Override
	public void redo() {
		if (controller == null) {
			return;
		}
		controller.delete(shapes);

	}

	@Override
	public void executeFor(Controller<Shape> controller) {
		this.controller=controller;
		controller.delete(shapes);
	}

	@Override
	public boolean requireNotifyData() {
		return true;
	}

}
