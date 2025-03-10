/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subdivision;

import Client.Client;
import House.HouseType.Bungalow;
import House.HouseType.Duplex;
import House.HouseType.TownHouse;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */


public class Subdivision {
    private static Subdivision instance;
    private ArrayList<Block> blocks;
    
   
    private Subdivision() {
        blocks = new ArrayList<>();
        
        Block block1 = new Block(1);
        Block block2 = new Block(2);
        Block block3 = new Block(3);
        Block block4 = new Block(4);
        Block block5 = new Block(5);
        
        block1.addLot(new Lot(1, 160.00, 1050000, new Duplex(true, false), 1));
        block1.addLot(new Lot(2, 170.50, 1150000, new TownHouse(false, true), 1));
        block1.addLot(new Lot(3, 180.75, 1200000, new Bungalow(true, false), 1));
        block1.addLot(new Lot(4, 155.25, 1020000, new Duplex(false, true), 1));
        block1.addLot(new Lot(5, 190.00, 1250000, new Bungalow(false, false), 1));
        block1.addLot(new Lot(6, 200.00, 1300000, new TownHouse(true, true), 1));
        block1.addLot(new Lot(7, 175.50, 1180000, new Bungalow(true, true), 1));
        block1.addLot(new Lot(8, 160.75, 1060000, new Duplex(false, false), 1));
        block1.addLot(new Lot(9, 185.25, 1225000, new TownHouse(true, false), 1));
        block1.addLot(new Lot(10, 195.50, 1280000, new Bungalow(false, true), 1));
        block1.addLot(new Lot(11, 205.00, 1350000, new Duplex(true, false), 1));
        block1.addLot(new Lot(12, 210.25, 1400000, new TownHouse(false, false), 1));
        block1.addLot(new Lot(13, 220.00, 1500000, new Duplex(false, true), 1));
        block1.addLot(new Lot(14, 165.50, 1100000, new TownHouse(true, false), 1));
        block1.addLot(new Lot(15, 180.00, 1175000, new Bungalow(true, false), 1));
        block1.addLot(new Lot(16, 198.75, 1325000, new Duplex(false, true), 1));
        block1.addLot(new Lot(17, 210.75, 1450000, new TownHouse(true, true), 1));
        block1.addLot(new Lot(18, 170.25, 1120000, new Bungalow(false, false), 1));
        block1.addLot(new Lot(19, 190.50, 1265000, new Duplex(true, false), 1));
        block1.addLot(new Lot(20, 175.75, 1185000, new TownHouse(false, true), 1));
        
        block2.addLot(new Lot(1, 170.00, 1080000, new TownHouse(false, true), 1));
        block2.addLot(new Lot(2, 190.50, 1250000, new Duplex(true, false), 1));
        block2.addLot(new Lot(3, 180.75, 1200000, new Bungalow(true, false), 1));
        block2.addLot(new Lot(4, 155.25, 1020000, new Duplex(false, true), 1));
        block2.addLot(new Lot(5, 200.00, 1300000, new Bungalow(false, false), 1));
        block2.addLot(new Lot(6, 210.50, 1380000, new TownHouse(true, true), 1));
        block2.addLot(new Lot(7, 175.50, 1150000, new Bungalow(true, true), 1));
        block2.addLot(new Lot(8, 165.75, 1065000, new Duplex(false, false), 1));
        block2.addLot(new Lot(9, 185.25, 1225000, new TownHouse(true, false), 1));
        block2.addLot(new Lot(10, 195.50, 1280000, new Bungalow(false, true), 1));
        block2.addLot(new Lot(11, 215.00, 1400000, new Duplex(true, false), 1));
        block2.addLot(new Lot(12, 220.25, 1450000, new TownHouse(false, false), 1));
        block2.addLot(new Lot(13, 230.00, 1550000, new Duplex(false, true), 1));
        block2.addLot(new Lot(14, 168.50, 1105000, new TownHouse(true, false), 1));
        block2.addLot(new Lot(15, 183.00, 1175000, new Bungalow(true, false), 1));
        block2.addLot(new Lot(16, 195.75, 1325000, new Duplex(false, true), 1));
        block2.addLot(new Lot(17, 210.75, 1450000, new TownHouse(true, true), 1));
        block2.addLot(new Lot(18, 172.25, 1125000, new Bungalow(false, false), 1));
        block2.addLot(new Lot(19, 192.50, 1270000, new Duplex(true, false), 1));
        block2.addLot(new Lot(20, 178.75, 1195000, new TownHouse(false, true), 1));
        
        block3.addLot(new Lot(1, 160.50, 1050000, new Duplex(false, true), 1));
        block3.addLot(new Lot(2, 175.75, 1125000, new TownHouse(true, false), 1));
        block3.addLot(new Lot(3, 180.00, 1200000, new Bungalow(false, false), 1));
        block3.addLot(new Lot(4, 190.50, 1280000, new TownHouse(false, true), 1));
        block3.addLot(new Lot(5, 210.00, 1400000, new Duplex(true, false), 1));
        block3.addLot(new Lot(6, 165.25, 1075000, new Bungalow(true, true), 1));
        block3.addLot(new Lot(7, 200.75, 1325000, new Duplex(false, true), 1));
        block3.addLot(new Lot(8, 220.50, 1500000, new TownHouse(true, false), 1));
        block3.addLot(new Lot(9, 155.00, 1020000, new Bungalow(false, false), 1));
        block3.addLot(new Lot(10, 198.25, 1295000, new Duplex(true, true), 1));
        block3.addLot(new Lot(11, 185.50, 1230000, new TownHouse(false, false), 1));
        block3.addLot(new Lot(12, 210.75, 1380000, new Bungalow(true, false), 1));
        block3.addLot(new Lot(13, 230.00, 1550000, new Duplex(false, true), 1));
        block3.addLot(new Lot(14, 195.00, 1275000, new TownHouse(true, true), 1));
        block3.addLot(new Lot(15, 170.75, 1150000, new Bungalow(false, false), 1));
        block3.addLot(new Lot(16, 215.25, 1455000, new Duplex(true, false), 1));
        block3.addLot(new Lot(17, 178.50, 1180000, new TownHouse(false, true), 1));
        block3.addLot(new Lot(18, 192.75, 1265000, new Bungalow(true, false), 1));
        block3.addLot(new Lot(19, 205.50, 1350000, new Duplex(false, false), 1));
        block3.addLot(new Lot(20, 185.25, 1225000, new TownHouse(true, true), 1));
        
        block4.addLot(new Lot(1, 155.25, 1030000, new TownHouse(true, false), 1));
        block4.addLot(new Lot(2, 180.50, 1205000, new Duplex(false, true), 1));
        block4.addLot(new Lot(3, 170.75, 1150000, new Bungalow(false, false), 1));
        block4.addLot(new Lot(4, 195.00, 1275000, new TownHouse(false, true), 1));
        block4.addLot(new Lot(5, 210.25, 1400000, new Duplex(true, false), 1));
        block4.addLot(new Lot(6, 165.00, 1070000, new Bungalow(false, false), 1));
        block4.addLot(new Lot(7, 205.75, 1355000, new Duplex(false, true), 1));
        block4.addLot(new Lot(8, 225.00, 1525000, new TownHouse(true, true), 1));
        block4.addLot(new Lot(9, 160.50, 1050000, new Bungalow(true, false), 1));
        block4.addLot(new Lot(10, 200.50, 1320000, new Duplex(false, true), 1));
        block4.addLot(new Lot(11, 190.75, 1255000, new TownHouse(false, false), 1));
        block4.addLot(new Lot(12, 215.50, 1450000, new Bungalow(true, true), 1));
        block4.addLot(new Lot(13, 235.25, 1575000, new Duplex(false, true), 1));
        block4.addLot(new Lot(14, 185.00, 1225000, new TownHouse(true, false), 1));
        block4.addLot(new Lot(15, 175.25, 1180000, new Bungalow(false, false), 1));
        block4.addLot(new Lot(16, 220.75, 1485000, new Duplex(true, false), 1));
        block4.addLot(new Lot(17, 182.00, 1210000, new TownHouse(false, true), 1));
        block4.addLot(new Lot(18, 198.25, 1295000, new Bungalow(true, false), 1));
        block4.addLot(new Lot(19, 210.00, 1380000, new Duplex(false, false), 1));
        block4.addLot(new Lot(20, 195.75, 1265000, new TownHouse(true, true), 1));
        
        block5.addLot(new Lot(1, 160.00, 1050000, new Duplex(false, true), 1));
        block5.addLot(new Lot(2, 175.50, 1125000, new Bungalow(false, false), 1));
        block5.addLot(new Lot(3, 200.25, 1300000, new TownHouse(true, false), 1));
        block5.addLot(new Lot(4, 190.00, 1220000, new Duplex(false, true), 1));
        block5.addLot(new Lot(5, 185.75, 1185000, new Bungalow(true, false), 1));
        block5.addLot(new Lot(6, 215.00, 1400000, new TownHouse(false, true), 1));
        block5.addLot(new Lot(7, 165.50, 1080000, new Duplex(true, false), 1));
        block5.addLot(new Lot(8, 225.75, 1485000, new Bungalow(false, false), 1));
        block5.addLot(new Lot(9, 195.50, 1260000, new TownHouse(false, true), 1));
        block5.addLot(new Lot(10, 205.00, 1325000, new Duplex(true, false), 1));
        block5.addLot(new Lot(11, 182.75, 1200000, new Bungalow(true, true), 1));
        block5.addLot(new Lot(12, 210.50, 1365000, new TownHouse(false, false), 1));
        block5.addLot(new Lot(13, 230.25, 1550000, new Duplex(false, true), 1));
        block5.addLot(new Lot(14, 175.00, 1130000, new Bungalow(false, false), 1));
        block5.addLot(new Lot(15, 220.50, 1465000, new TownHouse(true, false), 1));
        block5.addLot(new Lot(16, 198.75, 1280000, new Duplex(false, true), 1));
        block5.addLot(new Lot(17, 185.50, 1195000, new Bungalow(true, false), 1));
        block5.addLot(new Lot(18, 215.25, 1425000, new TownHouse(false, true), 1));
        block5.addLot(new Lot(19, 190.75, 1245000, new Duplex(true, false), 1));
        block5.addLot(new Lot(20, 200.50, 1315000, new Bungalow(false, false), 1));
        
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(block4);
        blocks.add(block5);
        
        
        Client alex = Client.createClient("Alex", "09123456789", "alex123@gmail.com", false);
        Client marcus = Client.createClient("Marcus", "09946183611", "marcus@gmail.com", false);
        Client ryan = Client.createClient("Ryan", "09126326789", "ryan@gmail.com", false);
        Client jomar = Client.createClient("Jomar", "09126326782", "jomar@gmail.com", false);
        Client ed = Client.createClient("Ed", "09126236782", "ed@gmail.com", false);
        Client josh = Client.createClient("Josh", "09546236782", "bjosh@gmail.com", false);
        Client neil = Client.createClient("Neil", "09546237782", "neil@gmail.com", false);
        
        alex.addLot(block1.getLotByNumber(2), 2);
        alex.addLot(block1.getLotByNumber(3), 2);
        alex.addLot(block2.getLotByNumber(6), 2);
        marcus.addLot(block1.getLotByNumber(5), 3);
        ryan.addLot(block2.getLotByNumber(6), 2);
        jomar.addLot(block3.getLotByNumber(7), 2);
        ed.addLot(block5.getLotByNumber(20), 3);
        josh.addLot(block3.getLotByNumber(10), 2);
        neil.addLot(block4.getLotByNumber(17), 3);
        neil.addLot(block4.getLotByNumber(15), 2);
        
        Sales.addSales(alex, block1.getLotByNumber(2));
        Sales.addSales(alex, block1.getLotByNumber(3));
        Sales.addSales(alex, block2.getLotByNumber(6));
        Sales.addSales(marcus, block1.getLotByNumber(5));
        Sales.addSales(ryan, block2.getLotByNumber(6));
        Sales.addSales(jomar, block3.getLotByNumber(7));
        Sales.addSales(ed, block5.getLotByNumber(20));
        Sales.addSales(josh, block3.getLotByNumber(10));
        Sales.addSales(neil, block4.getLotByNumber(17));
        Sales.addSales(neil, block4.getLotByNumber(15));

    }

