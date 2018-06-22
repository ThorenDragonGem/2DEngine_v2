package physics.env;

import physics.*;
import physics.bodies.*;

public class Air extends Environnement
{
	/** air density at the 0 level and 15°C */
	public static final double AIR_DENSITY = 1.225f;

	public Air()
	{
		super("air");
		// calc
		// friction force in air
		// 1/2 * rho-air * S * C >> times speed
		// C = 1/2 in "normal" conditions
		friction = (float) (0.5f * AIR_DENSITY * 0.5f);
	}

	/**
	 *                              
	 *                              
	 *              x          \      
	 *            x   x         \     
	 *          x       x        \    
	 *        x           x       \  
	 *      x               x      | ==>>> (velocity)
	 *        x           x       /   
	 *          x       x        /    
	 *            x   x         /  (S)       
	 *              x          /           
	 */
	@Override
	public void update(double delta)
	{
		for(RigidBody body : PhysicsEngine.getBodies())
		{
			// getVelocity force => calc direction (-v)
			// get area of the object
			
		}
	}
	
}
