package graphics;

import java.awt.*;
import java.awt.image.*;

import core.display.*;

public class GraphicEngine
{
	private Display display;
	private BufferStrategy bs;
	private Graphics graphics;
	
	public GraphicEngine(Display display)
	{
		this.display = display;
	}
	
	public void update()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			bs = display.getCanvas().getBufferStrategy();
		}
		graphics = bs.getDrawGraphics();
		graphics.clearRect(0, 0, display.getWidth(), display.getHeight());
	}

	public void clear()
	{
		if(bs != null)
		{
			bs.show();
		}
		if(graphics != null)
		{
			graphics.dispose();
		}
	}

	public Graphics getGraphics()
	{
		return graphics;
	}

	public BufferStrategy getBufferStrategy()
	{
		return bs;
	}
	
	public Display getDisplay()
	{
		return display;
	}
}
