package physics.bodies;

public class Vector2f
{
	private float x, y;

	public Vector2f(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector2f(float f)
	{
		this(f, f);
	}
	
	public Vector2f()
	{
		this(0, 0);
	}

	public void add(Vector2f v)
	{
		x += v.x;
		y += v.y;
	}

	public Vector2f add(Vector2f v, Vector2f res)
	{
		res.add(v);
		return res;
	}
	
	public void add(float x, float y)
	{
		this.x += x;
		this.y += y;
	}
	
	public Vector2f add(float x, float y, Vector2f res)
	{
		res.add(x, y);
		return res;
	}
	
	public void add(float f)
	{
		x += f;
		y += f;
	}

	public Vector2f add(float f, Vector2f res)
	{
		res.add(f);
		return res;
	}

	public void sub(Vector2f v)
	{
		x -= v.x;
		y -= v.y;
	}
	
	public Vector2f sub(Vector2f v, Vector2f res)
	{
		res.sub(v);
		return res;
	}
	
	public void sub(float x, float y)
	{
		this.x -= x;
		this.y -= y;
	}

	public Vector2f sub(float x, float y, Vector2f res)
	{
		res.sub(x, y);
		return res;
	}
	
	public void sub(float f)
	{
		x -= f;
		y -= f;
	}
	
	public Vector2f sub(float f, Vector2f res)
	{
		res.sub(f);
		return res;
	}

	public void mul(Vector2f v)
	{
		x *= v.x;
		y *= v.y;
	}
	
	public Vector2f mul(Vector2f v, Vector2f res)
	{
		res.mul(v);
		return res;
	}
	
	public void mul(float x, float y)
	{
		this.x *= x;
		this.y *= y;
	}
	
	public Vector2f mul(float x, float y, Vector2f res)
	{
		res.mul(x, y);
		return res;
	}
	
	public void mul(float f)
	{
		x *= f;
		y *= f;
	}
	
	public Vector2f mul(float f, Vector2f res)
	{
		res.mul(f);
		return res;
	}

	public void div(Vector2f v)
	{
		x /= v.x;
		y /= v.y;
	}
	
	public Vector2f div(Vector2f v, Vector2f res)
	{
		res.div(v);
		return res;
	}
	
	public void div(float x, float y)
	{
		this.x /= x;
		this.y /= y;
	}

	public Vector2f div(float x, float y, Vector2f res)
	{
		res.div(x, y);
		return res;
	}
	
	public void div(float f)
	{
		x /= f;
		y /= f;
	}

	public Vector2f div(float f, Vector2f res)
	{
		res.div(f);
		return res;
	}

	public float length()
	{
		return (float) (Math.sqrt((x * x) + (y * y)));
	}

	public Vector2f norm()
	{
		float l = length();
		return new Vector2f(x / l, y / l);
	}
	
	public Vector2f copy()
	{
		return new Vector2f(x, y);
	}

	@Override
	public String toString()
	{
		return "[" + x + ";" + y + "]";
	}
}
