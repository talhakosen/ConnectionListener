package com.talhakosen.classes;
 
public enum ConnectionType {
	Wireless(0), Mobile(1),NoConnection(1);

	 private int code;

	 private  ConnectionType(int c) {
	   code = c;
	 }

	 public int getCode() {
	   return code;
	 }
}
