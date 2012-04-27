package sorting.gui;

import java.awt.Color;

public class TraceSortDisplay extends SortDisplay {
	public String getName() {
		return "Trace Display";
	}
	
	public static Color returnColor(int color){
		return Color.getHSBColor(color / 360f, 1, .5f);
	}
}
