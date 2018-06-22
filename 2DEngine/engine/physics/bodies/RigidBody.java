package physics.bodies;

public class RigidBody
{
	private boolean active;
	private AABB bounding_box;
	private Vector2f forcesSum;
	private float penetration;
	private float friction;
	// get ambient system => equation between friction and penetration
	// (0 , 1 in void)
	
	public RigidBody(float x, float y, float width, float height)
	{
		active = true;
		bounding_box = new AABB(new Vector2f(x, y), new Vector2f(width, height));
		forcesSum = new Vector2f();
	}
	
	public void update(double delta)
	{

	}
	
	public boolean isActive()
	{
		return active;
	}

	public void translate(float x, float y)
	{
		bounding_box.translate(x, y);
	}
	
	public AABB getBounds()
	{
		return bounding_box;
	}
	
	@Override
	public String toString()
	{
		return "{" + active + " | " + bounding_box.toString() + "}";
	}
}
