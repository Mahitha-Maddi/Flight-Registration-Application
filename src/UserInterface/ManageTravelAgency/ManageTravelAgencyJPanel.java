/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManageTravelAgency;

import Business.Airliner;
import Business.Flight;
import Business.TravelAgency;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vikram
 */
public class ManageTravelAgencyJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageTravelAgencyJPanel
     */
    TravelAgency travelAgency;
    JPanel cardSequenceJPanel;
    
    public ManageTravelAgencyJPanel(JPanel cardSequenceJPanel, TravelAgency travelAgency) {
        initComponents();
        this.cardSequenceJPanel = cardSequenceJPanel;
        this.travelAgency = travelAgency;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDestinationLocation = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSearchFlight = new javax.swing.JTable();
        txtDepartureLocation = new javax.swing.JTextField();
        txtDestination = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtTimeofDay = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFlightNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtDepartureDate = new javax.swing.JTextField();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Travel Agency");
        add(jLabel1);
        jLabel1.setBounds(0, 11, 800, 35);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Departure");
        add(jLabel2);
        jLabel2.setBounds(109, 167, 121, 30);

        txtDestinationLocation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDestinationLocation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDestinationLocation.setText("Destination");
        add(txtDestinationLocation);
        txtDestinationLocation.setBounds(426, 166, 146, 32);

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch);
        btnSearch.setBounds(353, 219, 125, 34);

        tblSearchFlight.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airliner", "Flight No", "Departure", "Arrival", "Time of Day", "Departure Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSearchFlight);

        add(jScrollPane1);
        jScrollPane1.setBounds(80, 280, 686, 110);

        txtDepartureLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartureLocationActionPerformed(evt);
            }
        });
        add(txtDepartureLocation);
        txtDepartureLocation.setBounds(234, 168, 150, 33);

        txtDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinationActionPerformed(evt);
            }
        });
        add(txtDestination);
        txtDestination.setBounds(576, 168, 161, 33);

        jLabel3.setText("Time of day");
        add(jLabel3);
        jLabel3.setBounds(210, 80, 80, 16);

        TxtTimeofDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTimeofDayActionPerformed(evt);
            }
        });
        add(TxtTimeofDay);
        TxtTimeofDay.setBounds(290, 80, 180, 22);

        jLabel4.setText("Flight Number");
        add(jLabel4);
        jLabel4.setBounds(81, 120, 90, 16);

        txtFlightNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFlightNoActionPerformed(evt);
            }
        });
        add(txtFlightNo);
        txtFlightNo.setBounds(200, 120, 150, 22);

        jLabel5.setText("Date");
        add(jLabel5);
        jLabel5.setBounds(430, 130, 26, 16);
        add(TxtDepartureDate);
        TxtDepartureDate.setBounds(540, 130, 130, 22);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
                                                
        // TODO add your handling code here:
        
        ArrayList<Flight> flightResult = travelAgency.getFlightDirectory().
                searchFlight(txtDepartureLocation.getText(),txtDestination.getText(),txtFlightNo.getText(),TxtDepartureDate.getText(),TxtTimeofDay.getText());
        if (flightResult == null) {
            JOptionPane.showMessageDialog(null, "No flights available","Information",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            DefaultTableModel dtm = (DefaultTableModel) tblSearchFlight.getModel();
            dtm.setRowCount(0);
        
        for(Flight flight:flightResult) {
            Object row[] = new Object[6];
            row[0] = flight.getAirlinerName();
            row[1] = flight.getFlightId();
            row[2] = flight.getDepartureLocation();
            row[3] = flight.getArrivalLocation();
            row[4] = flight.getTimeOfDay();
            row[5] = flight.getDepartureDate();
            dtm.addRow(row);
        }
      }
    
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinationActionPerformed

    private void txtDepartureLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartureLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartureLocationActionPerformed

    private void TxtTimeofDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTimeofDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTimeofDayActionPerformed

    private void txtFlightNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFlightNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFlightNoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtDepartureDate;
    private javax.swing.JTextField TxtTimeofDay;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSearchFlight;
    private javax.swing.JTextField txtDepartureLocation;
    private javax.swing.JTextField txtDestination;
    private javax.swing.JLabel txtDestinationLocation;
    private javax.swing.JTextField txtFlightNo;
    // End of variables declaration//GEN-END:variables
}
