package com.ruoyi.web.webSocket;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 定义websocket服务端点
 */
@ServerEndpoint("/ws/{name}")
@Service
@Data
public class WebSocketServiceImpl {
    // 记录当前在线连接数量
    private static int onlineCount = 0;

    /**
     * 静态变量，用来记录和客户端建立的连接对象
     */
    private static CopyOnWriteArraySet<WebSocketServiceImpl> webSocketSet =
            new CopyOnWriteArraySet<>();
    /**
     * 非静态变量，每一个客户连接，都会有一个会话对象
     */
    private Session session;

    /**
     * 和客户端建立连接成功时，会调用的方法
     *
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("name") String name, Session session) {
        this.session = session;
        System.out.println(name);
        for (WebSocketServiceImpl webSocketService : webSocketSet) {
            try {
                webSocketService.session.getBasicRemote().sendText(name + "进入聊天室！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        webSocketSet.add(this); // this就是当前WebSocketServiceImpl对象
        addOnlineCount();
        System.out.println("有新的连接加入！当前连接数量" + onlineCount);
        // TODO: 发送给自己，确认自己上线了
        try {
            sendMessage("当前聊天室人数：" + onlineCount + "人");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static synchronized void addOnlineCount() {
        WebSocketServiceImpl.onlineCount++;
    }

    /**
     * 服务器主动给当前用户发送信息
     *
     * @param message
     * @throws Exception
     */
    private void sendMessage(String message) throws Exception {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 客户端和服务器挂断连接
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("关闭了连接！当前连接数量" + onlineCount);
    }

    private static synchronized void subOnlineCount() {
        WebSocketServiceImpl.onlineCount--;
    }

    /**
     * 服务器收到客户端发的消息之后的动作
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息：" + message);
        for (WebSocketServiceImpl item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


}
