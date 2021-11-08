package com.example.demo;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import com.example.demo.async.SocketConnection;

/**
 * Stand alone WebSocketStompClient.
 *
 */
public class StompClient {

//	********************* LOCAL *********************
//	private static String URL = "ws://localhost:8083/pibank-websocket"; //OK
//	private static String URL = "ws://192.168.1.131:9099/api/websocket/1.0.0"; 
//	private static String URL = "ws://127.0.0.1:9099/api/websocket/1.0.0/pibank-websocket";

//	********************* DES *********************
//	private static String URL = "ws://websocketdes.pibank.es/pibank-websocket"; //OK
//	private static String URL = "ws://192.168.128.40/pibankwebsocket/1.0.0/pibank-websocket"; 
//	private static String URL = "ws://192.168.128.45/pibankwebsocket/1.0.0/pibank-websocket"; 
//	private static String URL = "ws://apides.pibank.es/pibankwebsocket/1.0.0/pibank-websocket";

//	********************* TEST *********************	
//	private static String URL = "ws://127.0.0.1:9099/pibankwebsocket/1.0.0";
//	private static String URL = "ws://apitest.pibank.es:9099/pibank-websocket/1.0.0";
//	private static String URL = "ws://websockettest.pibank.es/pibank-websocket";

//	********************* PRO *********************	
//	private static String URL = "ws://api.pibank.es:9100/pibankwebsocket/1.0.0";
//	private static String token = "Bearer 3ebb2927-d9c4-3902-80cb-1be96a95d5ed";
//	private static String URL = "wss://websocket.pibank.es:443/pibank-websocket";

//	********************* WSO2 LOCAL *********************	

//	private static String URL = "ws://localhost:9099/pibankwebsockettest/1.0.0"; //es mi local
//	private static String token = "Bearer e6e74cef-5df7-3a75-9c17-abedaa3116cb";

	public void connectClientSocket(String URL, WebSocketHttpHeaders headHeader, StompHeaders connectHeaders,
			StompSessionHandler sessionHandler) {
		WebSocketClient client = new StandardWebSocketClient();
		WebSocketStompClient stompClient = new WebSocketStompClient(client);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());

//		Activar para HEART BEAT
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.afterPropertiesSet();
		stompClient.setTaskScheduler(taskScheduler);

		ListenableFuture<StompSession> future = stompClient.connect(URL, headHeader, connectHeaders, sessionHandler);
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {

//		String URL = "ws://localhost:8083/pibank-websocket";

//		String URL = "ws://localhost:9099/pibankwebsocket/1.0.0";
//		String URL = "ws://apitest.pibank.es:9099/pibankwebsocket/1.0.0";
//		String URL = "wss://api.pibank.es:9100/pibankwebsocket/1.0.0"; 
//		String URL = "ws://apibeta.pibank.es:9100/pibankwebsocket/beta/1.0.0"; 

		String token = "Bearer 584e6a20-b318-3572-8c53-eae4e4bcc06b";
//		String URL = "wss://socketdes.pibank.es/pibank-websocket";
//		String URL = "wss://sockettest.pibank.es/pibank-websocket";
		String URL = "wss://socketbeta.pibank.es/pibank-websocket";
//		String URL = "wss://socketprod.pibank.es/pibank-websocket";
//		String URL = "wss://socket.pibank.es/pibank-websocket";

		System.out.println("Parameters: \n ");
		if (args.length > 0) {
			URL = args[0];
			token = args[1];

			System.out.println("URL " + URL);
			System.out.println("token " + token);
		}

		SocketConnection con = new SocketConnection();

		// client 1
		StompClient client1 = new StompClient();

		WebSocketHttpHeaders headHeader = new WebSocketHttpHeaders();
//		headHeader.add("Authorization", token);

		StompHeaders connectHeaders = new StompHeaders();
		connectHeaders.add("Authorization", token);

		StompSessionHandler sessionHandler = new MyStompSessionHandler();
		client1.connectClientSocket(URL, headHeader, connectHeaders, sessionHandler);
		con = new SocketConnection();
		con.conectToSocket(token, URL);

		new Scanner(System.in).nextLine();

	}
}