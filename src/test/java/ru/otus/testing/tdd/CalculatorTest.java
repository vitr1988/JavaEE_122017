package ru.otus.testing.tdd;

import static org.junit.Assert.*;

import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;

public class CalculatorTest {

    private static Connection connection;

    @BeforeClass
    public static void setUp(){
        //TODO: initialization connection
    }

    @AfterClass
    public static void tearDown(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testAddOperation(){
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
        assertEquals(300, calculator.add(100, 200));
        assertEquals(-300, calculator.add(-100, -200));
//        assertEquals(-500, calculator.add(-100, -400));

    }
    @Test
    public void testSubtractOperation(){
        Calculator calculator = new Calculator();
        assertEquals(-1, calculator.minus(2, 3));
        assertEquals(-100, calculator.minus(100, 200));
        assertEquals(100, calculator.minus(-100, -200));
//        assertEquals(-500, calculator.add(-100, -400));

    }
}
