package main.model;

import java.util.LinkedList;
import java.util.List;

import main.model.observer.Observable;
import main.model.observer.Observer;

public abstract class Model<T> implements Observable<T> {

	protected List<T> datas;
	protected List<Observer<T>> observers;

	public Model(List<T> datas) {
		super();
		this.datas = datas;
	}

	public Model() {
		super();
		this.datas = new LinkedList<>();
		observers = new LinkedList<>();
	}

	public boolean insert(@SuppressWarnings("unchecked") T... ts) {
		if (ts == null || ts.length == 0)
			return false;
		for (T t : ts) {
			if (t == null)
				return false;
		}
		for (T t : ts) {
			datas.add(t);
		}
		return true;
	}

	public boolean insert(List<T> ts) {
		if (ts == null || ts.size() == 0) {
			return false;
		}
		if (ts.contains(null)) {
			return false;
		}
		datas.addAll(ts);
		return true;
	}

	public boolean delete(@SuppressWarnings("unchecked") T... ts) {
		if (ts == null || ts.length == 0) {
			return false;
		}
		for (T t : ts) {
			if (!datas.contains(t))
				return false;
		}
		for (T t : ts) {
			datas.remove(t);
		}
		return true;
	}

	public boolean delete(List<T> ts) {
		if (ts == null || ts.size() == 0) {
			return false;
		}

		for (T t : ts) {
			datas.remove(t);
		}
		return true;
	}

	public boolean update(T t1, T t2) {
		if (t1 == null || t2 == null)
			return false;
		if (!datas.contains(t1))
			return false;
		int index = datas.indexOf(t1);
		datas.set(index, t2);
		return true;
	}

	public List<T> getDatas() {
		return datas;
	}

	@Override
	public void registerObserver(Observer<T> observer) {
		observers.add(observer);
	}

	@Override
	public void unregisterObserver(Observer<T> observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer<T> observer : observers) {
			observer.update(this);
		}
	}
}
