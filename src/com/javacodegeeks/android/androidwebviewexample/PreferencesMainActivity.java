package com.javacodegeeks.android.androidwebviewexample;

import android.os.Bundle;
import android.app.Activity;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class PreferencesMainActivity extends Activity {

	private EditText machineId;
	private Button buttonNext;
	private Activity self = this;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preferences_main);
		
		View li = findViewById(R.id.layout);
		li.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				InputMethodManager imm = 
						(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(self.getCurrentFocus().getWindowToken(), 0);
			}

			
		});
		
		machineId = (EditText) findViewById(R.id.editTextMachineId);
		
		// set hint
		machineId.setHint(R.string.machine_id_hint);
		
		// set the max length and no space character allow.
		InputFilter[] filterArray =new InputFilter[2];
		filterArray[0] = new InputFilter.LengthFilter(10);
		filterArray[1] = new InputFilter() {
			@Override
			public CharSequence filter(CharSequence source, int start, int end,
					Spanned dest, int dstart, int dend) {
					
					for ( int i=start ; i<end ; i++ ){
						if (!Character.isLetterOrDigit(source.charAt(i))) {
							return "";
						}
					}
				return null;
			}			
		};
		machineId.setFilters(filterArray);	
		
		buttonNext = (Button)findViewById(R.id.imageButtonMainNext);
		
		buttonNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO : going to next Preference page
				//	unimplemented
			}
		});
			
	}

	
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preferences_main, menu);
		return true;
	}
	*/
}
