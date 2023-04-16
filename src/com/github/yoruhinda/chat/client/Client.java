package com.github.yoruhinda.chat.client;

import com.github.yoruhinda.chat.view.ChatFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.Socket;

public class Client implements WindowListener {
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private ChatFrame chatFrame;
    private Socket client;

    public Client(String host, int port) {
        startClient(host, port);
    }

    public void startClient(String host, int port) {
        try {
            client = new Socket(host, port);
            bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            chatFrame = new ChatFrame(bufferedReader, bufferedWriter, "Client");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        chatFrame.dispose();
        try {
            client.close();
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
