package search.heuristic;

/*
 * 用于存储共享变量读写操作，可以组成pattern
 */
public class PatternNode {
	private int id;
	private String element;
	private String field;
	private String type;
	private String thread;
	private String position;
	
	public PatternNode(int id, String element, String field, String type, String thread, String position) {
		this.id = id;
		this.element = element;
		this.field = field;
		this.type = type;
		this.thread = thread;
		this.position = position;
	}
	
	public int getId() {
		return id;
	}
	
	public String getElement() {
		return element;
	}
	
	public String getField() {
		return field;
	}
	
	public String getType() {
		return type;
	}
	
	public String getThread() {
		return thread;
	}
	
	public String getPosition() {
		return position;
	}
	
	public boolean identical(PatternNode node) {
		return this.id == node.getId() && this.isSame(node);
	}
	
	public boolean isSame(PatternNode node) {
		return this.element.equals(node.getElement())
				&& this.field.equals(node.getField())
				&& this.type.equals(node.getType())
				&& this.thread.equals(node.getThread())
				&& this.position.equals(node.getPosition());
	}
}
