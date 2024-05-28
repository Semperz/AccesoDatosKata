package edu.badpals.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagicalItemTest {
    @Test
    public void testGetItem(){
        MagicalItem item = new MagicalItem("Sulfuras", 80, "Legandary");
        MagicalItem itemEmpty = new MagicalItem();
        assertEquals("Sulfuras", item.getName());
        assertEquals("", itemEmpty.getName());

    }
}
