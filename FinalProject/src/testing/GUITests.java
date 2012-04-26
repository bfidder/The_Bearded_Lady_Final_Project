package testing;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

import sorting.gui.FastSort;

public class GUITests {

	@Test
	public void testColorGeneration() {
		assertEquals(Color.getHSBColor(0, 1, .5f), FastSort.returnColor(0));
	}

}
