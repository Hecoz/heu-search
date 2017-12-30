package p_heu.entity;

public class ReadWriteNode extends Node {
	protected String element;
	protected String field;
	protected String type;
	protected String thread;
	protected String position;
	
	public ReadWriteNode(int id, String element, String field, String type, String thread, String position) {
		this.id = id;
		this.element = element;
		this.field = field;
		this.type = type;
		this.thread = thread;
		this.position = position;
	}
	
	public String getElement() {
		return this.element;
	}
	
	public String getField() {
		return this.field;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getThread() {
		return this.thread;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public boolean isIdentical(Node node) {
		if (node instanceof ReadWriteNode) {
			return this.id == node.getId() && this.isSame(node);
		}
		return false;
	}
	
	public boolean isSame(Node node) {
		if (node instanceof ReadWriteNode) {
			ReadWriteNode rwNode = (ReadWriteNode)node;
			return this.element.equals(rwNode.getElement()) && this.field.equals(rwNode.getField())
					&& this.type.equals(rwNode.getType()) && this.thread.equals(rwNode.getThread())
					&& this.position.equals(rwNode.getPosition());
		}
		return false;
	}
}
