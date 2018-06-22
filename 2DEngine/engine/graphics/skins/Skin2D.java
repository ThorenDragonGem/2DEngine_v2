package graphics.skins;

import java.awt.image.*;

public abstract class Skin2D
{
	private BufferedImage currentSkin;

	public abstract void update(double delta);

	public void setCurrentSkin(BufferedImage currentSkin)
	{
		this.currentSkin = currentSkin;
	}

	public BufferedImage getCurrentSkin()
	{
		return currentSkin;
	}

	public void cleanUp() throws Throwable
	{
		finalize();
	}
}
