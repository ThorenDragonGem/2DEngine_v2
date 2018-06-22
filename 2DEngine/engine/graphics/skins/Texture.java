package graphics.skins;

import java.awt.image.*;

public class Texture extends Skin2D
{
	private String name;
	
	public Texture(String name, BufferedImage texture)
	{
		this.name = name;
		setCurrentSkin(texture);
	}

	@Override
	public void update(double delta)
	{
		// TODO verify if update setCurrentSkin necessary
	}

	public String getName()
	{
		return name;
	}
}
