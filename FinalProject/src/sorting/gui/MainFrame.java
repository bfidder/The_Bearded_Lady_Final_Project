package sorting.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sorting.BubbleSort;
import sorting.InsertionSort;
import sorting.Sorter;

public class MainFrame extends JFrame {
	private static Sorter sorters[] = {new BubbleSort(), new InsertionSort()};
	private SortDisplay display;
	private Sorter sorter;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sort Shower");
		
		setMinimumSize(new Dimension(400, 300));
		setSize(600, 400);
		
		setLayout(new BorderLayout());
		add(new SortChoicePanel(), BorderLayout.NORTH);
		display = new TraceSortDisplay();
		add(display, BorderLayout.CENTER);
		add(new SortControlPanel(), BorderLayout.SOUTH);
	}
	
	private void setSorter(Sorter newSorter) {
		sorter = newSorter;
	}
	
	private class SortChoicePanel extends JPanel {
		public SortChoicePanel() {
			setLayout(new BorderLayout());
			
			JPanel sortersPanel = new JPanel();
			
			for (Sorter s: sorters) {
				JButton button = new SorterButton(s);
				sortersPanel.add(button);
			}
			
			add(sortersPanel, BorderLayout.WEST);
			
			JPanel displaysPanel = new JPanel();
			
			displaysPanel.add(new JButton("Your MOM not to scale"));
			
			add(displaysPanel, BorderLayout.EAST);
		}
	}
	
	private class SorterButton extends JButton {
		private Sorter sorter;
		
		public SorterButton(Sorter s) {
			super(s.getName());
			sorter = s;
			
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setSorter(sorter);
				}
			});
		}
	}
	
	private class SortControlPanel extends JPanel {
		public SortControlPanel() {
		}
	}
	
	public static void main(String args[]) {
		MainFrame mf = new MainFrame();
		
		mf.setVisible(true);
	}
}
