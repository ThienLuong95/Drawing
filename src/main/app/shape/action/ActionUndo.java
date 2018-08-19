package main.app.shape.action;

import main.app.shape.Shape;
import main.controller.Action;
import main.controller.Controller;

public class ActionUndo implements Action<Shape> {

	@Override
	public void executeFor(Controller<Shape> controller) {
		controller.undo();
	}

	@Override
	public boolean requireNotifyData() {
		// TODO Auto-generated method stub
		return true;
	}

}
