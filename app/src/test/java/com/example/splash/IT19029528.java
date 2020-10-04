package com.example.splash;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IT19029528 {
    private CropHelper helperClass;

    @Before
    public void setup(){
        helperClass = new CropHelper();
    }

    @Test
    public void validateCropNameTestFalse(){
        boolean result = helperClass.validateCropName("");
        assertEquals(false , result);
    }

    @Test
    public void validateCropNameTestTrue(){
        boolean result = helperClass.validateCropName("Mango");
        assertEquals(true , result);
    }

    @Test
    public void validateCropDescriptionTestFalse(){
        boolean result = helperClass.validateCropDescription("");
        assertEquals(false , result);
    }

    @Test
    public void validateCropDescriptionTestTrue(){
        boolean result = helperClass.validateCropDescription("Mango Description");
        assertEquals(true , result);
    }

    @Test
    public void validateCropIDFalse(){
        boolean result = helperClass.validateCropName("");
        assertEquals(false , result);
    }

    @Test
    public void validateCropIDTrue(){
        boolean result = helperClass.validateCropName("7");
        assertEquals(true , result);
    }

    @Test
    public void expectIntegerCropIDTestTrue(){
        boolean result = helperClass.expectIntegerCropID(2);
        assertEquals(true , result);
    }

    @Test
    public void expectIntegerCropIDTestFalse(){
        boolean result = helperClass.expectIntegerCropID(-2);
        assertEquals(false , result);
    }



}
