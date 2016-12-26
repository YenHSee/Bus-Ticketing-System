/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.ImageIcon;
import control.*;
import domain.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Eric
 */;
public class PurchasePage extends javax.swing.JFrame {
   private int j1=1;
   private int j2=1;
   private int j3=1;
   private int j4=1;
   private int j5=1;
   private int j6=1;
   private int j7=1;
   private int j8=1;
   private int j9=1;
   private int j10=1;
   private int j11=1;
   private int j12=1;
   private int j13=1;
   private int j14=1;
   private int j15=1;
   private int j16=1;
   private int j17=1;
   private int j18=1;
   private int j19=1;
   private int j20=1;
   private int j21=1;
   private int j22=1;
   private int j23=1;
   private int j24=1;
   private int j25=1;
   private int j26=1;
   private int j27=1;
   private int j28=1;
   private int j29=1;
   private int j30=1;
   private int j31=1;
   private int j32=1;
   private int j33=1;
   private int j34=1;
   private int j35=1;
   private int j36=1;
   private int j37=1;
   private int j38=1;
   private int j39=1;
   private int j40=1;
   private String scheduleID;//klfjdslkajdlk
   private MaintainSchedule scheduleControl;
   private MaintainPurchase purchaseControl;
   private MaintainBus busControl;
   private MaintainStaff staffControl;
   private String host = "jdbc:derby://localhost:1527/FinalYearProject";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private int totalBusSeat;
    private ArrayList<Ticket> rows = new ArrayList<Ticket>(); 
    private String no="No   ";
    private String yes="Yes  ";
    private Ticket ticket;
    private PurchaseTicket purchase;
    private MaintainCustomer customerControl;
   
    

    public PurchasePage() {
       
        initComponents();
       
        purchaseControl=new MaintainPurchase();
        scheduleControl= new MaintainSchedule();
        busControl=new MaintainBus();
        staffControl=new MaintainStaff();
        customerControl=new MaintainCustomer(); 
        Schedule s=scheduleControl.selectRecord(scheduleID);

        String p = purchaseControl.purchaseRecord();
        int i = Integer.parseInt(p.replace("P","0")) + 1;//
        jtfPurchaseID.setText("P" + String.valueOf(i));
        jtfPurchaseID.setEditable(false);
        jtfTotalAmount.setEditable(false);
        jtfScheduleID.setEditable(false);
        jtfCustomerID.setEditable(false);
    
      }
    
    public void getScheduleID(String scheduleID,String userID1) {
        jtfScheduleID.setText(scheduleID);
        this.scheduleID=scheduleID;
        jtfScheduleID.setEditable(false);
        jtfCustomerID.setText(userID1);
        jtfCustomerID.setEditable(false);
        createConnection();
        getSeatAvailable();
        setEnabled();
        System.out.print(rows);
    }
   
