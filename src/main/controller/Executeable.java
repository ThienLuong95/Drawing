package main.controller;

public interface Executeable<T> {
	void execute(Action<T> action);
}
