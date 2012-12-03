package com.talhakosen.classes;

import java.util.ArrayList;

public class ConnectionData implements Subject {
	private static ConnectionData uniqueConnectionData;
	private ArrayList observers;
	private ConnectionType connectionType;

	private ConnectionData() {
		observers = new ArrayList();
	}

	public static synchronized ConnectionData getInstance() {
		if (uniqueConnectionData == null) {
			uniqueConnectionData = new ConnectionData();
		}
		return uniqueConnectionData;
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}

	}

	public void notifyObserver() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(connectionType);
		}
	}

	public void connectionChanged() {
		notifyObserver();
	}

	public void setConnection(ConnectionType connectionType) {
		this.connectionType = connectionType;
		connectionChanged();
	}
}
