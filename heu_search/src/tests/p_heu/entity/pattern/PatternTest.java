package p_heu.entity.pattern;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatternTest {
    private Pattern[] falconPatterns;
    private Pattern[] unicornPatterns;

    @Before
    public void init() throws Exception {
        falconPatterns = Pattern.getFalconPatterns();
        unicornPatterns = Pattern.getUnicornPatterns();
    }

    @Test
    public void getPatternType() throws Exception {
    }

    @Test
    public void getNodes() throws Exception {
    }

    @Test
    public void setNodes() throws Exception {
    }

    @Test
    public void isMatched() throws Exception {
    }

    @Test
    public void isSamePattern() throws Exception {
    }

    @Test
    public void isSamePatternType() throws Exception {
    }

    @Test
    public void getFalconPatterns() throws Exception {
        for (Pattern p : falconPatterns) {
            System.out.println(p);
        }
    }

    @Test
    public void getUnicornPatterns() throws Exception {
        for (Pattern p : unicornPatterns) {
            System.out.println(p);
        }
    }

}