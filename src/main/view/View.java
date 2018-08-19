package main.view;

import main.app.shape.enums.RenderType;
import main.model.observer.Observer;

public interface View<T> extends Observer<T> {
	void showView();
	void setRenderType(RenderType renderType);
}
