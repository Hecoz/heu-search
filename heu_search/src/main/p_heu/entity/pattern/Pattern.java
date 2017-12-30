package p_heu.entity.pattern;

import p_heu.entity.PatternType;
import p_heu.entity.ReadWriteNode;

public class Pattern {
	private PatternType patternType;
	private ReadWriteNode[] nodes;
	
	public Pattern(PatternType patternType) {
		this.patternType = patternType;
		this.nodes = null;
	}
	
	public Pattern(PatternType patternType, ReadWriteNode[] nodes) {
		this.patternType = patternType;
		this.nodes =nodes;
	}
	
	public PatternType getPatternType() {
		return this.patternType;
	}
	
	public ReadWriteNode[] getNodes() {
		return this.nodes;
	}
	
	public void setNodes(ReadWriteNode[] nodes) {
		this.nodes = nodes;
	}
	
	public boolean isMatched() {
		return nodes != null;
	}
	
	public boolean isSamePattern(Pattern pattern) {
		if (!(this.isMatched() && pattern.isMatched())) {
			throw new RuntimeException("Two patterns should be both matched.");
		}
		
		if (!this.isSamePatternType(pattern)) {
			return false;
		}
		
		ReadWriteNode[] nodes = pattern.getNodes();
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
