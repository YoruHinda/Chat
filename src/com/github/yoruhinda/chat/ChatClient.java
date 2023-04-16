package com.github.yoruhinda.chat;

import com.github.yoruhinda.chat.client.Client;

public class ChatClient {
    public static void main(String[] args) {
        new Client("127.0.0.1", 8080);
    }
}