    public static Subdivision getInstance() {
        if (instance == null) {
            instance = new Subdivision();
        }
        return instance;
    }
    
    public Client getLotOwnerById(int id) {
        for (Block block : blocks) {
            for (Lot lot  : block.getLots()) {
                if (lot.getId() == id) {
                    return lot.getClient();
                }
            }
        }
        return null;
    }

    public void setLotAvailabilityById(int id, int status, Client client, String option) {
        for (Block block : blocks) {
            for (Lot lot  : block.getLots()) {
                if (lot.getId() == id) {
                    //lot.setStatus(status);
                    if (option == "add")
                        client.addLot(lot, status);
                    else if (option == "remove")
                        client.removeLot(lot);
                }
            }
        }
    }
    
    public void removeSalesById(int clientId, int lotId) {
        Lot lot = null;
        Client client = null;
        
        for (Client c : Client.getClients()) {
            if (c.getId() == clientId) {
                client = c;
                
                if (c.getLotOwnedCount() <= 0) {
                    
                }
                
                break;
            }
        }
        
        for (Block block : blocks) {
            for (Lot l : block.getLots()) {
                if (l.getId() == lotId) {
                    lot = l;
                    break;
                }
            }
        }

        if (client != null || lot != null) {
            setLotAvailabilityById(lotId, 1, client, "remove");
            Sales.removeSales(client, lot);
        }
    }
    
