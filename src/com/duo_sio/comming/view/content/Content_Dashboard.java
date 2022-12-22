package com.duo_sio.comming.view.content;

import com.duo_sio.comming.controller.DashboardController;
import com.duo_sio.comming.model.Model_Card;
import com.duo_sio.comming.model.OverviewDashboardPenggunaModel;
import com.duo_sio.comming.model.StatusType;
import com.duo_sio.comming.utils.CommonUtils;
import com.duo_sio.comming.view.swing.ScrollBar;
import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Content_Dashboard extends javax.swing.JPanel {
    private DashboardController dashboardController = new DashboardController();
    public Content_Dashboard() {
        initComponents();
        initCard();
        
        //  add row table
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        initTable();
        
    }
    
    private void initCard() {
        List<Model_Card> cards = dashboardController.getCardPengguna();
        card1.setData(cards.get(0));
        card2.setData(cards.get(1));
        card3.setData(cards.get(2));
    }
    
    private void initTable() {
        dashboardController.getOverviewPengguna().forEach(o ->{
            StatusType stat;
            stat = switch (o.getStatus()) {
                case 0 -> StatusType.PENDING;
                case 1 -> StatusType.SUCCESS;
                default -> StatusType.FAILED;
            };
            table.addRow(new Object[]{o.getType(), CommonUtils.getFormattedPrice(o.getPrice()), o.getTitle(), o.getCreated_at(), stat});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.duo_sio.comming.view.component.Card();
        card2 = new com.duo_sio.comming.view.component.Card();
        card3 = new com.duo_sio.comming.view.component.Card();
        panelBorder1 = new com.duo_sio.comming.view.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new com.duo_sio.comming.view.swing.Table();

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(25, 118, 211));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(25, 118, 211));
        card2.setColor2(new java.awt.Color(138, 194, 255));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(138, 32, 255));
        card3.setColor2(new java.awt.Color(138, 194, 255));
        panel.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Overview Mentoring dan Project");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Price", "Topik/Project", "Created_at", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spTable))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1510, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.duo_sio.comming.view.component.Card card1;
    private com.duo_sio.comming.view.component.Card card2;
    private com.duo_sio.comming.view.component.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private com.duo_sio.comming.view.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private com.duo_sio.comming.view.swing.Table table;
    // End of variables declaration//GEN-END:variables

    

    
}