    public void getSeatAvailable(){
        Schedule schedule=scheduleControl.selectRecord(scheduleID);
        Bus bus=busControl.selectRecord(schedule.getBus().getBusNumber());
        Staff staff=staffControl.selectRecord(schedule.getStaff().getStaffID());
        totalBusSeat=bus.getTotalBusSeat();
        
        int i=1;
        
        while(i<=totalBusSeat){
          
               String queryStr = "SELECT * FROM ticket WHERE scheduleID=? ";

        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,scheduleID);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
            Schedule schedule1=scheduleControl.selectRecord(rs.getString(2));

            rows.add(new Ticket(rs.getInt(1),schedule1,rs.getDouble(3),rs.getString(4),rs.getInt(5)));
        
            jtfTicketPrice.setText(String.format("%.2f", rs.getDouble(3)));
            }
            
        }catch(SQLException ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
            
            
            
            
            i++;
          
        }
    }
         private void createConnection() {
        try {
            
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfPurchaseID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfCustomerID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfTotalAmount = new javax.swing.JTextField();
        jbtPurchase = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jtfTicketPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfScheduleID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Purchese ID:");

        jtfPurchaseID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Purchase Ticket");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Customer ID:");

        jtfCustomerID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCustomerIDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Total amount:");

        jtfTotalAmount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfTotalAmount.setText("0.00");
        jtfTotalAmount.setToolTipText("");
        jtfTotalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTotalAmountActionPerformed(evt);
            }
        });

        jbtPurchase.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtPurchase.setText("Purchase");
        jbtPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPurchaseActionPerformed(evt);
            }
        });

        jButton41.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton41.setText("Payment");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPurchaseID, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jtfTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPurchaseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtPurchase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"))); // NOI18N
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jtfTicketPrice.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfTicketPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTicketPriceActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Ticket Price:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("ScheduleID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addComponent(jtfTicketPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfScheduleID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfTicketPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jtfScheduleID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCustomerIDActionPerformed

    private void jtfTotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTotalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTotalAmountActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          j4=j4+1; 
          if(j4%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton4.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(3);
             ticket.setSeatStatus(no);
             rows.set(3, ticket);
           }else if(j4%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              ticket=rows.get(3);
             ticket.setSeatStatus(yes);
             rows.set(3, ticket);
             jButton4.setIcon(IIi);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
             
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         j5=j5+1;
         if(j5%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton5.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(4);
             ticket.setSeatStatus(no);
             rows.set(4, ticket);
           }else if(j5%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton5.setIcon(IIi);
              ticket=rows.get(4);
             ticket.setSeatStatus(yes);
             rows.set(4, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            j7=j7+1;  
            if(j7%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton7.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(6);
             ticket.setSeatStatus(no);
             rows.set(6, ticket);
           }else if(j7%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton7.setIcon(IIi);
              ticket=rows.get(6);
             ticket.setSeatStatus(yes);
             rows.set(6, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
          
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
            j8=j8+1;  
            if(j8%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton8.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(7);
             ticket.setSeatStatus(no);
             rows.set(7, ticket);
           }else if(j8%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton8.setIcon(IIi);
              ticket=rows.get(7);
             ticket.setSeatStatus(yes);
             rows.set(7, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
          
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
            j9=j9+1; 
            if(j9%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton9.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(8);
             ticket.setSeatStatus(no);
             rows.set(8, ticket);
           }else if(j9%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton9.setIcon(IIi);
              ticket=rows.get(8);
             ticket.setSeatStatus(yes);
             rows.set(8, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
           
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
             j10=j10+1;  
             if(j10%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton10.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(9);
             ticket.setSeatStatus(no);
             rows.set(9, ticket);
           }else if(j10%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton10.setIcon(IIi);
              ticket=rows.get(9);
             ticket.setSeatStatus(yes);
             rows.set(9, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
          
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
             j11=j11+1;
             if(j11%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton11.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(10);
             ticket.setSeatStatus(no);
             rows.set(10, ticket);
           }else if(j11%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton11.setIcon(IIi);
              ticket=rows.get(10);
             ticket.setSeatStatus(yes);
             rows.set(10, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
            
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
          j12=j12+1;  
          if(j12%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton12.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(11);
             ticket.setSeatStatus(no);
             rows.set(11, ticket);
           }else if(j12%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton12.setIcon(IIi);
              ticket=rows.get(11);
             ticket.setSeatStatus(yes);
             rows.set(11, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
         
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     j1=j1+1;    
     if(j1%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton1.setIcon(II);
             Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(0);
             ticket.setSeatStatus(no);
             rows.set(0, ticket);
           }else if(j1%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              ticket=rows.get(0);
             ticket.setSeatStatus(yes);
             rows.set(0, ticket);
             jButton1.setIcon(IIi);
             Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
              
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       j6=j6+1;
       if(j6%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton6.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(5);
             ticket.setSeatStatus(no);
             rows.set(5, ticket);
           }else if(j6%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              ticket=rows.get(5);
             ticket.setSeatStatus(yes);
             rows.set(5, ticket);
             jButton6.setIcon(IIi);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
                  
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
          j13=j13+1;
          if(j13%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton13.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(12);
             ticket.setSeatStatus(no);
             rows.set(12, ticket);
           }else if(j13%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton13.setIcon(IIi);
              ticket=rows.get(12);
             ticket.setSeatStatus(yes);
             rows.set(12, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
             
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
               j14=j14+1;  
               if(j14%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton14.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(13);
             ticket.setSeatStatus(no);
             rows.set(13, ticket);
           }else if(j14%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton14.setIcon(IIi);
              ticket=rows.get(13);
             ticket.setSeatStatus(yes);
             rows.set(13, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
           
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
               j15=j15+1;  
               if(j15%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton15.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(14);
             ticket.setSeatStatus(no);
             rows.set(14, ticket);
           }else if(j15%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton15.setIcon(IIi);
              ticket=rows.get(14);
             ticket.setSeatStatus(yes);
             rows.set(14, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
           
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
               j16=j16+1;
               if(j16%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton16.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(15);
             ticket.setSeatStatus(no);
             rows.set(15, ticket);
           }else if(j16%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton16.setIcon(IIi);
              ticket=rows.get(15);
             ticket.setSeatStatus(yes);
             rows.set(15, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
            
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
               j17=j17+1;
               if(j17%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton17.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(16);
             ticket.setSeatStatus(no);
             rows.set(16, ticket);
           }else if(j17%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton17.setIcon(IIi);
              ticket=rows.get(16);
             ticket.setSeatStatus(yes);
             rows.set(16, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
            
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
             j18=j18+1;  
             if(j18%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton18.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(17);
             ticket.setSeatStatus(no);
             rows.set(17, ticket);
           }else if(j18%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton18.setIcon(IIi);
              ticket=rows.get(17);
             ticket.setSeatStatus(yes);
             rows.set(17, ticket);
             Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
           
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
           j19=j19+1;  
           if(j19%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton19.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(18);
             ticket.setSeatStatus(no);
             rows.set(18, ticket);
           }else if(j19%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton19.setIcon(IIi);
              ticket=rows.get(18);
             ticket.setSeatStatus(yes);
             rows.set(18, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
           
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
              j20=j20+1; 
              if(j20%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton20.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(19);
             ticket.setSeatStatus(no);
             rows.set(19, ticket);
           }else if(j20%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton20.setIcon(IIi);
              ticket=rows.get(19);
             ticket.setSeatStatus(yes);
             rows.set(19, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
          
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
         j21=j21+1;  
        if(j21%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton21.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(20);
             ticket.setSeatStatus(no);
             rows.set(20, ticket);
           }else if(j21%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton21.setIcon(IIi);
              ticket=rows.get(20);
             ticket.setSeatStatus(yes);
             rows.set(20, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
           
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
j22=j22+1;
        if(j22%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton22.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(21);
             ticket.setSeatStatus(no);
             rows.set(21, ticket);
           }else if(j22%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton22.setIcon(IIi);
              ticket=rows.get(21);
             ticket.setSeatStatus(yes);
             rows.set(21, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
             
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
 j23=j23+1; 
        if(j23%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton23.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(22);
             ticket.setSeatStatus(no);
             rows.set(22, ticket);
           }else if(j23%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton23.setIcon(IIi);
              ticket=rows.get(22);
             ticket.setSeatStatus(yes);
             rows.set(22, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
           
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
          j24=j24+1;  
          if(j24%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton24.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(23);
             ticket.setSeatStatus(no);
             rows.set(23, ticket);
           }else if(j24%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton24.setIcon(IIi);
              ticket=rows.get(23);
             ticket.setSeatStatus(yes);
             rows.set(23, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
          
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        j25=j25+1;
        if(j25%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton25.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(24);
             ticket.setSeatStatus(no);
             rows.set(24, ticket);
           }else if(j25%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton25.setIcon(IIi);
              ticket=rows.get(24);
             ticket.setSeatStatus(yes);
             rows.set(24, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
             
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
         j26=j26+1;  
        if(j26%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton26.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(25);
             ticket.setSeatStatus(no);
             rows.set(25, ticket);
           }else if(j26%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton26.setIcon(IIi);
              ticket=rows.get(25);
             ticket.setSeatStatus(yes);
             rows.set(25, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
          
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
          j27=j27+1;  
          if(j27%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton27.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(26);
             ticket.setSeatStatus(no);
             rows.set(26, ticket);
           }else if(j27%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton27.setIcon(IIi);
              ticket=rows.get(26);
             ticket.setSeatStatus(yes);
             rows.set(26, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
           
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
           j28=j28+1;  
           if(j28%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton28.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(27);
             ticket.setSeatStatus(no);
             rows.set(27, ticket);
           }else if(j28%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton28.setIcon(IIi);
              ticket=rows.get(27);
             ticket.setSeatStatus(yes);
             rows.set(27, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
           
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
           j29=j29+1; 
           if(j29%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton29.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(28);
             ticket.setSeatStatus(no);
             rows.set(28, ticket);
           }else if(j29%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton29.setIcon(IIi);
              ticket=rows.get(28);
             ticket.setSeatStatus(yes);
             rows.set(28, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
            
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
            j30=j30+1;  
            if(j30%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton30.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(29);
             ticket.setSeatStatus(no);
             rows.set(29, ticket);
           }else if(j30%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton30.setIcon(IIi);
              ticket=rows.get(29);
             ticket.setSeatStatus(yes);
             rows.set(29, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
          
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
         j31=j31+1;  
         if(j31%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton31.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(30);
             ticket.setSeatStatus(no);
             rows.set(30, ticket);
           }else if(j31%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton31.setIcon(IIi);
              ticket=rows.get(30);
             ticket.setSeatStatus(yes);
             rows.set(30, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
           
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
     j32=j32+1;
     if(j32%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton32.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(31);
             ticket.setSeatStatus(no);
             rows.set(31, ticket);
           }else if(j32%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton32.setIcon(IIi);
              ticket=rows.get(31);
             ticket.setSeatStatus(yes);
             rows.set(31, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
            
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
         j33=j33+1;
         if(j33%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton33.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(32);
             ticket.setSeatStatus(no);
             rows.set(32, ticket);
           }else if(j33%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton33.setIcon(IIi);
              ticket=rows.get(32);
             ticket.setSeatStatus(yes);
             rows.set(32, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
             
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
         j34=j34+1;  
         if(j34%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton34.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(33);
             ticket.setSeatStatus(no);
             rows.set(33, ticket);
           }else if(j34%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton34.setIcon(IIi);
              ticket=rows.get(33);
             ticket.setSeatStatus(yes);
             rows.set(33, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
          
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        j35=j35+1; 
        if(j35%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton35.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(34);
             ticket.setSeatStatus(no);
             rows.set(34, ticket);
           }else if(j35%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton35.setIcon(IIi);
              ticket=rows.get(34);
             ticket.setSeatStatus(yes);
             rows.set(34, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
            
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
         j36=j36+1; 
         if(j36%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton36.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(35);
             ticket.setSeatStatus(no);
             rows.set(35, ticket);
           }else if(j36%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton36.setIcon(IIi);
              ticket=rows.get(35);
             ticket.setSeatStatus(yes);
             rows.set(35, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
            
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
         j37=j37+1;
         if(j37%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton37.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(36);
             ticket.setSeatStatus(no);
             rows.set(36, ticket);
           }else if(j37%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton37.setIcon(IIi);
              ticket=rows.get(36);
             ticket.setSeatStatus(yes);
             rows.set(36, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
             
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
          j38=j38+1; 
          if(j38%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton38.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(37);
             ticket.setSeatStatus(no);
             rows.set(37, ticket);
           }else if(j38%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton38.setIcon(IIi);
              ticket=rows.get(37);
             ticket.setSeatStatus(yes);
             rows.set(37, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
           
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        j39=j39+1;
        if(j39%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton39.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(38);
             ticket.setSeatStatus(no);
             rows.set(38, ticket);
           }else if(j39%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton39.setIcon(IIi);
              ticket=rows.get(38);
             ticket.setSeatStatus(yes);
             rows.set(38, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
             
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
         j40=j40+1;
         if(j40%2==0){
               ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton40.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(39);
             ticket.setSeatStatus(no);
             rows.set(39, ticket);
           }else if(j40%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              
              jButton40.setIcon(IIi);
              ticket=rows.get(39);
             ticket.setSeatStatus(yes);
             rows.set(39, ticket);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
             
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            j2=j2+1;  
            if(j2%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton2.setIcon(II);
             Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(1);
             ticket.setSeatStatus(no);
             rows.set(1, ticket);
           }else if(j2%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              ticket=rows.get(1);
             ticket.setSeatStatus(yes);
             rows.set(1, ticket);
             jButton2.setIcon(IIi);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtfTicketPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTicketPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTicketPriceActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            j3=j3+1;  
            if(j3%2==0){
            ImageIcon II= new ImageIcon(getClass().getResource("/picture/seat_Pink.PNG"));
            
             jButton3.setIcon(II);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price+price1));
             ticket=rows.get(2);
             ticket.setSeatStatus(no);
             rows.set(2, ticket);
           }else if(j3%2==1){
              ImageIcon IIi= new ImageIcon(getClass().getResource("/picture/seat_Grean.PNG"));
              ticket=rows.get(2);
             ticket.setSeatStatus(yes);
             rows.set(2, ticket);
             jButton3.setIcon(IIi);
               Double price=Double.parseDouble(jtfTotalAmount.getText());
             Double price1=Double.parseDouble(jtfTicketPrice.getText());
             jtfTotalAmount.setText(String.format("%.2f",price-price1));
             }
          
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbtPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPurchaseActionPerformed
            String purchaseID=jtfPurchaseID.getText();
        String customerID=jtfCustomerID.getText();
        Double totalAmount=Double.parseDouble(jtfTotalAmount.getText());
        Customer c=customerControl.selectRecord(customerID);
        Purchase p=purchaseControl.selectRecord(purchaseID);
        
        if(p==null && c!=null){
            p=new Purchase(purchaseID,c,totalAmount);
        purchaseControl.createRecord(p);
        JOptionPane.showMessageDialog(null, "Purchase successful.", "Sucessful",JOptionPane.INFORMATION_MESSAGE);
        int i=0;
      try{
          while(i<totalBusSeat){
            String updateStr = "UPDATE ticket Set scheduleID=?, ticketprice=?, seatStatus=?, seatNumber=?"+ " WHERE ticketNo=? ";
            stmt = conn.prepareStatement(updateStr);
         
           
            
           stmt.setString(1,rows.get(i).getSchedule().getScheduleID());
           stmt.setDouble(2,rows.get(i).getTicketPrice());
           stmt.setString(3,rows.get(i).getSeatStatus());
           stmt.setInt(4,rows.get(i).getSeatNumber()); 
           stmt.setInt(5,rows.get(i).getTicketNo());
            stmt.executeUpdate();
            
            i++;
            
            jtfTotalAmount.setText("0.00");
            
      }
          
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
          
          
       if(j1%2==0){
           createPurchaseTicket(purchaseID, rows.get(0).getTicketNo());
       }
        if(j2%2==0){
           createPurchaseTicket(purchaseID, rows.get(1).getTicketNo());
       }
         if(j3%2==0){
           createPurchaseTicket(purchaseID, rows.get(2).getTicketNo());
       }
            if(j4%2==0){
           createPurchaseTicket(purchaseID, rows.get(3).getTicketNo());
       }
        if(j5%2==0){
           createPurchaseTicket(purchaseID, rows.get(4).getTicketNo());
       }
         if(j6%2==0){
           createPurchaseTicket(purchaseID, rows.get(5).getTicketNo());
       }
            if(j7%2==0){
           createPurchaseTicket(purchaseID, rows.get(6).getTicketNo());
       }
        if(j8%2==0){
           createPurchaseTicket(purchaseID, rows.get(7).getTicketNo());
       }
         if(j9%2==0){
           createPurchaseTicket(purchaseID, rows.get(8).getTicketNo());
       }   if(j10%2==0){
           createPurchaseTicket(purchaseID, rows.get(9).getTicketNo());
       } if(j11%2==0){
           createPurchaseTicket(purchaseID, rows.get(10).getTicketNo());
       }
        if(j12%2==0){
           createPurchaseTicket(purchaseID, rows.get(11).getTicketNo());
       }
         if(j13%2==0){
           createPurchaseTicket(purchaseID, rows.get(12).getTicketNo());
       }
            if(j14%2==0){
           createPurchaseTicket(purchaseID, rows.get(13).getTicketNo());
       }
        if(j15%2==0){
           createPurchaseTicket(purchaseID, rows.get(14).getTicketNo());
       }
         if(j16%2==0){
           createPurchaseTicket(purchaseID, rows.get(15).getTicketNo());
       }
            if(j17%2==0){
           createPurchaseTicket(purchaseID, rows.get(16).getTicketNo());
       }
        if(j18%2==0){
           createPurchaseTicket(purchaseID, rows.get(17).getTicketNo());
       }
         if(j19%2==0){
           createPurchaseTicket(purchaseID, rows.get(18).getTicketNo());
       }   if(j20%2==0){
           createPurchaseTicket(purchaseID, rows.get(19).getTicketNo());
       } if(j21%2==0){
           createPurchaseTicket(purchaseID, rows.get(20).getTicketNo());
       }
        if(j22%2==0){
           createPurchaseTicket(purchaseID, rows.get(21).getTicketNo());
       }
         if(j23%2==0){
           createPurchaseTicket(purchaseID, rows.get(22).getTicketNo());
       }
            if(j24%2==0){
           createPurchaseTicket(purchaseID, rows.get(23).getTicketNo());
       }
        if(j25%2==0){
           createPurchaseTicket(purchaseID, rows.get(24).getTicketNo());
       }
         if(j26%2==0){
           createPurchaseTicket(purchaseID, rows.get(25).getTicketNo());
       }
            if(j27%2==0){
           createPurchaseTicket(purchaseID, rows.get(26).getTicketNo());
       }
        if(j28%2==0){
           createPurchaseTicket(purchaseID, rows.get(27).getTicketNo());
       }
         if(j29%2==0){
           createPurchaseTicket(purchaseID, rows.get(28).getTicketNo());
       }   if(j30%2==0){
           createPurchaseTicket(purchaseID, rows.get(29).getTicketNo());
       } if(j31%2==0){
           createPurchaseTicket(purchaseID, rows.get(30).getTicketNo());
       }
        if(j32%2==0){
           createPurchaseTicket(purchaseID, rows.get(31).getTicketNo());
       }
         if(j33%2==0){
           createPurchaseTicket(purchaseID, rows.get(32).getTicketNo());
       }
            if(j34%2==0){
           createPurchaseTicket(purchaseID, rows.get(33).getTicketNo());
       }
        if(j35%2==0){
           createPurchaseTicket(purchaseID, rows.get(34).getTicketNo());
       }
         if(j36%2==0){
           createPurchaseTicket(purchaseID, rows.get(35).getTicketNo());
       }
            if(j37%2==0){
           createPurchaseTicket(purchaseID, rows.get(36).getTicketNo());
       }
        if(j38%2==0){
           createPurchaseTicket(purchaseID, rows.get(37).getTicketNo());
       }
         if(j39%2==0){
           createPurchaseTicket(purchaseID, rows.get(38).getTicketNo());
       }   if(j40%2==0){
           createPurchaseTicket(purchaseID, rows.get(39).getTicketNo());
       }
       getSeatAvailable();
       setEnabled();
       j1=1;j2=1;j3=1;j4=1;j5=1;j6=1;j7=1;j8=1;j9=1;j10=1;
        j11=1;j12=1;j13=1;j14=1;j15=1;j16=1;j17=1;j18=1;j19=1;j20=1;
        j21=1;j22=1;j23=1;j24=1;j25=1;j26=1;j27=1;j28=1;j29=1;j30=1;
        j31=1;j32=1;j33=1;j34=1;j35=1;j36=1;j37=1;j38=1;j39=1;j40=1;
    }else{
            if(c==null){
                JOptionPane.showMessageDialog(null, " Customer ID not exist.", "Error",JOptionPane.ERROR_MESSAGE);
            }else if(p !=null){
                JOptionPane.showMessageDialog(null, " Purchase ID alraedly exist.", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbtPurchaseActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        
        String userID = jtfCustomerID.getText();
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.getUserID(userID);
        this.dispose();
        paymentPage.setVisible(true);
        
        
        
    }//GEN-LAST:event_jButton41ActionPerformed
public void setEnabled(){
     if(no.equals(rows.get(0).getSeatStatus())||totalBusSeat<1){
            
            jButton1.setEnabled(false);
        }    
        if(no.equals(rows.get(1).getSeatStatus())||totalBusSeat<2){
            
            jButton2.setEnabled(false);
        }  
        if(no.equals(rows.get(2).getSeatStatus())||totalBusSeat<3){
            
            jButton3.setEnabled(false);
        }  
         if(no.equals(rows.get(3).getSeatStatus())||totalBusSeat<4){
            
            jButton4.setEnabled(false);
        }
        if(no.equals(rows.get(4).getSeatStatus())||totalBusSeat<5){
            
            jButton5.setEnabled(false);
        }  
        if(no.equals(rows.get(5).getSeatStatus())||totalBusSeat<6){
            
            jButton6.setEnabled(false);
        }  
       if(no.equals(rows.get(6).getSeatStatus())||totalBusSeat<7){
            
            jButton7.setEnabled(false);
        }  
        if(no.equals(rows.get(7).getSeatStatus())||totalBusSeat<8){
            
            jButton8.setEnabled(false);
        }  
       if(no.equals(rows.get(8).getSeatStatus())||totalBusSeat<9){
            
            jButton9.setEnabled(false);
        }  
          if(no.equals(rows.get(9).getSeatStatus())||totalBusSeat<10){
            
            jButton10.setEnabled(false);
        }  
        if(no.equals(rows.get(10).getSeatStatus())||totalBusSeat<11){
            
            jButton11.setEnabled(false);
        }    
        if(no.equals(rows.get(11).getSeatStatus())||totalBusSeat<12){
            
            jButton12.setEnabled(false);
        }  
        if(no.equals(rows.get(12).getSeatStatus())||totalBusSeat<13){
            
            jButton13.setEnabled(false);
        }  
         if(no.equals(rows.get(13).getSeatStatus())||totalBusSeat<14){
            
            jButton14.setEnabled(false);
        }
        if(no.equals(rows.get(14).getSeatStatus())||totalBusSeat<15){
            
            jButton15.setEnabled(false);
        }  
        if(no.equals(rows.get(15).getSeatStatus())||totalBusSeat<16){
            
            jButton16.setEnabled(false);
        }  
       if(no.equals(rows.get(16).getSeatStatus())||totalBusSeat<17){
            
            jButton17.setEnabled(false);
        }  
        if(no.equals(rows.get(17).getSeatStatus())||totalBusSeat<18){
            
            jButton18.setEnabled(false);
        }  
       if(no.equals(rows.get(18).getSeatStatus())||totalBusSeat<19){
            
            jButton19.setEnabled(false);
        }  
          if(no.equals(rows.get(19).getSeatStatus())||totalBusSeat<20){
            
            jButton20.setEnabled(false);
        }  
          if(no.equals(rows.get(20).getSeatStatus())||totalBusSeat<21){
            
            jButton21.setEnabled(false);
        }    
        if(no.equals(rows.get(21).getSeatStatus())||totalBusSeat<22){
            
            jButton22.setEnabled(false);
        }  
        if(no.equals(rows.get(22).getSeatStatus())||totalBusSeat<23){
            
            jButton23.setEnabled(false);
        }  
         if(no.equals(rows.get(23).getSeatStatus())||totalBusSeat<24){
            
            jButton24.setEnabled(false);
        }
        if(no.equals(rows.get(24).getSeatStatus())||totalBusSeat<25){
            
            jButton25.setEnabled(false);
        }  
        if(no.equals(rows.get(25).getSeatStatus())||totalBusSeat<26){
            
            jButton26.setEnabled(false);
        }  
       if(no.equals(rows.get(26).getSeatStatus())||totalBusSeat<27){
            
            jButton27.setEnabled(false);
        }  
        if(no.equals(rows.get(27).getSeatStatus())||totalBusSeat<28){
            
            jButton28.setEnabled(false);
        }  
       if(no.equals(rows.get(28).getSeatStatus())||totalBusSeat<29){
            
            jButton29.setEnabled(false);
        }  
          if(no.equals(rows.get(29).getSeatStatus())||totalBusSeat<30){
            
            jButton30.setEnabled(false);
        }  
         if(no.equals(rows.get(30).getSeatStatus())||totalBusSeat<31){
            
            jButton31.setEnabled(false);
        }    
        if(no.equals(rows.get(31).getSeatStatus())||totalBusSeat<32){
            
            jButton32.setEnabled(false);
        }  
        if(no.equals(rows.get(32).getSeatStatus())||totalBusSeat<33){
            
            jButton33.setEnabled(false);
        }  
         if(no.equals(rows.get(33).getSeatStatus())||totalBusSeat<34){
            
            jButton34.setEnabled(false);
        }
        if(no.equals(rows.get(34).getSeatStatus())||totalBusSeat<35){
            
            jButton35.setEnabled(false);
        }  
        if(no.equals(rows.get(35).getSeatStatus())||totalBusSeat<36){
            
            jButton36.setEnabled(false);
        }  
       if(no.equals(rows.get(36).getSeatStatus())||totalBusSeat<37){
            
            jButton37.setEnabled(false);
        }  
        if(no.equals(rows.get(37).getSeatStatus())||totalBusSeat<38){
            
            jButton38.setEnabled(false);
        }  
       if(no.equals(rows.get(38).getSeatStatus())||totalBusSeat<39){
            
            jButton39.setEnabled(false);
        }  
          if(no.equals(rows.get(39).getSeatStatus())||totalBusSeat<40){
            
            jButton40.setEnabled(false);
        }  
}
public void createPurchaseTicket(String purchaseID,int ticketNu){
     String insertStr = " INSERT INTO purchaseTicket VALUES(?,?)";
        
        try
        {
            stmt = conn.prepareStatement(insertStr);
            stmt.setInt(2,ticketNu);
            stmt.setString(1,purchaseID);
            
            stmt.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);   
        }
}
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
            java.util.logging.Logger.getLogger(PurchasePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchasePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchasePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchasePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchasePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtPurchase;
    private javax.swing.JTextField jtfCustomerID;
    private javax.swing.JTextField jtfPurchaseID;
    private javax.swing.JTextField jtfScheduleID;
    private javax.swing.JTextField jtfTicketPrice;
    private javax.swing.JTextField jtfTotalAmount;
    // End of variables declaration//GEN-END:variables
}
