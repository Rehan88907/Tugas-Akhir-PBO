package gui;

import db.Koneksi;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BukuForm extends JFrame {
    private JTextField tfJudul, tfPengarang, tfTahun, tfStok;
    private JButton btnSimpan;

    public BukuForm() {
        setTitle("Form Tambah Buku");
        setSize(300, 250);
        setLayout(new GridLayout(5, 2, 5, 5));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        tfJudul = new JTextField();
        tfPengarang = new JTextField();
        tfTahun = new JTextField();
        tfStok = new JTextField();
        btnSimpan = new JButton("Simpan");

        add(new JLabel("Judul"));
        add(tfJudul);
        add(new JLabel("Pengarang"));
        add(tfPengarang);
        add(new JLabel("Tahun"));
        add(tfTahun);
        add(new JLabel("Stok"));
        add(tfStok);
        add(new JLabel());
        add(btnSimpan);

        btnSimpan.addActionListener(e -> simpanBuku());
    }

    private void simpanBuku() {
        String judul = tfJudul.getText();
        String pengarang = tfPengarang.getText();
        int tahun = Integer.parseInt(tfTahun.getText());
        int stok = Integer.parseInt(tfStok.getText());

        try (Connection conn = Koneksi.getKoneksi()) {
            String sql = "INSERT INTO buku (judul, pengarang, tahun, stok) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, judul);
            ps.setString(2, pengarang);
            ps.setInt(3, tahun);
            ps.setInt(4, stok);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
            dispose();
        } catch (Exception ex) {
    ex.printStackTrace(); 
    JOptionPane.showMessageDialog(this, "Gagal menyimpan data!\n" + ex.getMessage());
}

        }
    }

