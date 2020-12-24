package ru.geekbrains;

import java.util.ArrayList;
import java.util.List;

public class AuthService {
    List<Client> clients = new ArrayList();

    AuthService() {
        clients.add(new  Client("Petr", "petr1", "1111"));
        clients.add(new  Client("Oleg", "superOleg", "2222"));
        clients.add(new  Client("Ivan", "vano", "3333"));
    }

   synchronized Client auth(String login, String password) {
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            if (client.login.equals(login) && client.password.equals(password)) return client;
        } return null;
    }
}
