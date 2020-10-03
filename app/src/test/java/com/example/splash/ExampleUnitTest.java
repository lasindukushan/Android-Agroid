package com.example.splash;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private PesticideCal pestiCal;

    @Before
    public void setUp(){
        pestiCal = new PesticideCal();
    }

    @Test
    public void check_Result1(){
        double result = pestiCal.calculateResult(60,12,0.5);
        assertEquals(10.0,result,0.001);
    }

    @Test
    public void check_Result2(){
        double result = pestiCal.calculateResult(50,10,2);
        assertEquals(2.0,result,0.001);
    }


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}