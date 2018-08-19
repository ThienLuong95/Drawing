package main.app.shape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import main.app.shape.enums.FactoryType;
import main.app.shape.enums.ShapeType;
import main.app.shape.factory.Factory;
import main.app.shape.factory.Producer;
import main.controller.Controller;
import main.model.Model;

public class App extends JFrame {

	private JPanel contentPane;
	private JTable tableRectangle, tableCircle;
	private JButton btnUndo, btnRedo, btnAdd, btnRemove;
	private JRadioButton rbtn2D, rbtn3D;
	private JComboBox<ShapeType> comboBox;
	private Model<Shape> model;
	private Controller<Shape> controller;
	private DrawPane view;
	private ShapeTableDataModel dataModelCircle, dataModelRect;
	private static ShapeType shapeType = ShapeType.RECTANGLE;
	private static Factory factory;
	private JTable currentSelectedTable;
	public App() {
		model = new ShapeModel();
		view = new DrawPane(model);
		controller = new ShapeController(model, view);
		controller.registerObserver(view);
		factory = new Producer().getFactory(FactoryType.SHAPE);

		init();
	}

	private void init() {
		initCoponent();
		initEnviroment();
	}
	private void registerActionComand() {
		btnAdd.setActionCommand("add");
		btnRemove.setActionCommand("remove");
		btnUndo.setActionCommand("undo");
		btnRedo.setActionCommand("redo");
		rbtn2D.setActionCommand("2D");
		rbtn3D.setActionCommand("3D");
	}

	private void registerActionListener() {
		HandleActionCommandEvent handleActionCommandEvent = new HandleActionCommandEvent(controller, this);
		btnAdd.addActionListener(handleActionCommandEvent);
		btnRemove.addActionListener(handleActionCommandEvent);
		btnUndo.addActionListener(handleActionCommandEvent);
		btnRedo.addActionListener(handleActionCommandEvent);
		rbtn2D.addActionListener(handleActionCommandEvent);
		rbtn3D.addActionListener(handleActionCommandEvent);
		comboBox.addActionListener(new HandelComboBox(controller));

		HandleTableDataModelEvent handleTableDataModelEvent = new HandleTableDataModelEvent(controller);
		dataModelCircle.addTableModelListener(handleTableDataModelEvent);
		dataModelRect.addTableModelListener(handleTableDataModelEvent);
		HandleTableMouseActionEvent handleTableMouseActionEvent= new HandleTableMouseActionEvent(controller, this);
		tableCircle.addMouseListener(handleTableMouseActionEvent);
		tableRectangle.addMouseListener(handleTableMouseActionEvent);
		
		HandleDrawPanelMouseActionEvent handleDrawPanelMouseActionEvent=
				new HandleDrawPanelMouseActionEvent(controller, this);
		view.addMouseListener(handleDrawPanelMouseActionEvent);
		view.addMouseMotionListener(handleDrawPanelMouseActionEvent);
	}
	public JTable getCurrentSelectedTable() {
		return currentSelectedTable;
	}
	public DrawPane getDrawPane() {
		return view;
	}

	public void setCurrentSelectedTable(JTable currentSelectedTable) {
		this.currentSelectedTable = currentSelectedTable;
	}
	private void setDefaultState() {
		rbtn2D.setSelected(true);
		comboBox.setSelectedIndex(0);
		btnRemove.setEnabled(false);
		btnUndo.setEnabled(false);
		btnRedo.setEnabled(false);
	}

	private void setUpTableDatamodel() {

		dataModelCircle = new ShapeTableDataModel(model, ShapeType.CIRCLE);
		dataModelRect = new ShapeTableDataModel(model, ShapeType.RECTANGLE);
		tableCircle.setModel(dataModelCircle);
		tableRectangle.setModel(dataModelRect);
	}

	public static Shape getShape(Coordinate position, int... sizes) {
		return factory.getShape(shapeType, position, sizes);
	}

	public static Shape3D getShape3D(Shape shape, int depht) {
		return factory.getShape3D(shape, depht);
	}

	public static void setShapeType(ShapeType shapeType) {
		App.shapeType = shapeType;
	}
	public void updateBtnUndoReDoState() {
		btnUndo.setEnabled(controller.canUndo());
		btnRedo.setEnabled(controller.canRedo());
	}
	public void setBtnRemoveState(boolean enable) {
		btnRemove.setEnabled(enable);
	}
	private void initEnviroment() {
		setUpTableDatamodel();
		setDefaultState();
		registerActionComand();
		registerActionListener();
	}

	private void initCoponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(14, 14, 14, 14));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));

		JPanel panelLeft = new JPanel();
		panelLeft.setPreferredSize(new Dimension(250, getHeight()));
		contentPane.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));

		JPanel panelCircle = new JPanel();
		panelLeft.add(panelCircle);
		panelCircle.setLayout(new BorderLayout(0, 0));
		JLabel lblCircle = new JLabel("Circle");
		lblCircle.setLabelFor(tableCircle);
		panelCircle.add(lblCircle, BorderLayout.NORTH);
		tableCircle = new JTable();
		tableCircle.setBorder(null);
		tableCircle.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		JScrollPane scrollPaneCircle = new JScrollPane(tableCircle);
		panelCircle.add(scrollPaneCircle, BorderLayout.CENTER);

		Component verticalStrut = Box.createVerticalStrut(10);
		panelLeft.add(verticalStrut);
		JPanel panelRectangle = new JPanel();
		panelLeft.add(panelRectangle);
		panelRectangle.setLayout(new BorderLayout(0, 0));
		JLabel lblRectangle = new JLabel("Rectangle");
		panelRectangle.add(lblRectangle, BorderLayout.NORTH);
		tableRectangle = new JTable();
		lblRectangle.setLabelFor(tableRectangle);
		tableRectangle.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		JScrollPane scrollPaneReactangle = new JScrollPane(tableRectangle);
		panelRectangle.add(scrollPaneReactangle, BorderLayout.CENTER);

		JPanel panelRight = new JPanel();
		contentPane.add(panelRight, BorderLayout.CENTER);
		panelRight.setLayout(new BorderLayout(10, 10));

		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelRight.add(panelButton, BorderLayout.NORTH);

		btnAdd = new JButton("Add");
		btnRemove = new JButton("Remove");

		comboBox = new JComboBox<>(ShapeType.values());

		btnUndo = new JButton("Undo");
		btnRedo = new JButton("Redo");

		rbtn2D = new JRadioButton("2D");
		rbtn3D = new JRadioButton("3D");
		ButtonGroup renderGroup = new ButtonGroup();
		renderGroup.add(rbtn2D);
		renderGroup.add(rbtn3D);

		panelButton.add(btnAdd);
		panelButton.add(btnRemove);
		panelButton.add(Box.createHorizontalStrut(20));
		panelButton.add(comboBox);
		panelButton.add(Box.createHorizontalStrut(20));
		panelButton.add(btnUndo);
		panelButton.add(btnRedo);
		panelButton.add(Box.createHorizontalStrut(20));
		panelButton.add(rbtn2D);
		panelButton.add(rbtn3D);

		panelRight.add(view, BorderLayout.CENTER);
		view.setBackground(Color.WHITE);

	}

	public static void main(String[] args) {
		new App().setVisible(true);
//		try {
//			EventQueue.invokeAndWait(new Runnable() {
//
//				@Override
//				public void run() {
//					App app = new App();
//					app.setVisible(true);
//				}
//			});
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}
