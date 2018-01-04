package p_heu.entity.pattern;

import p_heu.entity.Node;
import p_heu.entity.PatternType;
import p_heu.entity.PatternTypeNode;
import p_heu.entity.ReadWriteNode;

import java.util.ArrayList;
import java.util.List;

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

	public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Pattern {\n");
        stringBuilder.append("\t" + this.patternType.toString() + "\n");
        stringBuilder.append("\tmatched: " + this.isMatched() + "\n");
        if (this.isMatched()) {
            for (Node node : this.nodes) {
                stringBuilder.append("\t" + node.toString() + "\n");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

	public static Pattern[] getFalconPatterns() {
		List<Pattern> patterns = new ArrayList<>();

		//P1 R1(x), W2(x)
		patterns.add(new Pattern(new PatternType("R1(x), W2(x)")));

		//P2 W1(x), R2(x)
        patterns.add(new Pattern(new PatternType("W1(x), R2(x)")));

        //P3 W1(x), W2(x)
        patterns.add(new Pattern(new PatternType("W1(x), W2(x)")));

        //P4 R1(x), W2(x), R1(x)
        patterns.add(new Pattern(new PatternType("R1(x), W2(x), R1(x)")));

        //P5 W1(x), W2(x), R1(x)
        patterns.add(new Pattern(new PatternType("W1(x), W2(x), R1(x)")));

        //P6 W1(x), R2(x), W1(x)
        patterns.add(new Pattern(new PatternType("W1(x), R2(x), W1(x)")));

        //P7 R1(x), W2(x), W1(x)
        patterns.add(new Pattern(new PatternType("R1(x), W2(x), W1(x)")));

        //P8 W1(x), W2(x), W1(x)
        patterns.add(new Pattern(new PatternType("W1(x), W2(x), W1(x)")));

        return patterns.toArray(new Pattern[patterns.size()]);
	}

	public static Pattern[] getUnicornPatterns() {
        List<Pattern> patterns = new ArrayList<>();

        //P1 R1(x), W2(x)
        patterns.add(new Pattern(new PatternType("R1(x), W2(x)")));

        //P2 W1(x), R2(x)
        patterns.add(new Pattern(new PatternType("W1(x), R2(x)")));

        //P3 W1(x), W2(x)
        patterns.add(new Pattern(new PatternType("W1(x), W2(x)")));

        //P4 R1(x), W2(x), R1(x)
        patterns.add(new Pattern(new PatternType("R1(x), W2(x), R1(x)")));

        //P5 W1(x), W2(x), R1(x)
        patterns.add(new Pattern(new PatternType("W1(x), W2(x), R1(x)")));

        //P6 W1(x), R2(x), W1(x)
        patterns.add(new Pattern(new PatternType("W1(x), R2(x), W1(x)")));

        //P7 R1(x), W2(x), W1(x)
        patterns.add(new Pattern(new PatternType("R1(x), W2(x), W1(x)")));

        //P8 W1(x), W2(x), W1(x)
        patterns.add(new Pattern(new PatternType("W1(x), W2(x), W1(x)")));

        //P9 W1(x), W2(x), W2(y), W1(y)
        patterns.add(new Pattern(new PatternType("W1(x), W2(x), W2(y), W1(y)")));

        //P10 W1(x), W2(y), W2(x), W1(y)
        patterns.add(new Pattern(new PatternType("W1(x), W2(y), W2(x), W1(y)")));

        //P11 W1(x), W2(y), W1(y), W2(x)
        patterns.add(new Pattern(new PatternType("W1(x), W2(y), W1(y), W2(x)")));

        //P12 W1(x), R2(x), R2(y), W1(y)
        patterns.add(new Pattern(new PatternType("W1(x), R2(x), R2(y), W1(y)")));

        //P13 W1(x), R2(y), R2(x), W1(y)
        patterns.add(new Pattern(new PatternType("W1(x), R2(y), R2(x), W1(y)")));

        //P14 R1(x), W2(x), W2(y), R1(y)
        patterns.add(new Pattern(new PatternType("R1(x), W2(x), W2(y), R1(y)")));

        //P15 R1(x), W2(y), W2(x), R1(y)
        patterns.add(new Pattern(new PatternType("R1(x), W2(y), W2(x), R1(y)")));

        //P16 R1(x), W2(y), R1(y), W2(x)
        patterns.add(new Pattern(new PatternType("R1(x), W2(y), R1(y), W2(x)")));

        //P17 R1(x), W2(y), W1(y), R2(x)
        patterns.add(new Pattern(new PatternType("R1(x), W2(y), W1(y), R2(x)")));

        return patterns.toArray(new Pattern[patterns.size()]);
    }
}
