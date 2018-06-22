package physics.bodies;

public class AABB
{
	private Vector2f position, dimensions;

	public AABB(Vector2f position, Vector2f dimensions)
	{
		this.position = position;
		this.dimensions = dimensions;
	}
	
	public AABB(float x, float y, float width, float height)
	{
		position = new Vector2f(x, y);
		dimensions = new Vector2f(width, height);
	}

	public Vector2f getPosition()
	{
		return position;
	}

	public Vector2f getDimensions()
	{
		return dimensions;
	}
	
	public void translate(float x, float y)
	{
		position.add(x, y);
	}

	@Override
	public String toString()
	{
		return "{ pos: " + position.toString() + " | dims: " + dimensions.toString() + "}";
	}
}
