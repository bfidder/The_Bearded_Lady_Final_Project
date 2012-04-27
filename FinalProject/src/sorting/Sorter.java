package sorting;

import java.util.*;


public abstract class Sorter {
	protected ArrayList<Integer> data;
	protected LinkedList<Swap> swapList;
	
	public abstract LinkedList<Swap> sort();
	public abstract String getName();
	
	public Sorter(int ... data){
		this.data = new ArrayList<Integer>();
		for (int i: data) this.data.add(i);
		this.swapList = new LinkedList<Swap>();
	}
	
	public Sorter(ArrayList<Integer> data){
		this.data = data;
		this.swapList = new LinkedList<Swap>();
	}
	
	protected void doSwap(int loc1, int loc2) {
		swapList.add(new Swap(loc1, loc2));
		
		Collections.swap(data, loc1, loc2);
	}
	
	public ArrayList<Integer> getData() {
		return data;
	}
}
