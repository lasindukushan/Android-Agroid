package com.example.splash;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IT19100876 {
/*Test cases for pesticide calcultor*/
    private PesticideCal pestiCal;
    private static PesticideCal pestiCal1;

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

    /*Test cases for pesctical calculator inputs*/
    boolean i1;
    boolean i2;
    boolean i3;

    @BeforeClass
    public static void pessti(){
        pestiCal1 = new PesticideCal();
    }

    @Before
    public void setinputs(){
        i1 = false;
        i2 = false;
        i3 = false;
    }

    @Test
    public void Input1(){
        i1 = pestiCal1.isvalidInput1("60");
        assertTrue(i1);
    }

    @Test
    public void Input1Dup(){
        i1 = pestiCal1.isvalidInput1("6");
        assertTrue(i1);
    }

    @Test
    public void Input1dup2(){
        i1 = pestiCal1.isvalidInput1("abcc");
        assertTrue(i1);
    }

    /*Test cases for dochnages.java validations check*/

    private static DoChanges doChanges;

    boolean id;
    boolean url;
    boolean name;

    @BeforeClass
    public static void Do(){
        doChanges = new DoChanges();
    }

    @Before
    public void setDo(){
        id = false;
        url = false;
    }

    @Test
    public void checkName(){
        name = doChanges.validate2Name("carrot");
        assertTrue(name);
    }

    @Test
    public void check2Name(){
        name = doChanges.validate2Name("Potato1");
        assertTrue(name);
    }

    @Test
    public void check3Name(){
        name = doChanges.validate2Name("1111");
        assertTrue(name);
    }

    @Test
    public void check4Name(){
        name = doChanges.validate2Name("Carrot");
        assertTrue(name);
    }

    @Test
    public void checkurl(){
        url = doChanges.validate2url("abc.jpg");
        assertTrue(url);
    }

    @Test
    public void check2url(){
        url = doChanges.validate2url("abc.png");
        assertTrue(url);
    }

    @Test
    public void check3url(){
        url = doChanges.validate2url("abc");
        assertTrue(url);
    }

    @Test
    public void checkId(){
        id = doChanges.validateId("001");
        assertTrue(id);
    }

    @Test
    public void check2Id(){
        id = doChanges.validateId("1");
        assertTrue(id);
    }

    @Test
    public void check3Id(){
        id = doChanges.validate2url("Id5");
        assertTrue(id);
    }
}