    public void addSalesById(int clientId, int lotId, int status) {
        Client client = null;
        Lot lot = null;

        for (Client c : Client.getClients()) {
            if (c.getId() == clientId) {
                client = c;
                break;
            }
        }

        for (Block block : blocks) {
            for (Lot l : block.getLots()) {
                if (l.getId() == lotId) {
                    lot = l;
                    break;
                }
            }
        }

        
        if (client != null || lot != null) {
            setLotAvailabilityById(lotId, status, client, "add");
            Sales.addSales(client, lot);
        }
        
    }
    
    public Object[][] getLoggedInClientOwnedLotsData() {
        ArrayList<Object[]> dataList = new ArrayList<>();
        for (Block block : blocks) {
            for (Lot lot : block.getLots()) {
                if (lot.getClient() != null) {
                    if (lot.getClient().getId() == Client.getLoggedInClient().getId()) {
                        dataList.add(new Object[]{
                            lot.getId(),
                            block.getBlockNumber(),
                            lot.getLotNumber(),
                            lot.getType(),
                            lot.getAdditionalFeatures(),
                            String.format("%.2f", lot.getSize()),
                            String.format("%.2f", lot.getPrice()),
                            lot.getAvailability()
                        });
                    }
                }
            }
        }
        return dataList.toArray(new Object[0][7]);
    }
    
