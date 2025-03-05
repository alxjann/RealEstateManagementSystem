/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package House;

/**
 *
 * @author Alex
 */
public abstract class House {
    private String houseType;
    private int roomCount;
    private int floorCount;
    boolean hasSwimmingPool;
    boolean hasGarage;

    public House(String houseType, int roomCount, int floorCount, boolean hasSwimmingPool, boolean hasGarage) {
        this.houseType = houseType;
        this.roomCount = roomCount;
        this.floorCount = floorCount;
        this.hasSwimmingPool = hasSwimmingPool;
        this.hasGarage = hasGarage;
    }
    
    public String getTypeName() {
        return houseType;
    }
    
}
