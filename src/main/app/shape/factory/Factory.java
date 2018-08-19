package main.app.shape.factory;

import java.util.List;

import main.app.shape.Coordinate;
import main.app.shape.Shape;
import main.app.shape.Shape3D;
import main.app.shape.enums.ShapeType;

public abstract class Factory {
	public abstract Shape getShape(ShapeType shapeType, Coordinate coordinate, int ...sizes);
	public abstract Shape getShape(ShapeType shapeType, List<Coordinate> coordinates, int ...sizes);
	public abstract Shape3D getShape3D(Shape shape, int depht);
}
