/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Property;

import House.HouseType.Bungalow;
import House.HouseType.Duplex;
import House.HouseType.TownHouse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */


public class Subdivision {
    private static Subdivision instance;
    private ArrayList<Property> properties = new ArrayList<>(); 

    private Subdivision() {
        loadData(); 
    }

    public static Subdivision getInstance() {
        if (instance == null) {
            instance = new Subdivision();
        }
        return instance;
    }

    private void loadData() {
        Block[] blockList = {
            new Block(1),
            new Block(2),
            new Block(3),
            new Block(4),
            new Block(5)
        };
        properties.add(new Property(1, new Lot(1, blockList[0]), 150.00, 1000000, new Bungalow(2, 1, false, false), 1));
        properties.add(new Property(2, new Lot(2, blockList[0]), 160.50, 1100000, new Duplex(3, 2, true, false), 1));
        properties.add(new Property(3, new Lot(3, blockList[0]), 175.75, 1200000, new TownHouse(4, 3, true, true), 1));
        properties.add(new Property(4, new Lot(4, blockList[0]), 180.00, 1300000, new Bungalow(3, 1, false, true), 1));
        properties.add(new Property(5, new Lot(5, blockList[0]), 190.25, 1400000, new Duplex(3, 2, true, false), 1));
        properties.add(new Property(6, new Lot(6, blockList[0]), 200.00, 1500000, new TownHouse(4, 3, false, true), 1));
        properties.add(new Property(7, new Lot(7, blockList[0]), 210.50, 1600000, new Bungalow(3, 1, true, false), 1));
        properties.add(new Property(8, new Lot(8, blockList[0]), 220.00, 1700000, new Duplex(3, 2, true, true), 1));
        properties.add(new Property(9, new Lot(9, blockList[0]), 230.75, 1800000, new TownHouse(4, 3, false, false), 1));
        properties.add(new Property(10, new Lot(10, blockList[0]), 240.00, 1900000, new Bungalow(3, 1, true, true), 1));
        properties.add(new Property(11, new Lot(11, blockList[0]), 250.50, 2000000, new Duplex(3, 2, false, true), 1));
        properties.add(new Property(12, new Lot(12, blockList[0]), 260.00, 2100000, new TownHouse(4, 3, true, false), 1));
        properties.add(new Property(13, new Lot(13, blockList[0]), 270.75, 2200000, new Bungalow(3, 1, false, false), 1));
        properties.add(new Property(14, new Lot(14, blockList[0]), 280.00, 2300000, new Duplex(3, 2, true, true), 1));
        properties.add(new Property(15, new Lot(15, blockList[0]), 290.50, 2400000, new TownHouse(4, 3, false, true), 1));
        properties.add(new Property(16, new Lot(16, blockList[0]), 300.00, 2500000, new Bungalow(3, 1, true, false), 1));
        properties.add(new Property(17, new Lot(17, blockList[0]), 310.75, 2600000, new Duplex(3, 2, false, false), 1));
        properties.add(new Property(18, new Lot(18, blockList[0]), 320.00, 2700000, new TownHouse(4, 3, true, true), 1));
        properties.add(new Property(19, new Lot(19, blockList[0]), 330.25, 2800000, new Bungalow(3, 1, false, true), 1));
        properties.add(new Property(20, new Lot(20, blockList[0]), 340.00, 2900000, new Duplex(3, 2, true, false), 1));

        properties.add(new Property(21, new Lot(1, blockList[1]), 150.00, 1000000, new Bungalow(2, 1, false, false), 1));
        properties.add(new Property(22, new Lot(2, blockList[1]), 160.50, 1100000, new Duplex(3, 2, true, false), 1));
        properties.add(new Property(23, new Lot(3, blockList[1]), 175.75, 1200000, new TownHouse(4, 3, true, true), 1));
        properties.add(new Property(24, new Lot(4, blockList[1]), 180.00, 1300000, new Bungalow(3, 1, false, true), 1));
        properties.add(new Property(25, new Lot(5, blockList[1]), 190.25, 1400000, new Duplex(3, 2, true, false), 1));
        properties.add(new Property(26, new Lot(6, blockList[1]), 200.00, 1500000, new TownHouse(4, 3, false, true), 1));
        properties.add(new Property(27, new Lot(7, blockList[1]), 210.50, 1600000, new Bungalow(3, 1, true, false), 1));
        properties.add(new Property(28, new Lot(8, blockList[1]), 220.00, 1700000, new Duplex(3, 2, true, true), 1));
        properties.add(new Property(29, new Lot(9, blockList[1]), 230.75, 1800000, new TownHouse(4, 3, false, false), 1));
        properties.add(new Property(30, new Lot(10, blockList[1]), 240.00, 1900000, new Bungalow(3, 1, true, true), 1));
        properties.add(new Property(31, new Lot(11, blockList[1]), 250.50, 2000000, new Duplex(3, 2, false, true), 1));
        properties.add(new Property(32, new Lot(12, blockList[1]), 260.00, 2100000, new TownHouse(4, 3, true, false), 1));
        properties.add(new Property(33, new Lot(13, blockList[1]), 270.75, 2200000, new Bungalow(3, 1, false, false), 1));
        properties.add(new Property(34, new Lot(14, blockList[1]), 280.00, 2300000, new Duplex(3, 2, true, true), 1));
        properties.add(new Property(35, new Lot(15, blockList[1]), 290.50, 2400000, new TownHouse(4, 3, false, true), 1));
        properties.add(new Property(36, new Lot(16, blockList[1]), 300.00, 2500000, new Bungalow(3, 1, true, false), 1));
        properties.add(new Property(37, new Lot(17, blockList[1]), 310.75, 2600000, new Duplex(3, 2, false, false), 1));
        properties.add(new Property(38, new Lot(18, blockList[1]), 320.00, 2700000, new TownHouse(4, 3, true, true), 1));
        properties.add(new Property(39, new Lot(19, blockList[1]), 330.25, 2800000, new Bungalow(3, 1, false, true), 1));
        properties.add(new Property(40, new Lot(20, blockList[1]), 340.00, 2900000, new Duplex(3, 2, true, false), 1));

        properties.add(new Property(41, new Lot(1, blockList[2]), 150.00, 1000000, new Bungalow(2, 1, false, false), 1));
        properties.add(new Property(42, new Lot(2, blockList[2]), 160.50, 1100000, new Duplex(3, 2, true, false), 1));
        properties.add(new Property(43, new Lot(3, blockList[2]), 175.75, 1200000, new TownHouse(4, 3, true, true), 1));
        properties.add(new Property(44, new Lot(4, blockList[2]), 180.00, 1300000, new Bungalow(3, 1, false, true), 1));
        properties.add(new Property(45, new Lot(5, blockList[2]), 190.25, 1400000, new Duplex(3, 2, true, false), 1));
        properties.add(new Property(46, new Lot(6, blockList[2]), 200.00, 1500000, new TownHouse(4, 3, false, true), 1));
        properties.add(new Property(47, new Lot(7, blockList[2]), 210.50, 1600000, new Bungalow(3, 1, true, false), 1));
        properties.add(new Property(48, new Lot(8, blockList[2]), 220.00, 1700000, new Duplex(3, 2, true, true), 1));
        properties.add(new Property(49, new Lot(9, blockList[2]), 230.75, 1800000, new TownHouse(4, 3, false, false), 1));
        properties.add(new Property(50, new Lot(10, blockList[2]), 240.00, 1900000, new Bungalow(3, 1, true, true), 1));
        properties.add(new Property(51, new Lot(11, blockList[2]), 250.50, 2000000, new Duplex(3, 2, false, true), 1));
        properties.add(new Property(52, new Lot(12, blockList[2]), 260.00, 2100000, new TownHouse(4, 3, true, false), 1));
        properties.add(new Property(53, new Lot(13, blockList[2]), 270.75, 2200000, new Bungalow(3, 1, false, false), 1));
        properties.add(new Property(54, new Lot(14, blockList[2]), 280.00, 2300000, new Duplex(3, 2, true, true), 1));
        properties.add(new Property(55, new Lot(15, blockList[2]), 290.50, 2400000, new TownHouse(4, 3, false, true), 1));
        properties.add(new Property(56, new Lot(16, blockList[2]), 300.00, 2500000, new Bungalow(3, 1, true, false), 1));
        properties.add(new Property(57, new Lot(17, blockList[2]), 310.75, 2600000, new Duplex(3, 2, false, false), 1));
        properties.add(new Property(58, new Lot(18, blockList[2]), 320.00, 2700000, new TownHouse(4, 3, true, true), 1));
        properties.add(new Property(59, new Lot(19, blockList[2]), 330.25, 2800000, new Bungalow(3, 1, false, true), 1));
        properties.add(new Property(60, new Lot(20, blockList[2]), 340.00, 2900000, new Duplex(3, 2, true, false), 1));
        
        properties.add(new Property(61, new Lot(1, blockList[3]), 150.00, 1000000, new Bungalow(2, 1, false, false), 1));
        properties.add(new Property(62, new Lot(2, blockList[3]), 160.50, 1100000, new Duplex(3, 2, true, false), 1));
        properties.add(new Property(63, new Lot(3, blockList[3]), 175.75, 1200000, new TownHouse(4, 3, true, true), 1));
        properties.add(new Property(64, new Lot(4, blockList[3]), 180.00, 1300000, new Bungalow(3, 1, false, true), 1));
        properties.add(new Property(65, new Lot(5, blockList[3]), 190.25, 1400000, new Duplex(3, 2, true, false), 1));
        properties.add(new Property(66, new Lot(6, blockList[3]), 200.00, 1500000, new TownHouse(4, 3, false, true), 1));
        properties.add(new Property(67, new Lot(7, blockList[3]), 210.50, 1600000, new Bungalow(3, 1, true, false), 1));
        properties.add(new Property(68, new Lot(8, blockList[3]), 220.00, 1700000, new Duplex(3, 2, true, true), 1));
        properties.add(new Property(69, new Lot(9, blockList[3]), 230.75, 1800000, new TownHouse(4, 3, false, false), 1));
        properties.add(new Property(70, new Lot(10, blockList[3]), 240.00, 1900000, new Bungalow(3, 1, true, true), 1));
        properties.add(new Property(71, new Lot(11, blockList[3]), 250.50, 2000000, new Duplex(3, 2, false, true), 1));
        properties.add(new Property(72, new Lot(12, blockList[3]), 260.00, 2100000, new TownHouse(4, 3, true, false), 1));
        properties.add(new Property(73, new Lot(13, blockList[3]), 270.75, 2200000, new Bungalow(3, 1, false, false), 1));
        properties.add(new Property(74, new Lot(14, blockList[3]), 280.00, 2300000, new Duplex(3, 2, true, true), 1));
        properties.add(new Property(75, new Lot(15, blockList[3]), 290.50, 2400000, new TownHouse(4, 3, false, true), 1));
        properties.add(new Property(76, new Lot(16, blockList[3]), 300.00, 2500000, new Bungalow(3, 1, true, false), 1));
        properties.add(new Property(77, new Lot(17, blockList[3]), 310.75, 2600000, new Duplex(3, 2, false, false), 1));
        properties.add(new Property(78, new Lot(18, blockList[3]), 320.00, 2700000, new TownHouse(4, 3, true, true), 1));
        properties.add(new Property(79, new Lot(19, blockList[3]), 330.25, 2800000, new Bungalow(3, 1, false, true), 1));
        properties.add(new Property(80, new Lot(20, blockList[3]), 340.00, 2900000, new Duplex(3, 2, true, false), 1));

        properties.add(new Property(81, new Lot(1, blockList[4]), 150.00, 1000000, new Bungalow(2, 1, false, false), 1));
        properties.add(new Property(82, new Lot(2, blockList[4]), 160.50, 1100000, new Duplex(3, 2, true, false), 1));
        properties.add(new Property(83, new Lot(3, blockList[4]), 175.75, 1200000, new TownHouse(4, 3, true, true), 1));
        properties.add(new Property(84, new Lot(4, blockList[4]), 180.00, 1300000, new Bungalow(3, 1, false, true), 1));
        properties.add(new Property(85, new Lot(5, blockList[4]), 190.25, 1400000, new Duplex(3, 2, true, false), 1));
        properties.add(new Property(86, new Lot(6, blockList[4]), 200.00, 1500000, new TownHouse(4, 3, false, true), 1));
        properties.add(new Property(87, new Lot(7, blockList[4]), 210.50, 1600000, new Bungalow(3, 1, true, false), 1));
        properties.add(new Property(88, new Lot(8, blockList[4]), 220.00, 1700000, new Duplex(3, 2, true, true), 1));
        properties.add(new Property(89, new Lot(9, blockList[4]), 230.75, 1800000, new TownHouse(4, 3, false, false), 1));
        properties.add(new Property(90, new Lot(10, blockList[4]), 240.00, 1900000, new Bungalow(3, 1, true, true), 1));
        properties.add(new Property(91, new Lot(11, blockList[4]), 250.50, 2000000, new Duplex(3, 2, false, true), 1));
        properties.add(new Property(92, new Lot(12, blockList[4]), 260.00, 2100000, new TownHouse(4, 3, true, false), 1));
        properties.add(new Property(93, new Lot(13, blockList[4]), 270.75, 2200000, new Bungalow(3, 1, false, false), 1));
        properties.add(new Property(94, new Lot(14, blockList[4]), 280.00, 2300000, new Duplex(3, 2, true, true), 1));
        properties.add(new Property(95, new Lot(15, blockList[4]), 290.50, 2400000, new TownHouse(4, 3, false, true), 1));
        properties.add(new Property(96, new Lot(16, blockList[4]), 300.00, 2500000, new Bungalow(3, 1, true, false), 1));
        properties.add(new Property(97, new Lot(17, blockList[4]), 310.75, 2600000, new Duplex(3, 2, false, false), 1));
        properties.add(new Property(98, new Lot(18, blockList[4]), 320.00, 2700000, new TownHouse(4, 3, true, true), 1));
        properties.add(new Property(99, new Lot(19, blockList[4]), 330.25, 2800000, new Bungalow(3, 1, false, true), 1));
        properties.add(new Property(100, new Lot(20, blockList[4]), 340.00, 2900000, new Duplex(3, 2, true, false), 1));


    }

