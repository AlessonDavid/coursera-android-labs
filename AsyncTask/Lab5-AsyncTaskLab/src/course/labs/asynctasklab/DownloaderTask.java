package course.labs.asynctasklab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.AsyncTask;

public class DownloaderTask extends AsyncTask<Object, Object, Object> {

	@Override
	protected Object doInBackground(Object... params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// TODO: Uncomment this helper method
			// Simulates downloading Twitter data from the network
	
	         private String[] downloadTweets(Integer resourceIDS[]) {
				final int simulatedDelay = 2000;
				String[] feeds = new String[resourceIDS.length];
				try {
					for (int idx = 0; idx < resourceIDS.length; idx++) {
						InputStream inputStream;
						BufferedReader in;
						try {
							// Pretend downloading takes a long time
							Thread.sleep(simulatedDelay);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						inputStream = mContext.getResources().openRawResource(
								resourceIDS[idx]);
						in = new BufferedReader(new InputStreamReader(inputStream));

						String readLine;
						StringBuffer buf = new StringBuffer();

						while ((readLine = in.readLine()) != null) {
							buf.append(readLine);
						}

						feeds[idx] = buf.toString();

						if (null != in) {
							in.close();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				return feeds;
			}

}
