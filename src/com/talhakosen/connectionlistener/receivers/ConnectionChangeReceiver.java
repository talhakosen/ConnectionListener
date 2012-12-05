package com.talhakosen.connectionlistener.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.widget.Toast;
import com.talhakosen.connectionlistener.classes.ConnectionData;
import com.talhakosen.connectionlistener.classes.ConnectionType;;

public class ConnectionChangeReceiver extends BroadcastReceiver {

		
	@Override
	public void onReceive(Context arg0, Intent arg1) {

		ConnectionData connectionData = ConnectionData.getInstance();

		ConnectivityManager connectivityManager = (ConnectivityManager) arg0.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
		NetworkInfo mobNetInfo = connectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		NetworkInfo wifiNetInfo = connectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		// update observer

		if (wifiNetInfo != null) {
			if (wifiNetInfo.isConnected())
				connectionData.setConnection(ConnectionType.Wireless);
		}

		if (mobNetInfo != null) {
			if (mobNetInfo.isConnected())
				connectionData.setConnection(ConnectionType.Mobile);
		}

		if (activeNetInfo == null) {
			connectionData.setConnection(ConnectionType.NoConnection);
		}

	}

}
