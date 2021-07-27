package redbacks.certifications;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.stream.Collectors;

public class Question2 {
	/*
	 * Modify this function to return 4613
	 */
	int teamNumber() {
		return 0;
	}

	/*
	 * Create a function 'add' which accepts two doubles as input and returns the sum
	 */
	// Write your code here

	/*
	 * Create a function 'xor' which accepts two booleans as input and returns whether exactly one of them is true
	 */
	// Write your code here

	/*
	 * Create a function 'print' which takes two booleans as input, and prints the result of calling 'xor' with those booleans as inputs
	 */
	// Write your code here

	/*
	 * The function 'operateUsing' accepts another function as an input. It will call this function with the number 4613.
	 *
	 * Create a function 'operations' which calls 'operateUsing' once with each of the following inputs:
	 *  - The function to print to the console
	 *  - A function which takes a double as an input and prints the sine of the result.
	 *    You may either create this as a named function like the tasks above, or use the arrow operator.
	 */
	// Write your code here

	/*
	 * Testing code, do not modify
	 */
	ByteArrayOutputStream bytes;
	PrintStream stdOut, newOut;
	List<Object> operationList;

	@BeforeEach
	void beforeEach() {
		bytes = new ByteArrayOutputStream();
		newOut = new PrintStream(bytes);
		stdOut = System.out;

		System.setOut(newOut);

		operationList = new ArrayList<Object>();
	}

	@AfterEach
	void afterEach() {
		newOut.close();
		System.setOut(stdOut);
	}

	@Test
	void testTeamNumber() {
		assertEquals(4613, teamNumber());
	}

	@Test
	void testAdd() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method method = getClass().getDeclaredMethod("add", Double.TYPE, Double.TYPE);

		assertEquals(Double.TYPE, method.getReturnType());
		assertEquals(28.41, (double)method.invoke(this, 46.13, -17.72), 1e-6);
	}

	@Test
	void testXor() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method method = getClass().getDeclaredMethod("xor", Boolean.TYPE, Boolean.TYPE);
		assertEquals(Boolean.TYPE, method.getReturnType());

		assertEquals(false, method.invoke(this, true, true));
		assertEquals(true, method.invoke(this, true, false));
		assertEquals(true, method.invoke(this, false, true));
		assertEquals(false, method.invoke(this, false, false));
	}

	@Test
	void testPrint() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method method = getClass().getDeclaredMethod("print", Boolean.TYPE, Boolean.TYPE);
		assertEquals(Void.TYPE, method.getReturnType());

		method.invoke(this, true, true);
		assertEquals(String.format("false%n"), bytes.toString());
		bytes.reset();

		method.invoke(this, true, false);
		assertEquals(String.format("true%n"), bytes.toString());
		bytes.reset();

		method.invoke(this, false, true);
		assertEquals(String.format("true%n"), bytes.toString());
		bytes.reset();

		method.invoke(this, false, false);
		assertEquals(String.format("false%n"), bytes.toString());
		bytes.reset();
	}

	@Test
	void testOperate() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method method = getClass().getDeclaredMethod("operations");
		assertEquals(Void.TYPE, method.getReturnType());

		method.invoke(this);

		assertEquals(2, operationList.size());
		assertLinesMatch(
			Arrays.asList("4613.0", "0.909460435207148"),
			bytes.toString().lines().collect(Collectors.toList())
		);
	}

	void operateUsing(DoubleConsumer function) {
		operationList.add(function);
		function.accept(4613);
	}
}
