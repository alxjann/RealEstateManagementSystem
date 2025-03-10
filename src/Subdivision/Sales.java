/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subdivision;

import Client.Client;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Sales {
    private Client client;
    private Lot lot;
    private int id;
    private static int idCount = 1;
    private static ArrayList<Sales> salesList = new ArrayList<>();
    
    private Sales(Client client, Lot lot) {
        this.client = client;
        this.lot = lot;
        this.id = idCount++;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Lot getLot() {
        return lot;
    }
    
    public static void addSales(Client client, Lot lot) {
        salesList.add(new Sales(client, lot));
    }
    
    public static void removeSales(Client client, Lot lot) {
        Sales saleToRemove = null;

        for (Sales sale : salesList) {
            if (sale.getClient().equals(client) && sale.getLot().equals(lot)) {
                saleToRemove = sale;
                break;
            }
        }

        if (saleToRemove != null) {
            salesList.remove(saleToRemove);
            idCount--;
        }
    }

    public static ArrayList<Sales> getSalesList() {
        return salesList;
    }

}

