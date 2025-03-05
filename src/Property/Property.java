/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Property;

import House.House;


/**
 *
 * @author Alex
 */
public class Property {
    private int id;
    private Lot lot;
    private double size;
    private double price;
    private House type;
    private int status;

    public Property(int id, Lot lot, double size, double price, House type, int status) {
        this.id = id;
        this.lot = lot;
        this.size = size;
        this.price = price;
        this.type = type;
        this.status = status;
    }
    
    public int getId() { 
        return id; 
    }
    
    public int getLotNumber() { 
        return lot.getLotNumber(); 
    }
    
    public int getBlockNumber() { 
        return lot.getBlock().getBlockNumber(); 
    }
    
    public double getSize() { 
        return size; 
    }
    
    public double getPrice() { 
        return price; 
    }
    
    public String getType() { 
        return type.getTypeName(); 
    }
    
    public String getAvailability() { 
        if (status == 1)
            return "Available";
        else if (status == 2)
            return "Sold";
        else if (status == 3)
            return "Reserved";
        
        return " ";
    }
    
}
