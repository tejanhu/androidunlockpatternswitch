package com.buzzz.localePatternLockSwitch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class TestMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	      setContentView(R.layout.main);

	    //get toggle button to set the listener
		final ToggleButton toggleButton = (ToggleButton) this.findViewById(R.id.tbtnSetLock);
		toggleButton.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener(){
			//button toggled
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				
				try{
					//set the system settings
					if(isChecked){
						android.provider.Settings.System.putInt(getContentResolver(), android.provider.Settings.System.LOCK_PATTERN_ENABLED, 1);
					}
					else{
						android.provider.Settings.System.putInt(getContentResolver(), android.provider.Settings.System.LOCK_PATTERN_ENABLED, 0);
					}
				}
				catch(Exception e){
					int i = 3;
					i++;
				}
				}
		});
		super.onCreate(savedInstanceState);
	}
}
