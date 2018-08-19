package main.model.observer;

import main.model.Model;

public interface Observer<T> {
	void update(Model<T> model);
}
