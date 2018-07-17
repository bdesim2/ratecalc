package com.ratecalc.constants;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for functions in the Day enum
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class TestDay {

    // TEST VARIABLES
    private String abbreviation = "mon";
    private int value = 5;

    @Test
    public void testConvertToFullDay(){
        Assert.assertEquals("MONDAY", Day.convertToFullDay(abbreviation));
    }

    @Test
    public void testConvertValueToAbbreviation(){
        Assert.assertEquals("thurs", Day.convertValueToAbbreviation(value));
    }

}
