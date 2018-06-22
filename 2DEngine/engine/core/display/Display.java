package core.display;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Display
{
	private Canvas canvas;
	private JFrame display;
	private long screenId;
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		screenId = createScreen();
	}
	
	private long createScreen()
	{
		Random randomm = new Random();
		long id = randomm.nextLong();
		while(id == screenId)
		{
			id = randomm.nextLong();
		}
		display = new JFrame(title);
		display.setSize(width, height);
		display.setMinimumSize(new Dimension(width, height));
		display.setPreferredSize(new Dimension(width, height));
		display.setMaximumSize(new Dimension(width, height));
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setResizable(false);
		display.setLocationRelativeTo(null);
		display.setVisible(true);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		display.add(canvas);
		display.pack();

		return id;
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public JFrame getFrame()
	{
		return display;
	}

	public int getHeight()
	{
		return height;
	}
	
	public Display setTitle(String title)
	{
		this.title = title;
		display.setTitle(this.title);
		return this;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public int getWidth()
	{
		return width;
	}

	public void close()
	{
		display.dispose();
	}
}
