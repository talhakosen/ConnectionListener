package com.talhakosen.classes;
 
public enum ConnectionType {
	Wireless(0), Rooming(1),NoConnection(1);

	 private int code;

	 private  ConnectionType(int c) {
	   code = c;
	 }

	 public int getCode() {
	   return code;
	 }
}
