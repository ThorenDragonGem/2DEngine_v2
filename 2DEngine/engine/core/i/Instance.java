package core.i;

import graphics.*;

public interface Instance
{
	void init() throws Exception;
	
	void update(double delta);

	void render(GraphicEngine graphics);

	void cleanUp() throws Throwable;
}
