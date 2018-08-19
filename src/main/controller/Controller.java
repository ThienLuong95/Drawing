package main.controller;

import java.util.List;

import main.app.shape.enums.RenderType;
import main.controller.changeable.ChangeManager;
import main.controller.changeable.Changeable;
import main.model.Model;
import main.model.observer.Observer;
import main.view.View;

public abstract class Controller<T> implements Executeable<T> {
	protected Model<T> model;
	protected View<T> view;
	protected ChangeManager changeManager;

	public Controller(Model<T> model, View<T> view) {
		super();
		this.model = model;
		this.view = view;
		changeManager = new ChangeManager();
	}

	@Override
	public void execute(Action<T> action) {
		if (action == null) {
			return;
		}

		action.executeFor(this);

		if (action instanceof Changeable) {
		Changeable changeable = (Changeable) action;
			changeManager.addChangeable(changeable);
		}
		
		if (action.requireNotifyData()) {
			notifyObservers();
		}
		
		showView();
	}

	public boolean insert(@SuppressWarnings("unchecked") T... ts) {
		return model.insert(ts);
	}

	public boolean insert(List<T> ts) {
		return model.insert(ts);
	}

	public boolean delete(@SuppressWarnings("unchecked") T... ts) {
		return model.delete(ts);
	}

	public boolean delete(List<T> ts) {
		return model.delete(ts);
	}

	public boolean update(T t1, T t2) {
		return model.update(t1, t2);
	}

	public void registerObserver(Observer<T> observer) {
		model.registerObserver(observer);
	}

	public void unregisterObserver(Observer<T> observer) {
		model.unregisterObserver(observer);
	}

	public void notifyObservers() {
		model.notifyObservers();
	}

	public void undo() {
		changeManager.undo();
	}

	public void redo() {
		changeManager.redo();
	}

	public boolean canUndo() {
		return changeManager.canUndo();
	}

	public boolean canRedo() {
		return changeManager.canRedo();
	}

	public void showView() {
		view.showView();
	}
	public void setRenderType(RenderType renderType) {
		view.setRenderType(renderType);
	}
}
