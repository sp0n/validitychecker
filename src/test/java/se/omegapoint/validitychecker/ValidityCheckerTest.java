package se.omegapoint.validitychecker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class ValidityCheckerTest {


    private static final ValidityChecker valid = new ValidityChecker();
    private static final FormatPersonalNumber format = new FormatPersonalNumber();

    private List<Integer> list = Arrays.asList(1,9,7,8,0,2,0,2,2,3,8,9);
    private List<Character> list2 = Arrays.asList('A','B','C','1','2','3');
    private List<Integer> validList1 = Arrays.asList(7,8,0,2,0,2,2,3,8,9);
    private List<Integer> validList2 = Arrays.asList(8,2,0,4,1,1,2,3,8,0);



    @Test
    public void addStringInputToIntListTest() {
        assertEquals(list, ValidityChecker.addStringToIntList("197802022389"));
        assertNotEquals(list2, ValidityChecker.addStringToIntList("ABC123"));

    }


    @Test
    public void inputIsNullOrEmptyTest() {
        assertTrue(format.isNullOrEmpty(""));
        assertTrue(format.isNullOrEmpty(null));
        assertTrue(format.isNullOrEmpty("   "));
        assertFalse(format.isNullOrEmpty("123"));
        assertFalse(format.isNullOrEmpty("abc"));
    }

    @Test
    public void trimPersonalNumberTest() {

        assertEquals("7802022389", format.trimPersonalNumber("197802022389"));
        assertEquals("7802022389", format.trimPersonalNumber("197802022389"));

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

    }


    @Test
        public void removeDashTest(){
            assertEquals("197802022389",format.removeDashFromString("19780202-2389"));
            assertEquals("7802022389",format.removeDashFromString("780202-2389"));
            assertEquals("7802022389",format.removeDashFromString("78-02022389"));
            assertEquals("197802022389",format.removeDashFromString("19780202--2389"));
            assertEquals("197802022389",format.removeDashFromString("197802022---389"));
            assertNotEquals("197802022389",format.removeDashFromString("19780202*2389"));

        }
}
