package com.nondo.bak;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class WebSocketServer {

    private static final Set<WebSocketServer> connections = new CopyOnWriteArraySet<>();

    private String nickName;
    private Session session;

    private static String getDateTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    @OnOpen
    public void start(@PathParam("userName") String userName, Session session) {
        this.nickName = userName;
        this.session = session;
        connections.add(this);
        String message = String.format("* %s %s", nickName, "加入聊天!");
        broadcast(message);

    }

    @OnClose
    public void end() {
        connections.remove(this);
        String message = String.format("* %s %s", nickName, "退出聊天！");
    }

    @OnMessage
    public void pushMsg(String message) {
        broadcast("【" + this.nickName + "】" + getDateTime(new Date()) + ":" + message);
    }

    @OnError
    public void onError(Throwable t)throws Throwable{

    }

    /**
     * 广播形式发送消息
     *
     * @param msg
     */
    public static void broadcast(String msg) {
        for (WebSocketServer client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                String message = String.format("* %s %s", client.nickName, "断开连接");
                broadcast(message);
            }
        }
    }
}
