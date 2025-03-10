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
    protected boolean hasSwimmingPool;
    protected boolean hasGarage;

    public House(boolean hasSwimmingPool, boolean hasGarage) {
        this.hasSwimmingPool = hasSwimmingPool;
        this.hasGarage = hasGarage;
    }
    
    public abstract String getTypeName();

    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }

    public boolean hasGarage() {
        return hasGarage;
    }
}
