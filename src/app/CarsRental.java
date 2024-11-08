/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import app.MyConnection;


public class CarsRental extends javax.swing.JFrame {

     
    
    public CarsRental() {
        initComponents();
        DisplayCars();
        DisplayDrivers();
        DisplayRents();
        setLocationRelativeTo(null);
        GetCustomers();
        
       
        lbl_amount.setVisible(false);
    }

    // Make Connection   
    MyConnection conManager = new MyConnection();   
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    // Set database connection
    private void DisplayCars()
    {
        try
        {
            String CarStatus = "Available";
            con = conManager.createConnection();
            String sql = "SELECT * FROM cars WHERE status = '"+ CarStatus +"'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            table_cars.setModel(DbUtils.resultSetToTableModel(rs));
   
        }  
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
    }
    
    private void DisplayDrivers()
    {
        try
        {
            String DriverStatus = "Available";

            con = conManager.createConnection();
            String sql = "SELECT DriverID, Name, TelephoneNo, NIC FROM drivers WHERE status = '"+ DriverStatus +"'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            table_drivers.setModel(DbUtils.resultSetToTableModel(rs));

        }  
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
    }
    
    private void DisplayRents()
    {
        try
	{

		con = conManager.createConnection();
                String sql = "SELECT * FROM rent";
                PreparedStatement pstmt = con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                table_rent.setModel(DbUtils.resultSetToTableModel(rs));

	}

	catch(SQLException e)
	{
		e.printStackTrace();
	}
    }
    
