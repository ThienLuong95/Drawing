package main.app.shape.action;

import main.app.shape.Shape;
import main.app.shape.enums.RenderType;
import main.controller.Action;
import main.controller.Controller;

public class ActionSetRender implements Action<Shape> {
	private RenderType renderType;
	
	public ActionSetRender(RenderType renderType) {
		super();
		this.renderType = renderType;
	}

	@Override
	public void executeFor(Controller<Shape> controller) {
		controller.setRenderType(renderType);
	}

	@Override
	public boolean requireNotifyData() {
		return false;
	}

}
