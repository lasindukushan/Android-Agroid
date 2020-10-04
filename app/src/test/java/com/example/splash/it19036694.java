package com.example.splash;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class it19036694 {

    private DeisesID deid;

    @Before
    public void setup(){
        deid= new DeisesID();
    }

    @Test
    public void validateNameTestFalse(){
        boolean result = deid.validateName("");
        assertEquals(false , result);
    }

    @Test
    public void validateNameTestTrue(){
        boolean result = deid.validateCause_it("as");
        assertEquals(true , result);
    }

    @Test
    public void validateCause_itTestFalse(){
        boolean result = deid.validateCause_it("");
        assertEquals(false , result);
    }

    @Test
    public void validatecause_itTestTrue(){
        boolean result = deid.validateCause_it("as");
        assertEquals(true , result);
    }

    @Test
    public void validateLook_likeFalse(){
        boolean result = deid.validateLook_like("");
        assertEquals(false , result);
    }

    @Test
    public void validateLook_likeTrue(){
        boolean result = deid.validateLook_like("as");
        assertEquals(true , result);
    }

    @Test
    public void validateCan_doFalse(){
        boolean result = deid.validateLook_like("");
        assertEquals(false , result);
    }

    @Test
    public void validateCan_doTrue(){
        boolean result = deid.validateLook_like("as");
        assertEquals(true , result);
    }
}

