package sorting;

import java.util.LinkedList;


public abstract class Sorter {
	protected int data[];
	public Sorter(int ... data){
		this.data = data;
	}
	public abstract LinkedList<Swap> sort();
	
	public int[] getData() {
		return data;
	}
}
