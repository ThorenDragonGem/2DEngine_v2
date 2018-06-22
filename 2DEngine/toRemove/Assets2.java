package assets;

import java.io.*;
import java.util.*;

import javax.swing.*;

public class Assets2 extends SwingWorker<Integer, String>
{
	private int progress;
	
	public Assets2()
	{
		addPropertyChangeListener(evt ->
		{
			if(evt.getPropertyName().equals("progress"))
			{
				progress = (int) evt.getNewValue();
				System.out.println(progress);
			}
		});
	}

	@Override
	protected Integer doInBackground() throws Exception
	{
		System.out.println(System.getProperty("user.dir"));
		File userDir = new File(System.getProperty("user.dir") + "/assets/");
		return getFilesNumber(userDir, 0, 100);
	}

	public int getFilesNumber(File directory, double progressStart, double progressEnd)
	{
		File[] files = directory.listFiles();
		int nb = 0;
		if(files.length > 0)
		{
			/*
			 * Le calcul de l'avancement du traitement n'a que peu d'importance pour
			 * l'exemple.
			 */
			double step = (progressEnd - progressStart) / files.length;

			for(int i = 0; i < files.length; i++)
			{
				File f = files[i];
				double progress = progressStart + (i * step);

				/* Transmet la nouvelle progression. */
				setProgress(Math.min((int) progress, 100));

				/*
				 * Ajout d'un temps d'attente pour observer les changements à l'échelle
				 * "humaine".
				 */
				try
				{
					// TODO: remove
					Thread.sleep(50);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}

				if(f.isDirectory())
				{
					/* Publication du répertoire trouvé. */
					publish("Exploration du répertoire " + f.getAbsolutePath() + "...");
					nb += getFilesNumber(f, progress, progress + step);
				}
				else
				{
					/* Publication du fichier trouvé. */
					publish(f.getAbsolutePath());
					nb++;
				}
			}
		}
		return nb;
	}

	@Override
	protected void process(List<String> chunks)
	{
		for(String s : chunks)
		{
			System.out.println(s);
		}
	}

	@Override
	protected void done()
	{
		setProgress(100);
		System.out.println("done");
	}
}
