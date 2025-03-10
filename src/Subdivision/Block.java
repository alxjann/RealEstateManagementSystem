/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subdivision;
    
/**
 *
 * @author Alex
 */
import java.util.ArrayList;

public class Block {
    private int blockNumber;
    private ArrayList<Lot> lots;
    
    public Block(int blockNumber) {
        this.blockNumber = blockNumber;
        this.lots = new ArrayList<>();
    }

    public int getBlockNumber() {
        return blockNumber;
    }
    
    public Lot getLotByNumber(int lotNumber) {
        for (Lot lot : lots) {
            if (lot.getLotNumber() == lotNumber) {
                return lot;
            }
        }
        return null;
    }

    public void addLot(Lot lot) {
        lots.add(lot);
    }

    public ArrayList<Lot> getLots() {
        return lots;
    }

}