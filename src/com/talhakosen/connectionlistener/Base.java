package com.talhakosen.connectionlistener;

import android.app.Activity;
import android.os.Bundle;
import com.talhakosen.connectionlistener.classes.ConnectionData;
import com.talhakosen.connectionlistener.classes.ConnectionType;
import com.talhakosen.connectionlistener.classes.DisplayElement;
import com.talhakosen.connectionlistener.classes.Observer;

public abstract class Base extends Activity implements Observer, DisplayElement {
	public ConnectionType connectionType;
	private ConnectionData connectionData = ConnectionData.getInstance();
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);					
		
		connectionData.registerObserver(this);
	}


	public void update(ConnectionType connectionType) {
		this.connectionType = connectionType;
		display();
	}

}
