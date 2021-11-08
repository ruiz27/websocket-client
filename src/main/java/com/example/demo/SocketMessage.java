package com.example.demo;

public class SocketMessage {

	private String tipology;
	private String bodyMessage;
	public String getTipology() {
		return tipology;
	}
	public void setTipology(String tipology) {
		this.tipology = tipology;
	}
	public String getBodyMessage() {
		return bodyMessage;
	}
	public void setBodyMessage(String bodyMessage) {
		this.bodyMessage = bodyMessage;
	}
	@Override
	public String toString() {
		return "SocketMessage [tipology=" + tipology + ", bodyMessage=" + bodyMessage + "]";
	}
	
	
}
