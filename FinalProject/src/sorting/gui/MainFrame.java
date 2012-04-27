package sorting.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sorting.*;

public class MainFrame extends JFrame {
	private static Sorter sorters[] = {new BubbleSort(), new InsertionSort(), new HeapSort()};
	private Sorter sorter;
	JTextField numRects;
	
	public MainFrame() {
		JButton fastButton = new JButton("Compare Algorithms");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Sort Shower");
		setSize(550, 200);
		setResizable(false);
		numRects = new JTextField("A Number goes in here");
		setLayout(new BorderLayout());
		add(new SortChoicePanel(), BorderLayout.NORTH);
		fastButton.addActionListener(new Guo(numRects));
		add(numRects, BorderLayout.EAST);
		add(fastButton, BorderLayout.CENTER);
	}
	private void setSorter(Sorter newSorter) {
		sorter = newSorter;
	}
	
	private class SortChoicePanel extends JPanel {
		public SortChoicePanel() {
			setLayout(new BorderLayout());
			
			JPanel sortersPanel = new JPanel();
			
			for (Sorter s: sorters) {
				JButton button = new SorterButton(s,numRects);
				sortersPanel.add(button);
			}
			
			add(sortersPanel, BorderLayout.WEST);
			
			JPanel displaysPanel = new JPanel();
			
			
			add(displaysPanel, BorderLayout.EAST);
		}
	}
	
	private class SorterButton extends JButton {
		private Sorter sorter;
		public SorterButton(Sorter s,JTextField numRects) {
			super("Step-by-step " + s.getName());
			sorter = s;
			addActionListener(new Gho(numRects));
		}
		private class Gho implements ActionListener{
			private JTextField numRects;
			public Gho (JTextField numRects){
				this.numRects = numRects;
			}
			public void actionPerformed(ActionEvent e) {
				int parsedInt = 10;
				try{
					parsedInt = Integer.parseInt(numRects.getText());
				} catch(NumberFormatException n) {
					
				}
				SortDisplay popUp = new SortSlowDisplay(parsedInt,new Sorter[] {sorter});
				popUp.setVisible(true); 
			}
		}
	}
	private class Guo implements ActionListener{
		private JTextField numRects;
		public Guo (JTextField numRects){
			this.numRects = numRects;
		}
		public void actionPerformed(ActionEvent e) {
			int fromTextField = 10;
			try{
				fromTextField = Integer.parseInt(numRects.getText());
			} catch(NumberFormatException n) {
				
			}
			SortDisplay popUp = new SortFastDisplay(fromTextField,sorters);
			popUp.setVisible(true); 
		}
	}
	public static void main(String args[]) {
		MainFrame mf = new MainFrame();
		
		mf.setVisible(true);
	}
}
