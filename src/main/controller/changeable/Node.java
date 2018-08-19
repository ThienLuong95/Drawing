package main.controller.changeable;

public class Node {
	private Node left=null;
	private Node right=null;
	
	private final Changeable changeable;
	public Node(Changeable changeable) {
		this.changeable= changeable;
	}
	public Node() {
		this.changeable=null;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Changeable getChangeable() {
		return changeable;
	}
	@Override
	public String toString() {
		return "Node [left=" + left + ", right=" + right + ", changeable=" + changeable + "]";
	}
	
}
