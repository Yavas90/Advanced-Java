package ru.geekbrains;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {

    List<ClientHandler> clients = new ArrayList<>();
    Map<String, List<Message>> messages = new HashMap<>();

    Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            AuthServer authServer = new AuthServer();

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    new ClientHandler(authServer,this, socket);
                }).start();
            }

        } catch (IOException e) {
            System.out.println("Сервер прекратил работу!");
            e.printStackTrace();
        }
    }

    synchronized void onNewMessage(Client client, String message) {
//        messages.add(new Message(client, message));
//        for (int i = 0; i < clients.size(); i++) {
//            ClientHandler recipient = clients.get(i);
//            if (!recipient.client.login.equals(client.login)) {
//                recipient.sendMessage(client, message);
//            }
//        }

    }

    synchronized void sendMessageTo(Client sender, String recipientLogin, String text) {
        String senderLogin = sender.login;
        String key;
        if (senderLogin.compareTo(recipientLogin) > 0){
            key = senderLogin + recipientLogin;
        } else {
            key = recipientLogin + senderLogin;
        }
        if (!messages.containsKey(key)) {
            messages.put(key, new ArrayList<>());
        }
        messages.get(key).add(new Message(sender, text));
        ClientHandler recipient = null;
        for (int i = 0; i < clients.size(); i++) {
            ClientHandler client = clients.get(i);
            if (client.client.login.equals(recipientLogin)) {
                recipient = client;
            }
        }
        if (recipient != null) {
            recipient.sendMessage(sender, text);
            System.out.println("Message send for " + recipientLogin);
        } else {
            System.out.println("Recipient not found!" + recipientLogin);
        }
    }

    synchronized void onClientDisconnected (ClientHandler clientHandler) {
        clients.remove(clientHandler);
        onNewMessage(clientHandler.client, "Покинул чат");
    }

   synchronized void onNewClient(ClientHandler clientHandler) {
       clients.add(clientHandler);
//       for (int i = 0; i < messages.size(); i++) {
//           Message message = messages.get(i);
//           clientHandler.sendMessage(message.client, message.text);
//       }
       onNewMessage(clientHandler.client, "Вошел в чат!");
   }

    public static void main(String[] args) {
        new Server();
    }
}