    //	Add list of names to Customer combobox 
    private void GetCustomers()
    {
        try
        {
            con = conManager.createConnection();
            st = con.createStatement();            
            String query = "SELECT * FROM car_rental_system.customerdata";
            rs = st.executeQuery(query);
        
            while(rs.next())
            {
                String customer = rs.getString("Name");	
                cmb_customerName.addItem(customer);			
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooserBeanInfo1 = new com.toedter.calendar.JDateChooserBeanInfo();
        jCalendarBeanInfo1 = new com.toedter.calendar.JCalendarBeanInfo();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_rentid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_registration = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmb_customerName = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        date_rentDate = new com.toedter.calendar.JDateChooser();
        date_returnDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_cars = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_rent = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_drivers = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_driverID = new javax.swing.JTextField();
        btn_calDate = new javax.swing.JButton();
        lbl_amount = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 700));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cars Rental Management");

        jLabel2.setText("Rent ID");

        txt_rentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rentidActionPerformed(evt);
            }
        });

        jLabel3.setText("Car Registration ID");

        jLabel4.setText("Customer Name");

        cmb_customerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Customer Name" }));
        cmb_customerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_customerNameActionPerformed(evt);
            }
        });

        jLabel5.setText("Rent Date");

        jLabel6.setText("Amount (Rs)");

        date_rentDate.setDateFormatString("dd/MM/yyyy");

        date_returnDate.setDateFormatString("dd/MM/yyyy");

        jLabel7.setText("Return Date");

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_reset.setText("Clear");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        jLabel8.setText("Cars List");

        table_cars.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CarID", "Brand", "Model", "Status", "Price"
            }
        ));
        table_cars.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_carsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_cars);

        table_rent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RentID", "CarID", "Customer", "RentDate", "ReturnDate", "Amount", "DriverID"
            }
        ));
        table_rent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_rentMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_rent);

        jLabel9.setText("Cars On Rent");

        table_drivers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DriverID", "Name", "TelephoneNo", "NIC"
            }
        ));
        table_drivers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_driversMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_drivers);

        jLabel10.setText("Drivers List");

        jLabel11.setText("Driver ID");

        btn_calDate.setText("Calculate Days & Amount ");
        btn_calDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_calDateMouseClicked(evt);
            }
        });
        btn_calDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calDateActionPerformed(evt);
            }
        });

        lbl_amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_amount.setText("Display Amount(Rs)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_calDate)
                .addGap(173, 173, 173)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lbl_amount))
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(txt_rentid, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(41, 41, 41)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(txt_registration, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(38, 38, 38)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(cmb_customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(jLabel8)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(145, 145, 145)
                                        .addComponent(jLabel10))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(txt_driverID, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(date_rentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(85, 85, 85)))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(date_returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(btn_save)
                        .addGap(73, 73, 73)
                        .addComponent(btn_edit)
                        .addGap(46, 46, 46)
                        .addComponent(btn_reset)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_rentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_registration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_driverID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date_rentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_calDate)
                    .addComponent(lbl_amount))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_edit)
                    .addComponent(btn_reset))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_rentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rentidActionPerformed

    private void table_carsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_carsMouseClicked
        
        DefaultTableModel model = (DefaultTableModel)table_cars.getModel();
        
        // Set registration no when click the row
        int MyIndex = table_cars.getSelectedRow();
        txt_registration.setText(model.getValueAt(MyIndex, 0).toString());
        
        Carcost = Integer.valueOf(model.getValueAt(MyIndex, 4).toString());
        
    }//GEN-LAST:event_table_carsMouseClicked

    private void table_rentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_rentMouseClicked
        
        DefaultTableModel model = (DefaultTableModel)table_rent.getModel();
	int MyIndex = table_rent.getSelectedRow();
	txt_rentid.setText(model.getValueAt(MyIndex, 0).toString());
	txt_registration.setText(model.getValueAt(MyIndex, 1).toString());
	cmb_customerName.setSelectedItem(model.getValueAt(MyIndex, 2).toString());
        date_rentDate.setDate((Date) model.getValueAt(MyIndex, 3));
        date_returnDate.setDate((Date) model.getValueAt(MyIndex, 4));
        
        lbl_amount.setVisible(true);
        lbl_amount.setText(model.getValueAt(MyIndex, 5).toString());
        txt_driverID.setText(model.getValueAt(MyIndex, 6).toString());
        
        
        try
        {
            String CarStatus = "Booked";
            
            con = conManager.createConnection();
            String sql = "SELECT * FROM cars WHERE status = '"+ CarStatus +"'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            table_cars.setModel(DbUtils.resultSetToTableModel(rs));
  
        }  
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        
	
        
    }//GEN-LAST:event_table_rentMouseClicked

    private void UpdateCar_UpdateDriver()
    {
        try
        {
            con = conManager.createConnection();
            String CarReg = txt_registration.getText();
            String DriverID = txt_driverID.getText();
            String Status = "Booked";
            String Query1 = "UPDATE car_rental_system.cars SET Status= '"+ Status +"' WHERE CarID= '"+ CarReg +"'";
            String Query2 = "UPDATE car_rental_system.drivers SET Status= '"+ Status +"' WHERE DriverID= '"+ DriverID +"'";
            
            Statement Add = con.createStatement();
            Add.executeUpdate(Query1);
            Add.executeUpdate(Query2);
            JOptionPane.showMessageDialog(this, "Car and Driver details updated Successfully"); 

            DisplayCars();
            DisplayDrivers();
            Reset();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 
    java.util.Date RentDate, ReturnDate;
    java.sql.Date SetRent, SetReturn;
    
    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        
        if(txt_rentid.getText().isEmpty() || txt_registration.getText().isEmpty() || lbl_amount.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            try
            {
                // Get and Set rent date
                RentDate = date_rentDate.getDate();
		SetRent = new java.sql.Date(RentDate.getTime());
                
                ReturnDate = date_returnDate.getDate();
		SetReturn = new java.sql.Date(ReturnDate.getTime());
                
                con = conManager.createConnection();
                PreparedStatement add = con.prepareStatement("INSERT INTO rent VALUES (?, ?, ?, ?, ?, ?, ?)");
                
                add.setString(1, txt_rentid.getText());	
		add.setString(2, txt_registration.getText());
                add.setString(3, cmb_customerName.getSelectedItem().toString());
                add.setDate(4, SetRent);
		add.setDate(5, SetReturn);
                add.setInt(6, Integer.valueOf(lbl_amount.getText()));
                add.setString(7, txt_driverID.getText());	
                
                int row = add.executeUpdate();
		JOptionPane.showMessageDialog(this, "Rent Details added successfully");
		
                DisplayRents();
                
                UpdateCar_UpdateDriver();
                DisplayCars();
                DisplayDrivers();
                Reset();
                
               
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_btn_saveActionPerformed

    private void table_driversMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_driversMouseClicked
        
        DefaultTableModel model = (DefaultTableModel)table_drivers.getModel();
        
        // Set registration no when click the row
        int MyIndex = table_drivers.getSelectedRow();
        txt_driverID.setText(model.getValueAt(MyIndex, 0).toString());
        
    }//GEN-LAST:event_table_driversMouseClicked

    private void Reset()
    {
        txt_rentid.setText("");
        txt_registration.setText("");
        cmb_customerName.setSelectedIndex(0);
        txt_driverID.setText("");
        date_rentDate.setDate(null);
        date_returnDate.setDate(null);
        lbl_amount.setVisible(false);
        
        
    }
    
    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        
        Reset();
        
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        
        if(txt_rentid.getText().isEmpty())
	{
		JOptionPane.showMessageDialog(this, "Select the Rents details to be Updated");
	}
        else
	{
            try
            {
                RentDate = date_rentDate.getDate();
                SetRent = new java.sql.Date(RentDate.getTime());
                ReturnDate = date_returnDate.getDate();
                SetReturn = new java.sql.Date(ReturnDate.getTime());			
                
                con = conManager.createConnection();
                String RentID = txt_rentid.getText();
                String Query = "UPDATE car_rental_system.rent SET CarID = '"+ txt_registration.getText() +"', Customer = '"+ cmb_customerName.getSelectedItem().toString() +"', RentDate = '"+ SetRent +"', ReturnDate = '"+ SetReturn +"', Amount = '"+ Integer.valueOf(lbl_amount.getText()) +"', DriverID = '"+ txt_driverID.getText() +"' WHERE RentID = '"+ RentID +"'";	

                Statement Add = con.createStatement();
                Add.executeUpdate(Query);
                JOptionPane.showMessageDialog(this, "Rents details updated Successfully"); 

                DisplayRents();
                Reset();

            }
            catch(Exception e)
            {
                    e.printStackTrace();	
            }
	}
        
    }//GEN-LAST:event_btn_editActionPerformed

    int Carcost = 0;
    private void btn_calDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calDateActionPerformed
               
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date firstDate = date_rentDate.getDate();
            Date secondDate = date_returnDate.getDate();
            
            long diffM = Math.abs(secondDate.getTime() - firstDate.getTime());
            long dif = TimeUnit.DAYS.convert(diffM, TimeUnit.MILLISECONDS);
            
            long Fdate = Math.abs(firstDate.getTime());
            long Sdate = Math.abs(secondDate.getTime());

            if(Carcost == 0)
            {
                JOptionPane.showMessageDialog(this, "Informations are missing");
            }
            else
            {
                if(Fdate > Sdate)
                {
                    JOptionPane.showMessageDialog(this, "Enter correct Rental and Returns dates");
                }
                else
                {
                    int Amount = Carcost * (int) dif;
                
                    lbl_amount.setText(String.valueOf(Amount));
                    lbl_amount.setVisible(true);
                }
                
            }  
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_calDateActionPerformed

    private void btn_calDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_calDateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_calDateMouseClicked

    private void cmb_customerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_customerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_customerNameActionPerformed

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
            java.util.logging.Logger.getLogger(CarsRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarsRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarsRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarsRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarsRental().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calDate;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cmb_customerName;
    private com.toedter.calendar.JDateChooser date_rentDate;
    private com.toedter.calendar.JDateChooser date_returnDate;
    private com.toedter.calendar.JCalendarBeanInfo jCalendarBeanInfo1;
    private com.toedter.calendar.JDateChooserBeanInfo jDateChooserBeanInfo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_amount;
    private javax.swing.JTable table_cars;
    private javax.swing.JTable table_drivers;
    private javax.swing.JTable table_rent;
    private javax.swing.JTextField txt_driverID;
    private javax.swing.JTextField txt_registration;
    private javax.swing.JTextField txt_rentid;
    // End of variables declaration//GEN-END:variables
}
