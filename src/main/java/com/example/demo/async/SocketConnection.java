package com.example.demo.async;

import java.util.concurrent.CompletableFuture;

import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.WebSocketHttpHeaders;

import com.example.demo.MyStompSessionHandler;
import com.example.demo.StompClient;

public class SocketConnection {

	public CompletableFuture<Void> conectToSocket(String token, String URL) {

		return CompletableFuture.runAsync(() -> {
			StompClient client1 = new StompClient();

			WebSocketHttpHeaders headHeader = new WebSocketHttpHeaders();
			headHeader.add("Authorization", token);

			long[] heart = {0,25000};
			StompHeaders connectHeaders = new StompHeaders();
//			Activar para HEART BEAT			
			connectHeaders.setHeartbeat(heart);
			connectHeaders.add("Authorization", token);

			StompSessionHandler sessionHandler = new MyStompSessionHandler();
			client1.connectClientSocket(URL, headHeader, connectHeaders, sessionHandler);
		});
	}

}
