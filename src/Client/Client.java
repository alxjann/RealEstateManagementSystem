/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.util.ArrayList;
import Subdivision.Lot;

/**
 *
 * @author Alex
 */
public class Client {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private static Client loggedInClient;
    private int lotOwnedCount;
    private ArrayList<Lot> lotsOwned = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<>();
    
    private static int idCount = 1;
    
    private Client(String name, String phoneNumber, String email, boolean setAsLoggedIn) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id = idCount;
        idCount++;
        if (setAsLoggedIn == true) {
            loggedInClient = this;
        }
    }
    
    public void addLot(Lot lot, int status) {
        lotsOwned.add(lot);
        lotOwnedCount++;
        lot.setClient(this);
        lot.setStatus(status);
    }
    
    public void removeLot(Lot lot) {
        lotsOwned.remove(lot);
        lotOwnedCount--;
        lot.setClient(null);
        lot.setStatus(1);
    }

    public int getLotOwnedCount() {
        return lotOwnedCount;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    
    public static Client getLoggedInClient() {
        return loggedInClient;
    }
    
    public static Client createClient(String name, String phoneNumber, String email, boolean setAsLoggedIn) {
        Client client = new Client(name, phoneNumber, email, setAsLoggedIn);
        clients.add(client);
        return client;
    }
    
    public static ArrayList<Client> getClients() {
        return clients;
    }

}
