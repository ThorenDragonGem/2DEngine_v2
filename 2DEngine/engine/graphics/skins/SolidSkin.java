package graphics.skins;

import java.awt.*;
import java.awt.image.*;

public class SolidSkin extends Skin2D
{
	
	public SolidSkin(Color color)
	{
		BufferedImage texture = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		texture.setRGB(0, 0, color.getRGB());
		setCurrentSkin(texture);
	}
	
	@Override
	public void update(double delta)
	{
		// TODO verify if update setCurrentSkin necessary
	}
	
}
