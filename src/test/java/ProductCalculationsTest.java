/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.producsalesgui;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author deepl
 */

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {

        ProductCalculations calc =
                new ProductCalculations(3500);

        assertEquals(
                525.0,
                calc.GetVat(),
                0.01);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {

        ProductCalculations calc =
                new ProductCalculations(3500);

        assertEquals(
                4200.0,
                calc.GetTotal(),
                0.01);
    }
}