package main.app.shape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import main.app.shape.enums.ShapeType;
import main.controller.Executeable;
import main.controller.HandelAtionEvent;

public class HandelComboBox extends HandelAtionEvent<Shape> implements ActionListener {

	public HandelComboBox(Executeable<Shape> executeable) {
		super(executeable);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!e.getSource().getClass().equals(JComboBox.class)) {
			return;
		}
		@SuppressWarnings("unchecked")
		JComboBox<ShapeType> jComboBox = (JComboBox<ShapeType>) e.getSource();
		String command = jComboBox.getSelectedItem().toString();
		if (command.equals(ShapeType.CIRCLE.toString())) {
			App.setShapeType(ShapeType.CIRCLE);
			return;
		}
		if (command.equals(ShapeType.RECTANGLE.toString())) {
			App.setShapeType(ShapeType.RECTANGLE);
			return;
		}
	}

}
