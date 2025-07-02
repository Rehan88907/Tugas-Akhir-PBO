package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Aplikasi Perpustakaan");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnBuku = new JButton("Kelola Buku");
        JButton btnLihat = new JButton("Lihat Buku");
        JButton btnAnggota = new JButton("Kelola Anggota");

        btnBuku.addActionListener(e -> new BukuForm().setVisible(true));
        btnLihat.addActionListener(e -> new LihatBukuFrame().setVisible(true));
        btnAnggota.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Menu Anggota belum dibuat."));

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.add(btnBuku);
        panel.add(btnLihat);
        panel.add(btnAnggota);

        add(panel, BorderLayout.CENTER);
    }
}
