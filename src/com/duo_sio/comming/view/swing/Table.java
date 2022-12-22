package com.duo_sio.comming.view.swing;

import com.duo_sio.comming.model.CashType;
import com.duo_sio.comming.model.StatusType;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {
    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (jtable.getColumnCount() == i1 + 1) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                if (o instanceof StatusType) {
                    StatusType type = (StatusType) o;
                    CellStatus cell = new CellStatus(type);
                    return cell;
                } else if(o instanceof CashType){ 
                    CashType type = (CashType) o;
                    CellCash cell = new CellCash(type);
                    return cell;
                }else {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                    com.setBackground(Color.WHITE);
                    setBorder(noFocusBorder);
                    if (selected) {
                        com.setForeground(new Color(15, 89, 140));
                    } else {
                        com.setForeground(new Color(102, 102, 102));
                    }
                    return com;
                }
            }
        });
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
    
    public void clearData() {
        DefaultTableModel model = (DefaultTableModel) getModel();
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
}