    public Object[][] getTableData() {
        Object[][] data = new Object[properties.size()][7];
        for (int i = 0; i < properties.size(); i++) {
            Property p = properties.get(i);
            data[i] = new Object[]{p.getId(), p.getBlockNumber(), p.getLotNumber(), p.getType(), String.format("%.2f", p.getSize()), String.format("%.2f", p.getPrice()), p.getAvailability()};
        }
        return data;
    }

    public Object[][] getFilteredTableData(Integer block, Integer lot, String type, Double minSize, Double minPrice) {
        ArrayList<Object[]> filteredList = new ArrayList<>();

        for (Property p : properties) {
            boolean matchesBlock = (block == null || p.getBlockNumber() == block);
            boolean matchesLot = (lot == null || p.getLotNumber() == lot);
            boolean matchesType = (type == null || p.getType().equalsIgnoreCase(type));
            boolean matchesSize = (minSize == null || p.getSize() >= minSize);
            boolean matchesPrice = (minPrice == null || p.getPrice() >= minPrice);

            if (matchesBlock && matchesLot && matchesType && matchesSize && matchesPrice) {
                filteredList.add(new Object[]{
                    p.getId(),
                    p.getBlockNumber(),
                    p.getLotNumber(),
                    p.getType(),
                    String.format("%.2f", p.getSize()),
                    String.format("%.2f", p.getPrice()),
                    p.getAvailability()
                });
            }
        }

        return filteredList.toArray(new Object[0][7]);
    }

}





