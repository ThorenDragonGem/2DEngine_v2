package tests;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

import javax.sound.sampled.*;

import assets.*;
import core.*;
import core.i.*;
import graphics.*;
import inputs.*;
import sounds.sound.*;

public class Test implements Instance
{
	public static void main(String[] args)
	{
		new Engine(new Test(), "Tests", 1280, 720);
	}
	
	Clip bird;
	InputStream in;
	// AudioStream au;
	
	WavSound sound;
	WavPlayer player;
	
	List<WavSound> sounds;
	
	@Override
	public void init() throws Exception
	{
		sounds = new ArrayList<>();
		// works
		// try
		// {
		// AudioInputStream audioInputStream = AudioSystem
		// .getAudioInputStream(new File("./assets/sounds/bird.wav").getAbsoluteFile());
		// bird = AudioSystem.getClip();
		// bird.open(audioInputStream);
		// }
		// catch(Exception ex)
		// {
		// System.out.println("Error with playing sound.");
		// ex.printStackTrace();
		// }
		// bird.addLineListener(event ->
		// {
		// if(event.getType() == LineEvent.Type.STOP)
		// {
		// System.out.println(true);
		// bird.stop();
		// }
		// });
		//
		// in = new FileInputStream(new File("./assets/sounds/bird.wav"));
		// au = new AudioStream(in);
		
		// AudioPlayer.player.start(au);
		// AudioPlayer.player.stop(au);
		sound = WavPlayer.loadSound("bird.wav");
		System.out.println(sound);
	}
	
	Thread[] array = new Thread[20];
	
	@Override
	public void update(double delta)
	{
		if(Engine.inputs.isKeyPressed(Keyboard.ESCAPE))
		{
			Engine.running = false;
		}
		if(Engine.inputs.isKeyPressed(Keyboard.I))
		{
			System.out.println(true);
			WavSound sound = WavPlayer.loadSound("bird.wav");
			sounds.add(sound);
			sound.play();
			// AudioPlayer.player.start(au);
			// bird.start();
		}
		System.out.println(Thread.activeCount());
		for(WavSound sound : sounds)
		{
			if(sound.getState() == SoundState.STATE_STOPPED)
			{
			}
		}
	}
	
	@Override
	public void render(GraphicEngine graphics)
	{
		graphics.getGraphics().setColor(Color.red);
		graphics.getGraphics().fillRect(100, 100, 100, 100);
		graphics.getGraphics().drawImage(Assets.getTexture("shield").getCurrentSkin(), 100, 100, 100, 100, null);
	}
	
	@Override
	public void cleanUp()
	{
		
	}
}
