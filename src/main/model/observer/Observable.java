package main.model.observer;

public interface Observable<T> {
	void registerObserver(Observer<T> observer);
	void unregisterObserver(Observer<T> observer);
	void notifyObservers();
}
