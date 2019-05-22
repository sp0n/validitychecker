package se.omegapoint.validitychecker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static se.omegapoint.validitychecker.ValidityChecker.calcElementInIntList;


public class ValidityCheckerTest {


    private static final ValidityChecker valid = new ValidityChecker();

    private List<Integer> list = Arrays.asList(1,9,7,8,0,2,0,2,2,3,8,9);
    private List<Integer> validList1 = Arrays.asList(7,8,0,2,0,2,2,3,8,9);
    private List<Integer> validList2 = Arrays.asList(8,2,0,4,1,1,2,3,8,0);


    @Test
    public void addStringInputToIntListTest() {
        assertEquals(list, ValidityChecker.addStringToIntList("197802022389"));
    }


    @Test
    public void inputIsNullOrEmptyTest() {
        assertTrue(ValidityChecker.isNullOrEmpty(""));
        assertTrue(ValidityChecker.isNullOrEmpty(null));
        assertTrue(ValidityChecker.isNullOrEmpty("   "));
        assertFalse(ValidityChecker.isNullOrEmpty("123"));
        assertFalse(ValidityChecker.isNullOrEmpty("abc"));
    }

    @Test
    public void trimPersonalNumberTest() {

        assertEquals("7802022389", ValidityChecker.trimPersonalNumber("197802022389"));
        assertEquals("7802022389", ValidityChecker.trimPersonalNumber("197802022389"));

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
    public void calcEachElementInIntListTest() {
        System.out.println(validList1);
        calcElementInIntList(validList1);
        System.out.println(validList2);
        calcElementInIntList(validList2);
            }






    @Test
    public void inputValidityTest(){
       assertTrue(valid.validityCheck("7802022389"));
       assertTrue(valid.validityCheck("197802022389"));
       assertTrue(valid.validityCheck("780202-2389"));
       assertTrue(valid.validityCheck("19780202-2389"));
//       assertFalse(valid.validityCheck("197-802022389"));

    }


    @Test
        public void removeMinusTest(){
            assertEquals("199012285335",valid.removeDashFromString("19901228-5335"));
            assertEquals("9012285335",valid.removeDashFromString("901228-5335"));
            assertNotEquals("9012285335",valid.removeDashFromString("9012285-335"));
            assertNotEquals("199012285335",valid.removeDashFromString("19-901228-5335"));
            assertEquals("199012285335",valid.removeDashFromString("19901228-5-335"));

        }
}
