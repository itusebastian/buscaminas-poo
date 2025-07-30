package test.com.itulabs.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserInputHandlerTest {


	@Test
	void testAskActionFromInputDiscover() {
		com.itulabs.main.UserInputHandler.Action action = com.itulabs.main.UserInputHandler.askActionFromInput("A1", 2);
		assertFalse(action.isFlag);
		assertEquals(0, action.coord.getX());
		assertEquals(0, action.coord.getY());
	}

	@Test
	void testAskActionFromInputFlag() {
		com.itulabs.main.UserInputHandler.Action action = com.itulabs.main.UserInputHandler.askActionFromInput("F B2", 3);
		assertTrue(action.isFlag);
		assertEquals(1, action.coord.getX());
		assertEquals(1, action.coord.getY());
	}

	@Test
	void testAskActionFromInputInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			com.itulabs.main.UserInputHandler.askActionFromInput("Z9", 2);
		});
	}

}
