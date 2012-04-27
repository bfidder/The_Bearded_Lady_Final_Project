package testing;

import org.junit.*;
import sorting.*;

public class InsertionTests {
	Sorter theSort;
	int[] data;
	final int SIZE = 10;
	
	@Before
	public void init() {
		data = new int[SIZE];
		theSort = new InsertionSort(data);
	}
}
