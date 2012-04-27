package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import org.junit.*;
import sorting.*;

public class HeapTests {
	Sorter theSort;
	LinkedList<Swap> swapList; 
	@Before
	public void init() {
		int[] data = { 3, 2, 7, 5, 11, 1, 6 };
		theSort = new HeapSort(data);
	}
	
	@Test
	public void actuallySortedTest() {
		 swapList = theSort.sort();
		 ArrayList<Integer> theSortedData = theSort.getData();
		 Collections.sort(theSortedData);
		 LinkedList<Swap> trueSwaps = new LinkedList<Swap>();
		 trueSwaps.add(new Swap(1, 4));
		 trueSwaps.add(new Swap(0, 1));
		 trueSwaps.add(new Swap(1, 3));
		 trueSwaps.add(new Swap(0, 6));
		 trueSwaps.add(new Swap(0, 2));
		 trueSwaps.add(new Swap(0, 5));
		 trueSwaps.add(new Swap(0, 2));
		 trueSwaps.add(new Swap(0, 4));
		 trueSwaps.add(new Swap(0, 1));
		 trueSwaps.add(new Swap(1, 3)); 
		 trueSwaps.add(new Swap(0, 3));
		 trueSwaps.add(new Swap(0, 1));
		 trueSwaps.add(new Swap(0, 2));
		 trueSwaps.add(new Swap(1, 0));
		 trueSwaps.add(new Swap(0, 1));
		 
		 assertEquals("Not correct size", swapList.size(), trueSwaps.size());
		 assertEquals("Elements not correct", swapList, trueSwaps);
		 assertEquals("Not really sorted", theSortedData, theSort.getData());
	}
}
