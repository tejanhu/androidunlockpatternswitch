package com.buzzz.localePatternLockSwitch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class FireReceiver extends BroadcastReceiver {

	/**
	 * @param context {@inheritDoc}.
	 * @param intent the incoming {@code Intent}. This should always contain the store-and-forward {@code Bundle} that was saved
	 *            by {@link EditActivity} and later broadcast by <i>Locale</i>.
	 */
	@Override
	public void onReceive(final Context context, final Intent intent)
	{
		/*
		 * Always be sure to be strict on your input parameters! A malicious third-party app could always send your plug-in an
		 * empty or otherwise malformed Intent. And since Locale applies settings in the background, you don't want your plug-in
		 * to crash.
		 */
		if (com.twofortyfouram.Intent.ACTION_FIRE_SETTING.equals(intent.getAction()))
		{
			Log.d("LockSwitch", "fire!");
			Boolean lockOn = intent.getBooleanExtra(Constants.LOCKSCREEN_SETTING, false);
			if(lockOn){
				android.provider.Settings.System.putInt(context.getContentResolver(), android.provider.Settings.System.LOCK_PATTERN_ENABLED, 1);
			}
			else {
				android.provider.Settings.System.putInt(context.getContentResolver(), android.provider.Settings.System.LOCK_PATTERN_ENABLED, 0);
			}
		}
	}
}

