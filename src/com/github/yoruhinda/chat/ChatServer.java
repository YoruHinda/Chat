package com.github.yoruhinda.chat;

import com.github.yoruhinda.chat.server.Server;

public class ChatServer {
    public static void main(String[] args) {
        new Server(8080);
    }
}
