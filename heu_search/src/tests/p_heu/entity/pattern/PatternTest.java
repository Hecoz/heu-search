package p_heu.entity.pattern;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatternTest {
    private Pattern[] patterns;

    @Before
    public void init() throws Exception {
        patterns = Pattern.getFalconPatterns();
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
        for (Pattern p : patterns) {
            System.out.println(p);
        }
    }

}