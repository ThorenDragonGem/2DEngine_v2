package utils;

import java.awt.*;

import graphics.*;

public class TextUtils
{
	public static void drawString(String string, GraphicEngine graphics, Color color, int x, int y, int size,
			boolean centered)
	{
		graphics.getGraphics().setColor(color);
		graphics.getGraphics().getFont().deriveFont((float) size);
		FontMetrics metrics = graphics.getGraphics().getFontMetrics();
		int xx = x;
		int yy = y;
		if(centered)
		{
			xx -= metrics.stringWidth(string) / 2;
			yy -= metrics.getHeight() / 2;
		}
		graphics.getGraphics().drawString(string, xx, yy);
	}
}
