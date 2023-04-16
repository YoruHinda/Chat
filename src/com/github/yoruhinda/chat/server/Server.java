package com.github.yoruhinda.chat.server;

import com.github.yoruhinda.chat.view.ChatFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server implements WindowListener {
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private ServerSocket server;
    private Socket client;
    private ChatFrame chatFrame;

    public Server(int port) {
        startServerWithPort(port);
    }

    public Server(String host, int port) {
        try {
            InetAddress hostInetAddress = InetAddress.getByName(host);
            startServerWithHostAndPort(hostInetAddress, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void startServerWithPort(int port) {
        try {
            server = new ServerSocket(port);
            client = server.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            chatFrame = new ChatFrame(bufferedReader, bufferedWriter, "Server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServerWithHostAndPort(InetAddress inetAddress, int port) {
        try {
            server = new ServerSocket(port, 50, inetAddress);
            client = server.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            chatFrame = new ChatFrame(bufferedReader, bufferedWriter, "Server");
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
            server.close();
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
