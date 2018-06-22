package core;

import assets.*;
import core.display.*;
import core.i.*;
import graphics.*;
import inputs.*;
import utils.*;

public class Engine implements Runnable
{
	public static Input inputs;
	public static Instance instance, coreInstance;
	
	private Assets assets;
	private GraphicEngine graphics;
	private Timer timer;
	private Thread thread;
	
	public static boolean running;
	private double tickTime, renderTime, delta, alpha, fps = -1, tps = 60;
	
	public Engine(Instance instance, String title, int width, int height)
	{
		assets = new Assets();
		graphics = new GraphicEngine(new Display(title, width, height));
		inputs = new Input(graphics.getDisplay().getFrame(), graphics.getDisplay().getCanvas());
		
		coreInstance = instance;
		
		Engine.instance = new AssetsInstance(assets);

		start();
	}

	public void init() throws Exception
	{
		if(instance != null)
		{
			System.out.println(instance);
			instance.init();
		}
	}

	public void update()
	{
		inputs.update();
		if(instance != null)
		{
			instance.update(delta / 1000000000);
		}
	}

	public void render()
	{
		if(instance != null)
		{
			graphics.update();
			instance.render(graphics);
			graphics.clear();
		}
	}

	public void cleanUp() throws Throwable
	{
		if(instance != null)
		{
			instance.cleanUp();
		}
		assets.cleanUp();
	}
	
	public synchronized void start()
	{
		if(running)
		{
			return;
		}
		running = true;
		thread = new Thread(this);
		if(System.getProperties().getProperty("os.name").contains("Mac"))
		{
			thread.run();
		}
		else
		{
			thread.start();
		}
	}
	
	public synchronized void stop()
	{
		try
		{
			// utility???
			// graphics.getDisplay().close();
			// thread.join();
			System.exit(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void run()
	{
		tickTime = 1000000000.0 / tps;
		renderTime = 1000000000.0 / fps;
		double updatedTime = 0.0;
		double renderedTime = 0.0;
		delta = 0;
		alpha = 0;

		int secondTime = 0;
		boolean second;
		int frames = 0;
		int ticks = 0;
		timer = new Timer();
		try
		{
			init();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		while(running)
		{
			second = false;
			delta = timer.getElapsed() - updatedTime;
			alpha = timer.getElapsed() - renderedTime;

			if(delta >= tickTime)
			{
				update();
				ticks++;

				secondTime++;
				if((secondTime % tps) == 0)
				{
					second = true;
					secondTime = 0;
				}
				updatedTime += tickTime;
			}
			else if(alpha >= renderTime)
			{
				render();
				frames++;
				renderedTime += renderTime;
			}
			else
			{
				try
				{
					Thread.sleep(1);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			if(second)
			{
				graphics.getDisplay().getFrame()
						.setTitle(graphics.getDisplay().getTitle() + " | " + ticks + " tps, " + frames + " fps");
				frames = 0;
				ticks = 0;
			}
		}
		try
		{
			cleanUp();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		stop();
	}
}
