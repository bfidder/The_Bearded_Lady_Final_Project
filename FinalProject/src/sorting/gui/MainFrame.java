package sorting.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sorting.BubbleSort;
import sorting.InsertionSort;

public class MainFrame extends JFrame {
	private static Class sorters[] = {BubbleSort.class, InsertionSort.class};
	private SortDisplay display;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sort Shower");
		
		setMinimumSize(new Dimension(400, 300));
		setSize(600, 400);
		
		setLayout(new BorderLayout());
		add(new SortChoicePanel(), BorderLayout.NORTH);
		//add(new TraceSortDisplay(), BorderLayout.CENTER);
		add(new SortControlPanel(), BorderLayout.SOUTH);
	}
	
	private class SortChoicePanel extends JPanel {	
		public SortChoicePanel() {
			for (Class c: sorters) {
				try {
					JButton button = new JButton((String) c.getField("name").get(null));
					add(button);
				} catch (Exception e) {}
			}
		}
	}
	private class SortControlPanel extends JPanel {
		public SortControlPanel() {
			for (Class c: sorters) {
			}
		}
	}
	
	public static void main(String args[]) {
		MainFrame mf = new MainFrame();
		
		mf.setVisible(true);
	}
}
