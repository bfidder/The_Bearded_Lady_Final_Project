package sorting.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import sorting.Sorter;
import sorting.Swap;

public class SortFastDisplay extends SortDisplay implements Runnable {
	JTextField speed;
	public SortFastDisplay(int numRect, Sorter[] sorter) {
		super(numRect, sorter);
		speed = new JTextField("Delay");
		add(speed,BorderLayout.SOUTH);
	}
	/*
	 * sorts using all three sorting types until the number of steps 
	 * done is equal to the size of the data to sort. It repaints 
	 * the display every time a swap is executed.  
	 */
	@Override
	public void run() {
		allTheSorters = (ArrayList<Sorter>)allTheSorters.clone();
		int numDone = 0;


		while(numDone < allTheSorters.size()){
			numDone=0;
			for(Sorter s : allTheSorters){
				if(!s.nextStep()){
					numDone++;
				}
			}
			int speedNum;
			try {
				speedNum = Integer.parseInt(speed.getText());
			} catch (NumberFormatException e) {
				speedNum = 50;
			}
			try {
				repaint();

				Thread.sleep(speedNum);
			} catch (InterruptedException e) {

			}


		}
	}
}
