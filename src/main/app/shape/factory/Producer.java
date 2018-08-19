package main.app.shape.factory;

import main.app.shape.enums.FactoryType;

public class Producer {
	public Factory getFactory(FactoryType factoryType) {
		if(factoryType==FactoryType.SHAPE) {
			return new ShapeFactory();
		}
		return null;
	}
}
