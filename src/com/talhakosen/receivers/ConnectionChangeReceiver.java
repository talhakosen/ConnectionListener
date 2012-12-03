package com.talhakosen.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.talhakosen.classes.ConnectionData;
import com.talhakosen.classes.ConnectionType;

public class ConnectionChangeReceiver extends BroadcastReceiver {
	public void onReceive(Context context, Intent intent) {
		ConnectionData connectionData = ConnectionData.getInstance();

		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
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
