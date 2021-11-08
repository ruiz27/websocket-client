package com.example.demo;

import java.lang.reflect.Type;

import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

/**
 * This class is an implementation for <code>StompSessionHandlerAdapter</code>.
 * Once a connection is established, We subscribe to /topic/messages and 
 * send a sample message to server.
 * 
 * @author Kalyan
 *
 */
public class MyStompSessionHandler extends StompSessionHandlerAdapter {


    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        System.out.println("New session established : " + session.getSessionId());
        session.subscribe("/queue/pibank-user"+"25002563E", this);
//        session.subscribe("/queue/pibank-user"+"05953848E", this);
//        session.subscribe("/queue/pibank-user"+"72081557V", this);
        System.out.println("Finished suscribe method : " + session.getSessionId());
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        System.out.println("handleException : " + session.getSessionId() );

    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return SocketMessage.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
    	SocketMessage msg = (SocketMessage) payload;
        System.out.println("Received : " + msg );
    }

    /**
     * A sample message instance.
     * @return instance of <code>Message</code>
     */
    public SocketMessage getSampleMessage() {
    	SocketMessage msg = new SocketMessage();
      
        return msg;
    }
}