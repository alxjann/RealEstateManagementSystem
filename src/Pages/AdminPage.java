/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages;

import Subdivision.Subdivision;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class AdminPage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Subdivision subdivision = Subdivision.getInstance();

    
    public AdminPage() {
        initComponents();
        setPreferredSize(new Dimension(1056, 630)); 
        setResizable(false);
        setLocationRelativeTo(null);
        String[] columnNames = {"ID", "BLOCK", "LOT", "TYPE", "AMENITIES" , "SIZE", "PRICE", "STATUS" , "CLIENT"};

        Object[][] data = subdivision.getTableData(true);

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        
        
        
        jTable1.setModel(model);
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(130);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(245);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(100);
        salesPage();
    }
    
    private void salesPage() {
        jTable5.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && jTable5.getSelectedRow() != -1) {
                int selectedRow = jTable5.getSelectedRow();
                salesClientId.setText(jTable5.getValueAt(selectedRow, 0).toString());
            }
        });
        
        jTable6.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && jTable6.getSelectedRow() != -1) {
                int selectedRow = jTable6.getSelectedRow();
                salesLotId.setText(jTable6.getValueAt(selectedRow, 0).toString());
            }
        });
    }
    
    private void loadData() {
        
        String[] columnNames = {"SALES ID", "CLIENT ID", "LOT ID", "STATUS"};

        Object[][] data = subdivision.getSalesTableData();

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        jTable4.setModel(model);
        
        jTable4.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable4.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable4.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable4.getColumnModel().getColumn(3).setPreferredWidth(80);
        
        
        String[] columnNames2 = {"ID", "BLOCK", "LOT", "TYPE", "AMENITIES" , "SIZE", "PRICE", "STATUS"};

        Object[][] data2 = subdivision.getTableData(true);

        DefaultTableModel model2 = new DefaultTableModel(data2, columnNames2);
        
        
        
        jTable6.setModel(model2);
        
        jTable6.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable6.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable6.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable6.getColumnModel().getColumn(3).setPreferredWidth(130);
        jTable6.getColumnModel().getColumn(4).setPreferredWidth(245);
        jTable6.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable6.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTable6.getColumnModel().getColumn(7).setPreferredWidth(100);
        
        
        String[] columnNames3 = {"ID", "CLIENT", "PHONE", "EMAIL", "LOT COUNT"};

        Object[][] data3 = subdivision.getClientTableData();

        DefaultTableModel model3 = new DefaultTableModel(data3, columnNames3);
        
        
        
        jTable5.setModel(model3);
        
        jTable5.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable5.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable5.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable5.getColumnModel().getColumn(3).setPreferredWidth(130);
        jTable5.getColumnModel().getColumn(4).setPreferredWidth(130);
    }
    
    private void populateTableFiltered() {
        
        String typeInput = (String) viewTypeComboBox.getSelectedItem();
        String sizeInput = viewSizeTextField.getText().trim();
        String priceInput = viewPriceTextField.getText().trim();
        String blockInput = (String) viewBlockComboBox.getSelectedItem();
        String lotInput = (String) viewLotComboBox.getSelectedItem();
        
        Integer blockNumber = (blockInput == null || blockInput.trim().isEmpty()) ? null : Integer.parseInt(blockInput);
        Integer lotNumber = (lotInput == null || lotInput.trim().isEmpty()) ? null : Integer.parseInt(lotInput);
        String houseType = (typeInput == null || typeInput.trim().isEmpty()) ? null : typeInput;
        Double minSize = (sizeInput.isEmpty() || sizeInput.trim().isEmpty()) ? null : Double.parseDouble(sizeInput);
        Double minPrice = (priceInput.isEmpty() || priceInput.trim().isEmpty()) ? null : Double.parseDouble(priceInput);
        boolean hasSwimmingPool = viewPoolCheckBox.isSelected();
        boolean hasGarage = viewGarageCheckBox.isSelected();

        
        if (blockNumber == null && lotNumber == null && houseType == null && minSize == null && minPrice == null 
            && !hasSwimmingPool && !hasGarage) {
            populateTable();
            return;
        }

        Object[][] filteredData = subdivision.getFilteredTableData(blockNumber, lotNumber, houseType, minSize, minPrice, hasSwimmingPool, hasGarage, true);

        DefaultTableModel model = new DefaultTableModel(filteredData, new String[]{"ID", "BLOCK", "LOT", "TYPE", "AMENITIES" , "SIZE", "PRICE", "STATUS", "CLIENT"});
        jTable2.setModel(model);
        
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(130);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(245);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(7).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(8).setPreferredWidth(100);
    }
    
    private void populateTable() {
        String[] columnNames = {"ID", "BLOCK", "LOT", "TYPE", "AMENITIES" , "SIZE", "PRICE", "STATUS", "CLIENT"};

        Object[][] data = subdivision.getTableData(true);

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        
        jTable2.setModel(model);
        
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(130);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(245);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(7).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(8).setPreferredWidth(100);
        
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideNav = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        managePropertyBtn = new javax.swing.JButton();
        clientBtn = new javax.swing.JButton();
        viewPropertyBtn = new javax.swing.JButton();
        clientBtn1 = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        managePropertyTab = new javax.swing.JPanel();
        managePropertyTypeComboBox = new javax.swing.JComboBox<>();
        managePropertyTypeLabel = new javax.swing.JLabel();
        managePropertySizeLabel = new javax.swing.JLabel();
        managePropertySizeTextField = new javax.swing.JTextField();
        managePropertyPriceLabel = new javax.swing.JLabel();
        managePropertyPriceTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        managePropertyBlockLabel = new javax.swing.JLabel();
        managePropertyBlockComboBox = new javax.swing.JComboBox<>();
        managePropertyLotLabel = new javax.swing.JLabel();
        managePropertyLotTextField = new javax.swing.JTextField();
        managePropertyRemoveBtn = new javax.swing.JButton();
        managePropertyAddBtn = new javax.swing.JButton();
        managePropertyViewTableBtn = new javax.swing.JButton();
        managePropertyAddFeatLabel = new javax.swing.JLabel();
        managePropertySwimmingPoolCheckBox = new javax.swing.JCheckBox();
        managePropertyGarageCheckBox = new javax.swing.JCheckBox();
        viewPropertyTab = new javax.swing.JPanel();
        viewTypeComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        viewBlockComboBox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        viewSizeTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        viewPriceTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        viewSearchBtn = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        viewGarageCheckBox = new javax.swing.JCheckBox();
        viewPoolCheckBox = new javax.swing.JCheckBox();
        viewResetBtn = new javax.swing.JButton();
        viewLotComboBox = new javax.swing.JComboBox<>();
        manageClientTab = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        salesTab = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        salesClientId = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        salesLotId = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        salesStatus = new javax.swing.JComboBox<>();
        salesAddBtn = new javax.swing.JButton();
        salesRemoveBtn = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideNav.setBackground(new java.awt.Color(107, 152, 231));

        jLabel1.setFont(new java.awt.Font("Montserrat Black", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DES REAL ESTATE");

        managePropertyBtn.setText("Manage Properties");
        managePropertyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePropertyBtnActionPerformed(evt);
            }
        });

        clientBtn.setText("Manage Client");
        clientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientBtnActionPerformed(evt);
            }
        });

        viewPropertyBtn.setText("View Properties");
        viewPropertyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPropertyBtnActionPerformed(evt);
            }
        });

        clientBtn1.setText("Sales");
        clientBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideNavLayout = new javax.swing.GroupLayout(sideNav);
        sideNav.setLayout(sideNavLayout);
        sideNavLayout.setHorizontalGroup(
            sideNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideNavLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(sideNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(managePropertyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(viewPropertyBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideNavLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(sideNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        sideNavLayout.setVerticalGroup(
            sideNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideNavLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(managePropertyBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPropertyBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientBtn1)
                .addContainerGap(431, Short.MAX_VALUE))
        );

        getContentPane().add(sideNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));

        jTabbedPane.setBackground(new java.awt.Color(204, 204, 204));

        managePropertyTab.setBackground(new java.awt.Color(232, 235, 241));

        managePropertyTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bungalow", "Duplex", "TownHouse" }));

        managePropertyTypeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        managePropertyTypeLabel.setText("Type:");

        managePropertySizeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        managePropertySizeLabel.setText("Size (sqr m):");

        managePropertySizeTextField.setText(" ");

        managePropertyPriceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        managePropertyPriceLabel.setText("Price (php):");

        managePropertyPriceTextField.setText(" ");

        jLabel5.setFont(new java.awt.Font("Montserrat Black", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("MANAGE PROPERTIES");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "TYPE", "BLOCK", "LOT", "SIZE", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        managePropertyBlockLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        managePropertyBlockLabel.setText("Block:");

        managePropertyBlockComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        managePropertyLotLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        managePropertyLotLabel.setText("Lot:");

        managePropertyLotTextField.setText(" ");

        managePropertyRemoveBtn.setBackground(new java.awt.Color(255, 51, 0));
        managePropertyRemoveBtn.setText("REMOVE");
        managePropertyRemoveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePropertyRemoveBtnActionPerformed(evt);
            }
        });

        managePropertyAddBtn.setBackground(new java.awt.Color(0, 204, 51));
        managePropertyAddBtn.setText("ADD");
        managePropertyAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePropertyAddBtnActionPerformed(evt);
            }
        });

        managePropertyViewTableBtn.setBackground(new java.awt.Color(242, 243, 133));
        managePropertyViewTableBtn.setText("VIEW TABLE");
        managePropertyViewTableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePropertyViewTableBtnActionPerformed(evt);
            }
        });

        managePropertyAddFeatLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        managePropertyAddFeatLabel.setText("Additional Features:");

        managePropertySwimmingPoolCheckBox.setText("Swimming Pool");
        managePropertySwimmingPoolCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePropertySwimmingPoolCheckBoxActionPerformed(evt);
            }
        });

        managePropertyGarageCheckBox.setText("Garage");
        managePropertyGarageCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePropertyGarageCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout managePropertyTabLayout = new javax.swing.GroupLayout(managePropertyTab);
        managePropertyTab.setLayout(managePropertyTabLayout);
        managePropertyTabLayout.setHorizontalGroup(
            managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managePropertyTabLayout.createSequentialGroup()
                .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(managePropertyTabLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(managePropertyTabLayout.createSequentialGroup()
                                .addComponent(managePropertySizeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(managePropertySizeTextField))
                            .addGroup(managePropertyTabLayout.createSequentialGroup()
                                .addComponent(managePropertyTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(managePropertyTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(managePropertyTabLayout.createSequentialGroup()
                                .addComponent(managePropertyPriceLabel)
                                .addGap(18, 18, 18)
                                .addComponent(managePropertyPriceTextField))
                            .addGroup(managePropertyTabLayout.createSequentialGroup()
                                .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(managePropertyBlockLabel)
                                    .addComponent(managePropertyLotLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(managePropertyLotTextField)
                                    .addComponent(managePropertyBlockComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(managePropertyTabLayout.createSequentialGroup()
                                .addComponent(managePropertyAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(managePropertyRemoveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(managePropertyAddFeatLabel)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managePropertyTabLayout.createSequentialGroup()
                                .addComponent(managePropertySwimmingPoolCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(managePropertyGarageCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(managePropertyViewTableBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(managePropertyTabLayout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel5)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        managePropertyTabLayout.setVerticalGroup(
            managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managePropertyTabLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addGap(65, 65, 65)
                .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(managePropertyTabLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(managePropertyTypeLabel)
                            .addComponent(managePropertyTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(managePropertySizeLabel)
                            .addComponent(managePropertySizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(managePropertyPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(managePropertyPriceLabel))
                        .addGap(18, 18, 18)
                        .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(managePropertyBlockLabel)
                            .addComponent(managePropertyBlockComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(managePropertyLotLabel)
                            .addComponent(managePropertyLotTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(managePropertyAddFeatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(managePropertyGarageCheckBox)
                            .addComponent(managePropertySwimmingPoolCheckBox))
                        .addGap(44, 44, 44)
                        .addGroup(managePropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(managePropertyAddBtn)
                            .addComponent(managePropertyRemoveBtn))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(managePropertyViewTableBtn)
                .addGap(56, 56, 56))
        );

        jTabbedPane.addTab("tab1", managePropertyTab);

        viewPropertyTab.setBackground(new java.awt.Color(232, 235, 241));

        viewTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Bungalow", "Duplex", "TownHouse" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Block:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Type:");

        viewBlockComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1", "2", "3", "4", "5" }));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Size (sqr m):");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Lot:");

        viewSizeTextField.setText(" ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Price (php):");

        viewPriceTextField.setText(" ");

        jLabel14.setFont(new java.awt.Font("Montserrat Black", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("VIEW PROPERTIES");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "BLOCK", "LOT", "TYPE", "AMENITIES", "SIZE", "PRICE", "OWNER", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        viewSearchBtn.setBackground(new java.awt.Color(204, 204, 204));
        viewSearchBtn.setText("SEARCH");
        viewSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSearchBtnActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Additional Features:");

        viewGarageCheckBox.setText("Garage");
        viewGarageCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewGarageCheckBoxActionPerformed(evt);
            }
        });

        viewPoolCheckBox.setText("Swimming Pool");
        viewPoolCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPoolCheckBoxActionPerformed(evt);
            }
        });

        viewResetBtn.setBackground(new java.awt.Color(204, 204, 204));
        viewResetBtn.setText("RESET");
        viewResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResetBtnActionPerformed(evt);
            }
        });

        viewLotComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        javax.swing.GroupLayout viewPropertyTabLayout = new javax.swing.GroupLayout(viewPropertyTab);
        viewPropertyTab.setLayout(viewPropertyTabLayout);
        viewPropertyTabLayout.setHorizontalGroup(
            viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPropertyTabLayout.createSequentialGroup()
                .addGroup(viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewPropertyTabLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel14))
                    .addGroup(viewPropertyTabLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(viewPropertyTabLayout.createSequentialGroup()
                                .addComponent(viewResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(viewSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(viewPropertyTabLayout.createSequentialGroup()
                                .addGroup(viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(viewPropertyTabLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(28, 28, 28)
                                        .addComponent(viewLotComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(viewSizeTextField))
                                    .addGroup(viewPropertyTabLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(12, 12, 12)
                                        .addComponent(viewBlockComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(viewPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(viewPropertyTabLayout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(viewTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel17)
                                    .addGroup(viewPropertyTabLayout.createSequentialGroup()
                                        .addComponent(viewPoolCheckBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(viewGarageCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(20, 20, 20))
        );
        viewPropertyTabLayout.setVerticalGroup(
            viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPropertyTabLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel14)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(viewBlockComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(viewPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10)
                    .addComponent(viewTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewPropertyTabLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(viewSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewPoolCheckBox)
                            .addComponent(viewGarageCheckBox))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(viewPropertyTabLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(viewLotComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(viewPropertyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewResetBtn)
                            .addComponent(viewSearchBtn))
                        .addContainerGap(42, Short.MAX_VALUE))))
        );

        jTabbedPane.addTab("tab2", viewPropertyTab);

        manageClientTab.setBackground(new java.awt.Color(232, 235, 241));

        jButton7.setBackground(new java.awt.Color(255, 51, 0));
        jButton7.setText("REMOVE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Montserrat Black", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("MANAGE CLIENTS");

        jButton9.setBackground(new java.awt.Color(0, 204, 51));
        jButton9.setText("ADD");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("First Name:");

        jTextField12.setText(" ");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENT", "PHONE NO.", "EMAIL", "PROPERTIES"
            }
        ));
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setMinWidth(35);
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(35);
        }

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Last Name:");

        jTextField13.setText(" ");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Phone No.");

        jTextField14.setText(" ");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Email:");

        jTextField15.setText(" ");

        javax.swing.GroupLayout manageClientTabLayout = new javax.swing.GroupLayout(manageClientTab);
        manageClientTab.setLayout(manageClientTabLayout);
        manageClientTabLayout.setHorizontalGroup(
            manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageClientTabLayout.createSequentialGroup()
                .addGroup(manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(manageClientTabLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(manageClientTabLayout.createSequentialGroup()
                                    .addGroup(manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel25))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(manageClientTabLayout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addGap(31, 31, 31)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(manageClientTabLayout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(manageClientTabLayout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jLabel21)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        manageClientTabLayout.setVerticalGroup(
            manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageClientTabLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel21)
                .addGap(63, 63, 63)
                .addGroup(manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(manageClientTabLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(manageClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton7))
                        .addGap(0, 165, Short.MAX_VALUE)))
                .addGap(154, 154, 154))
        );

        jTabbedPane.addTab("tab3", manageClientTab);

        salesTab.setBackground(new java.awt.Color(232, 235, 241));
        salesTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "SALES ID", "CLIENT ID", "LOT ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
            jTable4.getColumnModel().getColumn(2).setResizable(false);
        }

        salesTab.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 651, 130));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("Client ID:");
        salesTab.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        salesTab.add(salesClientId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 80, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Lot ID:");
        salesTab.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        salesTab.add(salesLotId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 80, -1));

        jLabel33.setFont(new java.awt.Font("Montserrat Black", 0, 20)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("MANAGE SALES");
        salesTab.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 34, -1, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("Sales List");
        salesTab.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 78, -1, -1));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENT", "TYPE", "BLOCK", "LOT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(2).setResizable(false);
            jTable5.getColumnModel().getColumn(3).setResizable(false);
            jTable5.getColumnModel().getColumn(4).setResizable(false);
        }

        salesTab.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 650, 130));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENT", "TYPE", "BLOCK", "LOT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(2).setResizable(false);
            jTable6.getColumnModel().getColumn(3).setResizable(false);
            jTable6.getColumnModel().getColumn(4).setResizable(false);
        }

        salesTab.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 650, 140));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("Lot List");
        salesTab.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 110, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("Client List");
        salesTab.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Status:");
        salesTab.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        salesStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sold", "Reserved" }));
        salesTab.add(salesStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 80, -1));

        salesAddBtn.setBackground(new java.awt.Color(0, 204, 51));
        salesAddBtn.setText("ADD");
        salesAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesAddBtnActionPerformed(evt);
            }
        });
        salesTab.add(salesAddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, -1));

        salesRemoveBtn.setBackground(new java.awt.Color(255, 51, 0));
        salesRemoveBtn.setText("REMOVE");
        salesRemoveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesRemoveBtnActionPerformed(evt);
            }
        });
        salesTab.add(salesRemoveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 140, -1));

        jButton16.setBackground(new java.awt.Color(242, 243, 133));
        jButton16.setText("MANAGE CLIENT");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        salesTab.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, -1, -1));

        jButton17.setBackground(new java.awt.Color(242, 243, 133));
        jButton17.setText("MANAGE LOT");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        salesTab.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, -1, -1));

        jTabbedPane.addTab("tab4", salesTab);

        getContentPane().add(jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, -40, 850, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void managePropertyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePropertyBtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane.setSelectedIndex(0); 
    }//GEN-LAST:event_managePropertyBtnActionPerformed

    private void clientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientBtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane.setSelectedIndex(2);
    }//GEN-LAST:event_clientBtnActionPerformed

    private void managePropertyRemoveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePropertyRemoveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_managePropertyRemoveBtnActionPerformed

    private void managePropertyAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePropertyAddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_managePropertyAddBtnActionPerformed

    private void managePropertyViewTableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePropertyViewTableBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_managePropertyViewTableBtnActionPerformed

    private void viewPropertyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPropertyBtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane.setSelectedIndex(1);
        populateTable();
    }//GEN-LAST:event_viewPropertyBtnActionPerformed

    private void clientBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientBtn1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane.setSelectedIndex(3);
        loadData(); 
    }//GEN-LAST:event_clientBtn1ActionPerformed

   
    
    private void salesAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesAddBtnActionPerformed
        // TODO add your handling code here:
        
        int statusInt = 0;
        String statusInput = salesStatus.getSelectedItem().toString();
        Integer clientId = salesClientId.getText().trim().isEmpty() ? null : Integer.parseInt(salesClientId.getText());
        Integer lotId = salesLotId.getText().trim().isEmpty() ? null : Integer.parseInt(salesLotId.getText());

        if (clientId == null && lotId == null) {
            JOptionPane.showMessageDialog(this, "Please select both a Client and a Lot.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int selectedRow = jTable6.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        
        if (statusInput == "Sold") 
            statusInt = 2;
        else if (statusInput == "Reserved") 
            statusInt = 3;
        
        for (int i = 0; i < model.getRowCount(); i++) {
            Object existingClientId = model.getValueAt(i, 1);
            Object existingLotId = model.getValueAt(i, 2);
            String status = jTable6.getValueAt(selectedRow, 7).toString();
                        
            if (status == "Available") {
                if (existingClientId != null && existingLotId != null) {
                    String existingClientStr = existingClientId.toString();
                    String existingLotStr = existingLotId.toString();
                    String clientStr = clientId.toString();
                    String lotStr = lotId.toString();

                    if (existingClientStr.equals(clientStr) && existingLotStr.equals(lotStr)) {
                        JOptionPane.showMessageDialog(this, "This sale record already exists.", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    if (!existingClientStr.equals(clientStr) && existingLotStr.equals(lotStr)) {
                        JOptionPane.showMessageDialog(this, "This lot is already owned by another client.", "Lot Already Owned", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "This lot is not available.", "Lot Already Owned", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        subdivision.addSalesById(clientId, lotId, statusInt);
        

        loadData();
    }//GEN-LAST:event_salesAddBtnActionPerformed

    private void salesRemoveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesRemoveBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable4.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a sale to remove.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object clientObj = jTable4.getValueAt(selectedRow, 1);
        Object lotObj = jTable4.getValueAt(selectedRow, 2);

        if (clientObj == null || lotObj == null || !clientObj.toString().matches("\\d+") || !lotObj.toString().matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Invalid data. Please check the table values.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int clientId = Integer.parseInt(clientObj.toString());
        int lotId = Integer.parseInt(lotObj.toString());

        subdivision.removeSalesById(clientId, lotId);

        loadData();
    }//GEN-LAST:event_salesRemoveBtnActionPerformed

    private void viewSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSearchBtnActionPerformed
        // TODO add your handling code here:
        populateTableFiltered();
    }//GEN-LAST:event_viewSearchBtnActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void managePropertySwimmingPoolCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePropertySwimmingPoolCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_managePropertySwimmingPoolCheckBoxActionPerformed

    private void managePropertyGarageCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePropertyGarageCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_managePropertyGarageCheckBoxActionPerformed

    private void viewGarageCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewGarageCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewGarageCheckBoxActionPerformed

    private void viewPoolCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPoolCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPoolCheckBoxActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void viewResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResetBtnActionPerformed
        // TODO add your handling code here:
        viewBlockComboBox.setSelectedIndex(0);
        viewLotComboBox.setSelectedIndex(0);
        viewTypeComboBox.setSelectedIndex(0);
        viewSizeTextField.setText("");
        viewPriceTextField.setText("");
        viewPoolCheckBox.setSelected(false);
        viewGarageCheckBox.setSelected(false);

        populateTable();
    }//GEN-LAST:event_viewResetBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientBtn;
    private javax.swing.JButton clientBtn1;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JPanel manageClientTab;
    private javax.swing.JButton managePropertyAddBtn;
    private javax.swing.JLabel managePropertyAddFeatLabel;
    private javax.swing.JComboBox<String> managePropertyBlockComboBox;
    private javax.swing.JLabel managePropertyBlockLabel;
    private javax.swing.JButton managePropertyBtn;
    private javax.swing.JCheckBox managePropertyGarageCheckBox;
    private javax.swing.JLabel managePropertyLotLabel;
    private javax.swing.JTextField managePropertyLotTextField;
    private javax.swing.JLabel managePropertyPriceLabel;
    private javax.swing.JTextField managePropertyPriceTextField;
    private javax.swing.JButton managePropertyRemoveBtn;
    private javax.swing.JLabel managePropertySizeLabel;
    private javax.swing.JTextField managePropertySizeTextField;
    private javax.swing.JCheckBox managePropertySwimmingPoolCheckBox;
    private javax.swing.JPanel managePropertyTab;
    private javax.swing.JComboBox<String> managePropertyTypeComboBox;
    private javax.swing.JLabel managePropertyTypeLabel;
    private javax.swing.JButton managePropertyViewTableBtn;
    private javax.swing.JButton salesAddBtn;
    private javax.swing.JTextField salesClientId;
    private javax.swing.JTextField salesLotId;
    private javax.swing.JButton salesRemoveBtn;
    private javax.swing.JComboBox<String> salesStatus;
    private javax.swing.JPanel salesTab;
    private javax.swing.JPanel sideNav;
    private javax.swing.JComboBox<String> viewBlockComboBox;
    private javax.swing.JCheckBox viewGarageCheckBox;
    private javax.swing.JComboBox<String> viewLotComboBox;
    private javax.swing.JCheckBox viewPoolCheckBox;
    private javax.swing.JTextField viewPriceTextField;
    private javax.swing.JButton viewPropertyBtn;
    private javax.swing.JPanel viewPropertyTab;
    private javax.swing.JButton viewResetBtn;
    private javax.swing.JButton viewSearchBtn;
    private javax.swing.JTextField viewSizeTextField;
    private javax.swing.JComboBox<String> viewTypeComboBox;
    // End of variables declaration//GEN-END:variables
}
