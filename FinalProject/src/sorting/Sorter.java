package sorting;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;


public abstract class Sorter {
	protected ArrayList<Integer> data;
	protected ArrayList<Integer> scrambledData;
	protected LinkedList<Swap> swapList;

	public abstract LinkedList<Swap> sort();
	public abstract String getName();

	private volatile Swap curSwap;

	public Sorter(int ... data){
		this.data = new ArrayList<Integer>();
		for (int i: data) this.data.add(i);
		scrambledData= (ArrayList<Integer>)this.data.clone();
		this.swapList = new LinkedList<Swap>();
	}

	public void setData(ArrayList<Integer> data) {
		this.data.clear();
		this.data = data;
		scrambledData= (ArrayList<Integer>)data.clone();
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
		return new ArrayList<Integer>(data);
	}

	public void draw(int leftX, int upperY, int height, int width, Graphics g){
		int widthRect = (int) (width)/scrambledData.size();
		for(int i = 0; i<scrambledData.size(); i++){
			float curPoint = (float)scrambledData.get(i);
			if(curSwap != null && (curSwap.getStart() == i || curSwap.getEnd() == i)){
				g.setColor(Color.BLACK);// if this point is being switched draw it as black
			}else{
				g.setColor(Color.getHSBColor(curPoint/360, 1, 1f));//if this point is not being switched draw it as its appropriate color
			}
			g.fillRect(i*widthRect+leftX, upperY , widthRect, height);
		}
	}
	public boolean nextStep(){
		if(!swapList.isEmpty()){
			curSwap = swapList.pop();
			Collections.swap(scrambledData, curSwap.getStart(), curSwap.getEnd());
			return true;
		}else{
			curSwap=null;
			return false;
		}
	}
}
