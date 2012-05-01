package sorting.gui;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import sorting.*;

public abstract class SortDisplay extends JDialog implements Runnable {
	/** The number of rectangles per data set*/
	protected ArrayList<Sorter> allTheSorters;
	protected int numRect;



	public abstract void run(); 
	
	/* SortDisplay takes the number of colors to sort and Sorter objects
	   it initializes numRect and adds the sorters to an ArrayList of sorter objects
	   it also calls two helper methods which add the sorter to the gui with a
	   random order and evenly spaced numbers which are translated to colors
	   setup creates the sorting gui.*/
	
	public SortDisplay( int numRect, Sorter ... sorter) {
		this.numRect = numRect;
		allTheSorters = new ArrayList<Sorter>();
		for( Sorter s : sorter){
			allTheSorters.add(s);
		}
		clearThenAddData(sorter);
		setup();

	}
	
	private void clearThenAddData(Sorter[] sorter) {
		ArrayList<Integer> data = new ArrayList<Integer>();
		for(int i = 0; i < 360; i += 360/numRect ){//add the integer values to the array, they must be evenly spaces and cover the range from 0 to 360 for a full rainbow
			data.add(i);
		}
		Collections.shuffle(data); //randomize the integer values in the array
		for( Sorter s : sorter){
			s.setData((ArrayList<Integer>)data.clone());//for all the sorters set the data to the scrambled array
			s.sort();
		}
	}

	private void setup() {
		JButton step = new JButton("Go");

		setLayout(new BorderLayout());
		setSize(900, 300);
		setToMiddle();
		setResizable(true);
		add(new Display(), BorderLayout.CENTER);
		add(new sideNameBar(), BorderLayout.WEST);

		step.addActionListener(new Runner(this));
		add(step, BorderLayout.EAST);

	}
	private class Runner implements ActionListener{
		private Runnable thingToMake;
		Runner(Runnable r){
			thingToMake = r;
		}
		public void actionPerformed(ActionEvent e) {
			Thread runner = new Thread(thingToMake, "runner");
			runner.start();
		}
		
	}
	
	/*
	 * sets the position of the sorting gui to the middle of the page
	 */
	private void setToMiddle() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Point mid = new Point(
				(int)((dim.getWidth() - getWidth()) / 2),
				(int)((dim.getHeight() - getHeight()) / 2)
				);
		setLocation(mid); 
	}
	
	/*
	 * sets up the labeling of the sorts
	 */
	private class sideNameBar extends JPanel {
		public sideNameBar () {
			setup();
		}
		private void setup() {
			JLabel addingSorter;
			setLayout(new GridLayout(allTheSorters.size(),1));
			for(Sorter thisSorter: allTheSorters ) {
				addingSorter = new JLabel(thisSorter.getName());
				add(addingSorter);
			}
		}
	}
	/*
	 * paints the display for the sorting gui
	 */
	private class Display extends JPanel {
		public Display (){
			setBorder(new TitledBorder (new EtchedBorder(), "Sorting Algorithm"));
		}
		@Override
		public void paintComponent(Graphics g) {
				super.paintComponent(g);
				//int widthRect = (int) ((getWidth()*.93)/numRect);
				int heightRect = (int) ((getHeight()*.85)/allTheSorters.size());

				int numPrinted = 0;
				for(Sorter curSorter : allTheSorters){
					curSorter.draw(20,(numPrinted)* (heightRect+5)+20 , heightRect, getWidth(), g);
					numPrinted++;
				}


			
		}
	}
}

