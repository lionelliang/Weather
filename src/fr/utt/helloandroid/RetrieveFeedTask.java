package fr.utt.helloandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class RetrieveFeedTask extends AsyncTask<String, Void, StringBuilder> {

	private Activity context;

	public RetrieveFeedTask(Activity a) {
		// TODO Auto-generated method stub
		context = a;
	}
	@Override
	protected StringBuilder doInBackground(String... urls) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL(urls[0]);
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url.toString());
			HttpResponse httpResponse;
			StringBuilder builder = new StringBuilder();
			;
			BufferedReader bufferedReader2;

			int res = 0;

			httpResponse = httpclient.execute(httpget);
			res = httpResponse.getStatusLine().getStatusCode();
			if (res == 200) {
				try {
					bufferedReader2 = new BufferedReader(new InputStreamReader(
							httpResponse.getEntity().getContent()));
					for (String s = bufferedReader2.readLine(); s != null; s = bufferedReader2
							.readLine()) {
						builder.append(s);
					}
					return builder;
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Log.i("cat", ">>>" + builder.toString());
			}

		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(StringBuilder builder) {
		// TODO Auto-generated method stub
		TextView tv1,tv4;
		ImageView iv1;
		
		tv1 = (TextView) ((context).findViewById(R.id.tvTempmin));
		tv4 = (TextView) (context.findViewById(R.id.tvTempmax));
		iv1 = (ImageView) (context.findViewById(R.id.imageView1));
		
		Gson gson = new Gson();
		Data data = gson.fromJson(builder.toString(), Data.class);

		tv1.setText(String.valueOf(data.getMain().getTemp_min()));
		tv4.setText(String.valueOf(data.getMain().getTemp_max()));

		System.out.println(data.getWeather().get(0).getIcon());
		if (iv1.getDrawable() != null) {
			((BitmapDrawable) iv1.getDrawable()).getBitmap().recycle();
		}
		iv1.setImageBitmap(decodeSampledBitmapFromResource(
				context.getResources(), getImage(data.getWeather().get(0).getIcon()), 200, 200));
	}
	
	public int getImage(String str) {
		int id = R.drawable.img50n;
		if (str.equals("01n"))
			id = R.drawable.img01n;
		if (str.equals("02n"))
			id = R.drawable.img02n;
		if (str.equals("03n"))
			id = R.drawable.img03n;
		if (str.equals("04n"))
			id = R.drawable.img04n;
		if (str.equals("09n"))
			id = R.drawable.img09n;
		if (str.equals("10n"))
			id = R.drawable.img10n;
		if (str.equals("11n"))
			id = R.drawable.img11n;
		if (str.equals("13n"))
			id = R.drawable.img13n;
		return id;
	}
	
	/**
	 * mImageView.setImageBitmap(
	 * decodeSampledBitmapFromResource(getResources(), R.id.myimage, 100, 100));
	 * 
	 * @param res
	 * @param resId
	 * @param reqWidth
	 * @param reqHeight
	 * @return
	 */
	public static Bitmap decodeSampledBitmapFromResource(Resources res,
			int resId, int reqWidth, int reqHeight) {

		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);

		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth,
				reqHeight);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);
	}

	/**
	 * get smaller scanling bitmap
	 * @param options
	 * @param reqWidth
	 * @param reqHeight
	 * @return
	 */
	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			// Calculate the largest inSampleSize value that is a power of 2 and
			// keeps both
			// height and width larger than the requested height and width.
			while ((halfHeight / inSampleSize) > reqHeight
					&& (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}

		return inSampleSize;
	}
}
