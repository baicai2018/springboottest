package com.nondo.springboot.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketServer extends TextWebSocketHandler{

    private static final Map<WebSocketSession,String> connections = new ConcurrentHashMap<>();

    private static String getDateTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 建立连接
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String uri = session.getUri().toString();
        String userName = uri.substring(uri.lastIndexOf("/")+1);

        String nickName = URLDecoder.decode(userName,"UTF-8");

        connections.put(session,nickName);
        String message = String.format("**** %s %s",nickName,"加入聊天室");
        broadcast(new TextMessage(message));
    }

    /**
     * 断开连接
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String nickName = connections.remove(session);
        String message = String.format("**** %s %s",nickName,"退出聊天！");
        broadcast(new TextMessage(message));
    }

    /**
     * 处理消息
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String msg = "【"+connections.get(session)+"】"+getDateTime(new Date())+":"+message.getPayload();
        broadcast(new TextMessage(msg));
    }

    /**
     * 广播形式发送消息
     *
     * @param msg
     */
    public static void broadcast(TextMessage msg) {
        for (WebSocketSession session : connections.keySet()) {
            try {
                synchronized (session) {
                    session.sendMessage(msg);
                }
            } catch (Exception e) {
                connections.remove(session);
                try {
                    session.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                String message = String.format("* %s %s", connections.get(session), "断开连接");
                broadcast(new TextMessage(message));
            }
        }
    }
}
