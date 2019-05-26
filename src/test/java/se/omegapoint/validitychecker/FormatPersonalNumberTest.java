package se.omegapoint.validitychecker;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormatPersonalNumberTest {

    private final FormatPersonalNumber format = new FormatPersonalNumber();


    @Test
    public void formatPersonalNumber() {
        assertEquals("7802022389",format.formatPersonalNumber("19780202-2389"));
        assertEquals("7802022389",format.formatPersonalNumber("19780202238-9"));
        assertEquals("7802022389",format.formatPersonalNumber("19780202238--9"));
        assertEquals("7802022389",format.formatPersonalNumber("AB7802022389"));
        assertEquals(null,format.formatPersonalNumber("1978020223899"));
        assertEquals(null,format.formatPersonalNumber("197802029"));





    }

    @Test
    public void removeDashFromString() {
        assertEquals("197802022389",format.removeDashFromString("19780202-2389"));
        assertEquals("7802022389",format.removeDashFromString("780202-2389"));
        assertEquals("7802022389",format.removeDashFromString("78-02022389"));
        assertEquals("197802022389",format.removeDashFromString("19780202--2389"));
        assertEquals("197802022389",format.removeDashFromString("197802022---389"));
        assertNotEquals("197802022389",format.removeDashFromString("19780202*2389"));

    }

    @Test
    public void trimPersonalNumber() {
        assertEquals("7802022389", format.trimPersonalNumber("197802022389"));
        assertEquals("7802022389", format.trimPersonalNumber("197802022389"));

    }

    @Test
    public void isNullOrEmpty() {
        assertTrue(format.isNullOrEmpty(""));
        assertTrue(format.isNullOrEmpty(null));
        assertTrue(format.isNullOrEmpty("   "));
        assertFalse(format.isNullOrEmpty("123"));
        assertFalse(format.isNullOrEmpty("abc"));

    }
}