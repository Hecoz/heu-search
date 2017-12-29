package search.heuristic;

public class Pattern {
	private PatternType patternType;
	private PatternNode[] nodes;
	
	public Pattern(PatternType patternType) {
		this.patternType = patternType;
		this.nodes = null;
	}
	
	public Pattern(PatternType patternType, PatternNode[] nodes) {
		this.patternType = patternType;
		this.nodes = nodes;
	}
	
	public PatternType getPatternType() {
		return patternType;
	}
	
	public PatternNode[] getNodes() {
		return nodes;
	}
	
	public void setNodes(PatternNode[] nodes) {
		this.nodes = nodes;
	}
	
	public boolean isMatched() {
		return nodes != null;
	}
	
	public boolean isSamePattern(Pattern pattern) {
		if (!(this.isMatched() && pattern.isMatched())) {
			throw new RuntimeException("Two patterns should both be matched.");
		}
		
		if (!this.isSamePattern(pattern)) {
			return false;
		}
		
		PatternNode[] nodes = pattern.getNodes();
		for (int i = 0; i < this.nodes.length; ++i) {
			if (!this.nodes[i].isSame(nodes[i])) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isSamePatternType(Pattern pattern) {
		return this.patternType.equals(pattern.getPatternType());
	}
}
