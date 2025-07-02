package gui;

import db.Koneksi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class LihatBukuFrame extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public LihatBukuFrame() {
        setTitle("Daftar Buku");
        setSize(600, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        model.addColumn("ID");
        model.addColumn("Judul");
        model.addColumn("Pengarang");
        model.addColumn("Tahun");
        model.addColumn("Stok");

        loadData();
    }

    private void loadData() {
        try (Connection conn = Koneksi.getKoneksi()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM buku");

            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("judul"),
                    rs.getString("pengarang"),
                    rs.getInt("tahun"),
                    rs.getInt("stok")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data!");
        }
    }
}
