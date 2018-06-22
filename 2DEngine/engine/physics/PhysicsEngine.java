package physics;

import java.util.*;

import physics.bodies.*;

public class PhysicsEngine
{
	private static List<RigidBody> bodies;
	
	public PhysicsEngine()
	{
		bodies = new ArrayList<>();
	}
	
	public void update(double delta)
	{
		Iterator<RigidBody> it = bodies.iterator();
		while(it.hasNext())
		{
			RigidBody b = it.next();
			if(!b.isActive())
			{
				it.remove();
			}
			b.update(delta);
		}
	}
	
	public static List<RigidBody> getBodies()
	{
		return bodies;
	}
}
