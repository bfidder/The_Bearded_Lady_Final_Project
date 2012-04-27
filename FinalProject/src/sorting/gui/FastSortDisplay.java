package sorting.gui;

import java.awt.Color;

public class FastSortDisplay extends SortDisplay {
	public static Color returnColor(int color){
		return Color.getHSBColor(color / 360f, 1, .5f);
	}
}