    public Object[][] getSalesTableData() {
        ArrayList<Object[]> dataList = new ArrayList<>();
        for (Sales sale: Sales.getSalesList()) {
            dataList.add(new Object[]{
                sale.getId(),
                sale.getClient().getId(),
                sale.getLot().getId(),
                sale.getLot().getAvailability()
            });
        }
        return dataList.toArray(new Object[0][3]);
    }
    
    public Object[][] getClientTableData() {
        ArrayList<Object[]> dataList = new ArrayList<>();
        for (Client client: Client.getClients()) {
            dataList.add(new Object[]{
                client.getId(),
                client.getName(),
                client.getPhoneNumber(),
                client.getEmail(),
                client.getLotOwnedCount()
            });
        }
        return dataList.toArray(new Object[0][4]);
    }
    
    public Object[][] getTableData(boolean isAdmin) {
        ArrayList<Object[]> dataList = new ArrayList<>();
        for (Block block : blocks) {
            for (Lot lot : block.getLots()) {
                if (isAdmin) {
                    dataList.add(new Object[]{
                        lot.getId(),
                        block.getBlockNumber(),
                        lot.getLotNumber(),
                        lot.getType(),
                        lot.getAdditionalFeatures(),
                        String.format("%.2f", lot.getSize()),
                        String.format("%.2f", lot.getPrice()),
                        lot.getAvailability(),
                        (lot.getClient() != null) ? lot.getClient().getName() : " "
                    });
                } else{
                    dataList.add(new Object[]{
                        lot.getId(),
                        block.getBlockNumber(),
                        lot.getLotNumber(),
                        lot.getType(),
                        lot.getAdditionalFeatures(),
                        String.format("%.2f", lot.getSize()),
                        String.format("%.2f", lot.getPrice()),
                        lot.getAvailability()
                    });
                }
            }
        }
        if (isAdmin)
            return dataList.toArray(new Object[0][8]);
        else
            return dataList.toArray(new Object[0][7]);
    }

