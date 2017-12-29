package search.heuristic;

public class PatternType {
	private PatternTypeNode[] nodes;
	
	public PatternType(PatternTypeNode[] nodes) {
		this.nodes = nodes;
	}
	
	public static class PatternTypeNode {
		private String var;
		private String thread;
		private String type;
		
		public PatternTypeNode(String var, String thread, String type) {
			this.var = var;
			this.thread = thread;
			this.type = type;
		}
		
		public String getVar() {
			return var;
		}
		
		public String getThread() {
			return thread;
		}
		
		public String getType() {
			return type;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof PatternTypeNode) {
				PatternTypeNode node = (PatternTypeNode)obj;
				return this.var.equals(node.getVar())
						&& this.thread.equals(node.getThread())
						&& this.type.equals(node.getType());
			}
			else {
				return false;
			}
		}
	}
	
	public PatternTypeNode[] getNodes() {
		return nodes;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PatternType) {
			PatternType patternType = (PatternType)obj;
			PatternTypeNode[] nodes = patternType.getNodes();
			if (this.nodes.length == nodes.length) {
				for (int i = 0; i < this.nodes.length; ++i) {
					if (!this.nodes[i].equals(nodes[i])) {
						return false;
					}
				}
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
