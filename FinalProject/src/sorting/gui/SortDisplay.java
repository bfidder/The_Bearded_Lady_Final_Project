package sorting.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import sorting.*;

public abstract class SortDisplay extends JDialog {
	
	protected HashMap<Sorter,ArrayList<Integer>> allTheData;
	protected HashMap<Sorter,LinkedList<Swap>> allTheSwaps; 
	protected int numRect;
	public SortDisplay( int numRect, Sorter ... sorter) {
		this.allTheData = new HashMap<Sorter, ArrayList<Integer>>();
		this.allTheSwaps = new HashMap<Sorter, LinkedList<Swap>>();
		this.numRect = numRect;
		clearThenAddData(sorter);
		setup();
		
	}
	private void clearThenAddData(Sorter[] sorter) {
		ArrayList<Integer> data = new ArrayList<Integer>();
		for(int i = 0; i < 360; i += 360/numRect ){
			data.add(i);
		}
		Collections.shuffle(data);
		for( Sorter s : sorter){
			s.setData((ArrayList<Integer>)data.clone());
			allTheData.put(s, (ArrayList<Integer>)data.clone());
			allTheSwaps.put(s,s.sort());
		}
	}
	private void setup() {
		JButton step = new JButton("Step");
	
		setLayout(new BorderLayout());
		setSize(600, 300);
		setToMiddle();
		//setResizable(false);
		add(new Display(),BorderLayout.CENTER);
		step.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				run(); 
			}
		});
		add(step, BorderLayout.EAST);

	}


	private void setToMiddle() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Point mid = new Point(
				(int)((dim.getWidth() - getWidth()) / 2),
				(int)((dim.getHeight() - getHeight()) / 2)
				);
		setLocation(mid); 
	}
	protected abstract void run(); 
	
	private class Display extends JPanel {
		public Display (){
			setBorder(new TitledBorder (new EtchedBorder(), "Comparison"));
		}
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			int widthRect = (int) ((getWidth()*.93)/numRect);
			int heightRect = (int) ((getHeight()*.9)/allTheSwaps.size());
			
			int numPrinted = 0;
			for(Sorter curSorter : allTheData.keySet()){
				
				ArrayList<Integer> curData = allTheData.get(curSorter);
				for(int i = 0; i<curData.size(); i++){
					float curpoint = (float)curData.get(i);
					g.setColor(Color.getHSBColor(curpoint/360, 1, 1f));
					g.fillRect(i*widthRect+20, (heightRect+1)*(numPrinted)+20, widthRect, heightRect);
				}
				numPrinted++;
			}
		}
	}
}
