package testing;

import org.junit.*;
import sorting.*;

public class InsertionTests {
	Sorter theSort;
	double[] data;
	final int SIZE = 10;
	
	@Before
	public void init() {
		data = new double[SIZE];
		theSort = new InsertionSort(data);
	}
}
