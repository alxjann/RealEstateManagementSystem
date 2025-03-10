/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package House.HouseType;

import House.House;

/**
 *
 * @author Alex
 */
public class Bungalow extends House {

    public Bungalow(boolean hasSwimmingPool, boolean hasGarage) {
        super(hasSwimmingPool, hasGarage);
    } 

    @Override
    public String getTypeName() {
        return "Bungalow";
    }
}
