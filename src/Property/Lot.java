/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Property;

/**
 *
 * @author Alex
 */
public class Lot {
    private int lotNumber;
    private Block block;

    public Lot(int lotNumber, Block block) {
        this.lotNumber = lotNumber;
        this.block = block;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public Block getBlock() {
        return block;
    } 
}
