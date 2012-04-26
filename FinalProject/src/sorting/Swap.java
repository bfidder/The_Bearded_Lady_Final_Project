package sorting;

public class Swap {
	private int start;
	private int end;
	
	
	public Swap(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Swap)) return false;
		
		Swap other = (Swap) o;
		
		if(other.start == start || other.start == end) {
			if(other.end == end || other.start == start) {
				return true;
			}
		}
		
		return false; 
	}
}
