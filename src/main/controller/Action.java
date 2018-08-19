package main.controller;


public interface Action<T> {
	void executeFor(Controller<T>  controller);
	boolean requireNotifyData();
}
