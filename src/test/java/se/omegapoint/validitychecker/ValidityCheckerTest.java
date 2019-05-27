package se.omegapoint.validitychecker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class ValidityCheckerTest {


    private final ValidityChecker valid = new ValidityChecker();

    private List<Integer> list = Arrays.asList(1,9,7,8,0,2,0,2,2,3,8,9);
    private List<Character> list2 = Arrays.asList('A','B','C','1','2','3');
    private List<Integer> validList1 = Arrays.asList(7,8,0,2,0,2,2,3,8,9);
    private List<Integer> validList2 = Arrays.asList(8,2,0,4,1,1,2,3,8,0);



    @Test
    public void addStringInputToIntListTest() {
        assertEquals(list, ValidityChecker.addStringToIntList("197802022389"));
        assertNotEquals(list, ValidityChecker.addStringToIntList("19780202238A"));
        assertNotEquals(list2, ValidityChecker.addStringToIntList("ABC123"));

    }


    @Test
    public void calcAlgorithm1Test() {
        assertEquals(7, ValidityChecker.calcAlgorithmPart1(8));
        assertEquals(5, ValidityChecker.calcAlgorithmPart1(7));
        assertEquals(4, ValidityChecker.calcAlgorithmPart1(2));
        assertEquals(0, ValidityChecker.calcAlgorithmPart1(0));
    }


    @Test
    public void calcAlgorithm2Test() {
        assertEquals(9, ValidityChecker.calcAlgorithmPart2(31));
        assertEquals(0, ValidityChecker.calcAlgorithmPart2(30));
    }

    @Test
    public void inputValidityTest(){
        assertTrue(valid.validityCheck("7802022389"));
        assertTrue(valid.validityCheck("197802022389"));
        assertTrue(valid.validityCheck("780202-2389"));
        assertTrue(valid.validityCheck("19780202-2389"));
        assertTrue(valid.validityCheck("197-802022389"));
        assertFalse(valid.validityCheck("7-8020A22389"));
        assertFalse(valid.validityCheck("19780202-2388"));
        assertFalse(valid.validityCheck("78020A22389"));
        assertFalse(valid.validityCheck("7802022388"));


    }

}
