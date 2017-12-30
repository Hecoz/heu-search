package p_heu.entity;

public class PatternType {
	private PatternTypeNode[] nodes;
	
	public PatternType(PatternTypeNode[] nodes) {
		this.nodes = nodes;
	}
	
	public PatternTypeNode[] getNodes() {
		return this.nodes;
	}
	
	public boolean isSame(PatternType patternType) {
		if (this.nodes.length != patternType.getNodes().length) {
			return false;
		}
		for (int i = 0; i < this.nodes.length; ++i) {
			if (!this.nodes[i].isSame(patternType.getNodes()[i])) {
				return false;
			}
		}
		return true;
	}
}
