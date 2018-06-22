package graphics.skins;

import java.awt.image.*;

public class Animation extends Skin2D
{
	private BufferedImage[] frames;
	private int speed, index;
	private long lastTime, timer;
	private boolean loops, started;

	public Animation(int speed, BufferedImage[] frames, boolean loops)
	{
		this.speed = speed;
		this.frames = frames;
		this.loops = loops;
		index = 0;
		lastTime = System.currentTimeMillis();
		started = true;
	}

	@Override
	public void update(double delta)
	{
		if(!started)
		{
			return;
		}
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();

		if(timer > speed)
		{
			index++;
			timer = 0;
			if(loops)
			{
				if(index >= frames.length)
				{
					index = 0;
				}
			}
			else
			{
				if(index >= frames.length)
				{
					index--;
					started = false;
				}
			}
		}
		setCurrentSkin(frames[index]);
	}
	
	public boolean isFinished()
	{
		return index == (frames.length - 1);
	}
	
	public void restart()
	{
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
		started = true;
	}
	
	public void start()
	{
		started = true;
	}
	
	public void stop()
	{
		started = false;
	}
	
	public int getSpeed()
	{
		return speed;
	}

	public int getAnimationTime()
	{
		return speed * frames.length;
	}

	public long getTimer()
	{
		return timer;
	}

	public boolean hasStarted()
	{
		return started;
	}
}
