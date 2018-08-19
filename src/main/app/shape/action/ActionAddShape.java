package main.app.shape.action;

import main.app.shape.Shape;
import main.controller.Action;
import main.controller.Controller;
import main.controller.changeable.Changeable;

public class ActionAddShape implements Action<Shape> , Changeable{
	private Shape shap;
	private Controller<Shape> controller;
	public ActionAddShape(Shape shap) {
		super();
		this.shap = shap;
	}

	@Override
	public void undo() {
		if(controller==null) {
			return;
		}
		controller.delete(shap);
	}

	@Override
	public void redo() {
		if(controller==null) {
			
			return;
		}
		controller.insert(shap);
	}

	@Override
	public void executeFor(Controller<Shape> controller) {
		this.controller=controller;
		controller.insert(shap);
	}

	@Override
	public boolean requireNotifyData() {
		return true;
	}

}
