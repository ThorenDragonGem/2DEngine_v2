package tests;

import net.beadsproject.beads.core.*;
import net.beadsproject.beads.ugens.*;

public class Test2
{
	public static void main(String[] args)
	{
		AudioContext ac;
		ac = new AudioContext();
		Noise noise = new Noise(ac);
		Gain g = new Gain(ac, 1, 0.1f);
		g.addInput(noise);
		ac.out.addInput(g);
		ac.start();
	}
}
