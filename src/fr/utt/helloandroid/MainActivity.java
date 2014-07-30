package fr.utt.helloandroid;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
public class MainActivity extends Activity {

	private static final String[] strVille = { "Paris", "Bordeaux", "Lyon" };
	private Spinner spinner;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		spinner = (Spinner) findViewById(R.id.spinnerWeather);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strVille);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setVisibility(View.VISIBLE);
		spinner.setSelection(0);
		
		Button buttonconfirm = (Button) findViewById(R.id.buttonconfirm);
		buttonconfirm
				.setOnClickListener((OnClickListener) new buttoncomfirmListener());
		buttonconfirm.callOnClick();

	}

	class buttoncomfirmListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			StringBuffer url = new StringBuffer(
					"http://api.openweathermap.org/data/2.5/weather?q=");
			url = url.append(spinner.getSelectedItem().toString());
			url.append(",fr");
			
			// use asyncTask to load weather infomation
			RetrieveFeedTask rft = new RetrieveFeedTask(getActivity());
			rft.execute(url.toString());
		}
	}
	public Activity getActivity(){
		return this;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
