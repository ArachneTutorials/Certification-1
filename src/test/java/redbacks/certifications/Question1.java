package redbacks.certifications;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

public class Question1 {
	/*
	 * Create the following variables:
	 *  - an integer 'x' set to 4613
	 *  - a Talon FX 'motor' using the WPI_TalonFX class with ID 7
	 *  - a double 'third' set to the fraction 'minus one-third'
	 *  - a double 'trig' set to sin(5)
	 *  - a String 'text' set to "The value of sin(5) is [insert value here]"
	 */

	// Write your code here

	/*
	 * Testing code, do not modify
	 */
	@Test
	void testX() throws NoSuchFieldException, SecurityException, IllegalAccessException {
		Field field = getClass().getDeclaredField("x");

		assertEquals(Integer.TYPE, field.getType());
		assertEquals(4613, field.getInt(this));
	}

	@Test
	void testMotor() throws NoSuchFieldException, SecurityException, IllegalAccessException {
		Field field = getClass().getDeclaredField("motor");

		assertEquals(WPI_TalonFX.class, field.getType());
		assertEquals(7, ((WPI_TalonFX)field.get(this)).id);
	}

	@Test
	void testThird() throws NoSuchFieldException, SecurityException, IllegalAccessException {
		Field field = getClass().getDeclaredField("third");

		assertEquals(Double.TYPE, field.getType());
		assertEquals(-0.3333333333333333, field.getDouble(this)); // Don't copy this, you'll be marked wrong
	}

	@Test
	void testTrig() throws NoSuchFieldException, SecurityException, IllegalAccessException {
		Field field = getClass().getDeclaredField("trig");

		assertEquals(Double.TYPE, field.getType());
		assertEquals(-0.9589242746631385, field.getDouble(this)); // Don't copy this, you'll be marked wrong
	}

	@Test
	void testText() throws NoSuchFieldException, SecurityException, IllegalAccessException {
		Field field = getClass().getDeclaredField("text");

		assertEquals(String.class, field.getType());
		assertEquals("The value of sin(5) is -0.9589242746631385", field.get(this)); // Don't copy this, you'll be marked wrong
	}

	/**
	 * Fake WPI_TalonFX class to avoid test crashes
	 */
	class WPI_TalonFX {
		final int id;

		WPI_TalonFX(int deviceNumber) {
			this.id = deviceNumber;
		}
	}
}
