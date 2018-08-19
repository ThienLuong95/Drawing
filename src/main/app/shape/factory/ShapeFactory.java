package main.app.shape.factory;

import java.util.List;

import main.app.shape.Circle;
import main.app.shape.Circle3D;
import main.app.shape.Coordinate;
import main.app.shape.Rectangle;
import main.app.shape.Rectangle3D;
import main.app.shape.Shape;
import main.app.shape.Shape3D;
import main.app.shape.enums.ShapeType;

public class ShapeFactory extends Factory {

	@Override
	public Shape getShape(ShapeType shapeType, Coordinate coordinate, int... sizes) {
		if (coordinate == null || sizes == null || sizes.length <= 0)
			return null;
		if (shapeType == ShapeType.CIRCLE) {
			return new Circle(coordinate, sizes[0]);
		}
		if (shapeType == ShapeType.RECTANGLE && sizes.length >= 2) {
			return new Rectangle(coordinate, sizes[0], sizes[1]);
		}
		return null;
	}

	@Override
	public Shape getShape(ShapeType shapeType, List<Coordinate> coordinates, int... sizes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape3D getShape3D(Shape shape, int depht) {
		if (shape==null) return null;
		if(shape instanceof Circle) {
			return new Circle3D((Circle)shape, depht);
		}
		if(shape instanceof Rectangle) {
			return new Rectangle3D((Rectangle)shape, depht);
		}
		return null;
	}

}
