package sounds;

import java.util.concurrent.*;

public class ActivityManager
{
	private static ActivityManager _activityManager = null;
	
	private final ExecutorService _executorService;
	
	public static ActivityManager getInstance()
	{
		if(_activityManager == null)
		{
			_activityManager = new ActivityManager();
		}
		return _activityManager;
	}
	
	private ActivityManager()
	{
		_executorService = Executors.newCachedThreadPool();
	}
	
	public void submit(final Runnable task)
	{
		_executorService.submit(task);
	}
}