    public Object[][] getFilteredTableData(Integer block, Integer lot, String type, Double minSize, Double minPrice, Boolean hasSwimmingPool, Boolean hasGarage, boolean isAdmin) {
        ArrayList<Object[]> filteredList = new ArrayList<>();

        for (Block b : blocks) {
            for (Lot l : b.getLots()) {
                boolean matchesBlock = (block == null || b.getBlockNumber() == block);
                boolean matchesLot = (lot == null || l.getLotNumber() == lot);
                boolean matchesType = (type == null || l.getType().equalsIgnoreCase(type));
                boolean matchesSize = (minSize == null || l.getSize() >= minSize);
                boolean matchesPrice = (minPrice == null || l.getPrice() >= minPrice);
                boolean matchesAmenities = true; 

                if (hasSwimmingPool != null || hasGarage != null) {
                    if (hasSwimmingPool == true && hasGarage == true) {
                        matchesAmenities = l.hasSwimmingPool() && l.hasGarage();
                    } else if (hasSwimmingPool == true) {
                        matchesAmenities = l.hasSwimmingPool() && !l.hasGarage();
                    } else if (hasGarage == true) {
                        matchesAmenities = l.hasGarage() && !l.hasSwimmingPool();
                    } else {
                        matchesAmenities = true;
                    }
                }
                
                if (matchesBlock && matchesLot && matchesType && matchesSize && matchesPrice && matchesAmenities) {                   
                    if (isAdmin) {
                        filteredList.add(new Object[]{
                            l.getId(),
                            b.getBlockNumber(),
                            l.getLotNumber(),
                            l.getType(),
                            l.getAdditionalFeatures(),
                            String.format("%.2f", l.getSize()),
                            String.format("%.2f", l.getPrice()),
                            l.getAvailability(),
                            (l.getClient() != null) ? l.getClient().getName() : "N/A"
                        });
                    } else{
                        filteredList.add(new Object[]{
                            l.getId(),
                            b.getBlockNumber(),
                            l.getLotNumber(),
                            l.getType(),
                            l.getAdditionalFeatures(),
                            String.format("%.2f", l.getSize()),
                            String.format("%.2f", l.getPrice()),
                            l.getAvailability()
                        });
                    }
                }
                
                
            }
        }
        if (isAdmin)
            return filteredList.toArray(new Object[0][8]);
        else
            return filteredList.toArray(new Object[0][7]);
    }
}