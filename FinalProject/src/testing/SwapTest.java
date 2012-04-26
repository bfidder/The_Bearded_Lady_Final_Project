package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;

import sorting.BubbleSort;
import sorting.MergeSort;
import sorting.Swap;

public class SwapTest {
	private Swap sw(int start, int end) {
		return new Swap(start, end);
	}
	private <T extends Collection<Swap>> void checkCollection(String message, T set, Swap ... swaps) {
		System.out.println(message);

		assertEquals("Collection had wrong length, got " + set, swaps.length, set.size());

		for (Swap s: swaps) {
			assertTrue("Expected " + s + " in collection, got " + set, set.contains(s));
		}
	}
	
	@Test
	public void testBubbleSortSwap() {
		BubbleSort bs = new BubbleSort(8, 6, 7, 3);
		checkCollection("checking bubblesort...", bs.sort(), sw(0, 1), sw(1, 2), sw(2, 3), sw(1, 2), sw(0, 1));
	}
	
	@Test
	public void testMergeSortSwap() {
		MergeSort ms = new MergeSort(8, 6, 7, 3);
		checkCollection("checking mergesort...", ms.sort(), sw(0, 1), sw(2, 3), sw(0, 2), sw(1, 2), sw(2, 3));
	}
	
	@Test
	public void testZeroSwapBubbleSort() {
		BubbleSort bs = new BubbleSort();
		checkCollection("bubblesort zero...", bs.sort());
	}
	
	@Test
	public void testZeroSwapMergeSort() {
		MergeSort ms = new MergeSort();
		checkCollection("mergesort zero...", ms.sort());
	}
	
	@Test
	public void testOneSwapBubbleSort() {
		BubbleSort bs = new BubbleSort(1);
		checkCollection("bubblesort zero...", bs.sort());
	}
	
	@Test
	public void testOneSwapMergeSort() {
		MergeSort ms = new MergeSort(1);
		checkCollection("mergesort zero...", ms.sort());
	}
	
}
