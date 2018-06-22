package physics.env;

public abstract class Environnement
{
	private String name;
	
	protected float friction;

	public Environnement(String name)
	{
		this.name = name;
	}

	public abstract void update(double delta);

	public String getName()
	{
		return name;
	}
	
	public Environnement getEnvironnement()
	{
		return this;
	}

	@Override
	public String toString()
	{
		return "(Env: " + name + ")";
	}
}
