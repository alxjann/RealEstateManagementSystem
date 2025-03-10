/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subdivision;

import Client.Client;
import House.House;

/**
 *
 * @author Alex
 */
public class Lot {
    private int lotNumber;
    private double size;
    private double price;
    private House house;
    private int status;
    private int id;
    private Client client = null;
    private static int idCount = 1;

    public Lot(int lotNumber, double size, double price, House house, int status) {
        this.lotNumber = lotNumber;
        this.size = size;
        this.price = price;
        this.house = house;
        this.status = status;
        this.id = idCount;
        idCount++;
    }
    
    public int getId() {
        return id;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public void setClient(Client client) {
            this.client = client; 
        }

    public Client getClient() {
        return client;
    }
  
    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return house.getTypeName();
    }
    
    public boolean hasSwimmingPool() {
        return house.hasSwimmingPool();
    }

    public boolean hasGarage() {
        return house.hasGarage();
    }
    
    public String getAdditionalFeatures() {
        String features = "";
        if (house.hasSwimmingPool() && house.hasGarage())
            features = "Swimming Pool and Garage";
        else if (house.hasSwimmingPool())
            features = "Swimming Pool";
        else if (house.hasGarage())
            features = "Garage";
        
        if (features.isEmpty()) features = "None";

        return features;
    }

    public String getAvailability() {
        if (status == 1)
            return "Available";
        else if (status == 2)
            return "Sold";
        else if (status == 3)
            return "Reserved";

        return "ERROR";
    }
}