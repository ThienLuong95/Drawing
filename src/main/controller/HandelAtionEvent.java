package main.controller;

public abstract class HandelAtionEvent<T> {
	protected Executeable<T> executeable;

	public HandelAtionEvent(Executeable<T> executeable) {
		super();
		this.executeable = executeable;
	}
	
}
