package main.controller.changeable;


public class ChangeManager {
	private Node currentNode = null;
	private Node parentNode = new Node();

	public ChangeManager() {
		currentNode = parentNode;
	}

	public ChangeManager(ChangeManager manager) {
		this();
		currentNode = manager.currentNode;
	}

	public void clear() {
		currentNode = parentNode;
	}

	public void addChangeable(Changeable changeable) {
		Node node = new Node(changeable);
		currentNode.setRight(node);
		node.setLeft(currentNode);
		currentNode = node;

	}

	public boolean canRedo() {
		return currentNode.getRight() != null;
	}

	public boolean canUndo() {
		return currentNode.getLeft() != null;
	}

	public void undo() {
		if (!canUndo()) {
			throw new IllegalStateException("Cannot Undo, index is out of range");
		}
		currentNode.getChangeable().undo();
		moveLeft();
	}

	private void moveLeft() {
		if (currentNode.getLeft() == null) {
			throw new IllegalStateException("Internal Index set to null");
		}
		currentNode = currentNode.getLeft();
	}

	public void redo() {
		if (!canRedo()) {
			throw new IllegalStateException("Cannot Redo, index is out of range");
		}
		moveRight();
		currentNode.getChangeable().redo();
	}

	private void moveRight() {
		if (currentNode.getRight() == null) {
			throw new IllegalStateException("Internal Index set to null");
		}
		currentNode = currentNode.getRight();
	}

	@Override
	public String toString() {
		return "ChangeManager [currentNode=" + currentNode + ", parentNode=" + parentNode + "]";
	}
	public Node getCurrentNode() {
		return currentNode;
	}
	public Node getParentNode() {
		return parentNode;
	}
}
