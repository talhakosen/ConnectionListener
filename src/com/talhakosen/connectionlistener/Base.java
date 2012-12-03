package com.talhakosen.connectionlistener;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.talhakosen.classes.ConnectionData;
import com.talhakosen.classes.ConnectionType;
import com.talhakosen.classes.DisplayElement;
import com.talhakosen.classes.Observer;

public abstract class Base extends Activity implements Observer, DisplayElement {
	public ConnectionType connectionType;
	private ConnectionData connectionData = ConnectionData.getInstance();
	private View view;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		connectionData.registerObserver(this);
	}


	public void update(ConnectionType connectionType) {
		this.connectionType = connectionType;
		display();
	}

}
