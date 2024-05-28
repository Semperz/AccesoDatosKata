package edu.badpals.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WizardTest {
    @Test
    public void testGetItem(){
        Wizard wizard = new Wizard();
        assertEquals("",wizard.getWizardName());

    }
}
