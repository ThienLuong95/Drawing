package main.app.shape;

import java.awt.Graphics;

import javax.swing.JPanel;

import main.app.shape.enums.RenderType;
import main.model.Model;
import main.view.PaintAdapter;
import main.view.Paintable;
import main.view.Painter;

public class DrawPane extends JPanel implements Painter<Shape>, PaintAdapter<Shape> {
	private Model<Shape> model;
	private RenderType renderType;
	private static final long serialVersionUID = -3417870315236208896L;

	public DrawPane(Model<Shape> model) {
		super();
		this.model = model;
		renderType = RenderType.TWO_D;
	}

	@Override
	public void update(Model<Shape> model) {
		this.model = model;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (renderType == RenderType.TWO_D) {
			paint2D(g);
		}
		if (renderType == RenderType.THREE_D) {
			paint3D(g);
		}
	}

	@Override
	public void paint3D(Graphics g) {
		for (Shape shape : model.getDatas()) {
			Shape3D shape3d= App.getShape3D(shape, 30);
			shape3d.paint3D(g);
		}
	}

	@Override
	public void paint2D(Graphics g) {
		for (Paintable paintable : model.getDatas()) {
			paintable.paint(g);
		}
	}

	@Override
	public void showView() {
		repaint();
	}

	@Override
	public void setRenderType(RenderType renderType) {
		this.renderType = renderType;
	}

}
