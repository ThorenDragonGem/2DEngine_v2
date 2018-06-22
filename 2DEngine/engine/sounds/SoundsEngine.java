package sounds;

public class SoundsEngine
{
	// private void playSfx(final InputStream fileStream)
	// {
	// ActivityManager.getInstance().submit(() ->
	// {
	// try
	// {
	// BufferedInputStream bufferedStream = new BufferedInputStream(fileStream);
	// AudioInputStream audioInputStream =
	// AudioSystem.getAudioInputStream(bufferedStream);
	//
	// final int BUFFER_SIZE = 128000;
	// SourceDataLine sourceLine = null;
	//
	// AudioFormat audioFormat = audioInputStream.getFormat();
	// DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
	//
	// sourceLine = (SourceDataLine) AudioSystem.getLine(info);
	// sourceLine.open(audioFormat);
	// if(sourceLine == null)
	// {
	// return;
	// }
	//
	// sourceLine.start();
	// int nBytesRead = 0;
	// byte[] abData = new byte[BUFFER_SIZE];
	// while(nBytesRead != -1)
	// {
	// try
	// {
	// nBytesRead = bufferedStream.read(abData, 0, abData.length);
	// }
	// catch(IOException e1)
	// {
	// e1.printStackTrace();
	// }
	// if(nBytesRead >= 0)
	// {
	// sourceLine.write(abData, 0, nBytesRead);
	// }
	// }
	//
	// sourceLine.drain();
	// sourceLine.close();
	// bufferedStream.close();
	// audioInputStream.close();
	//
	// }
	// catch(IOException e2)
	// {
	// e2.printStackTrace();
	// }
	// catch(UnsupportedAudioFileException e3)
	// {
	// e3.printStackTrace();
	// }
	// catch(LineUnavailableException e4)
	// {
	// e4.printStackTrace();
	// System.exit(1);
	// }
	// catch(Exception e5)
	// {
	// e5.printStackTrace();
	// System.exit(1);
	// }
	// });
	// }
	//
	// public void playSound(String soundName)
	// {
	// getInstance().playSfx
	// }

	final int bufferSize = 16384;

	public SoundsEngine()
	{

	}

	public void playSound()
	{
		
	}
}
