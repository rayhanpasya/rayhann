package restoran;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResepGUI extends JFrame {
    private JTextField txtNama, txtBahan, txtInstruksi, txtId;
    private ResepManager manager;

    public ResepGUI() {
        manager = new ResepManager();
        setTitle("Manajemen Resep Masakan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panelForm = new JPanel(new GridLayout(5, 2, 10, 10));
        panelForm.setBackground(new Color(230, 240, 250)); // Warna latar form

        // Input Form
        JLabel lblId = new JLabel("ID Resep:");
        txtId = new JTextField();
        JLabel lblNama = new JLabel("Nama Resep:");
        txtNama = new JTextField();
        JLabel lblBahan = new JLabel("Bahan:");
        txtBahan = new JTextField();
        JLabel lblInstruksi = new JLabel("Instruksi:");
        txtInstruksi = new JTextField();

        panelForm.add(lblId);
        panelForm.add(txtId);
        panelForm.add(lblNama);
        panelForm.add(txtNama);
        panelForm.add(lblBahan);
        panelForm.add(txtBahan);
        panelForm.add(lblInstruksi);
        panelForm.add(txtInstruksi);

        // Tombol
        JPanel panelButton = new JPanel(new GridLayout(1, 4, 10, 10));
        panelButton.setBackground(new Color(200, 220, 240)); // Warna latar tombol

        JButton btnTambah = new JButton("Tambah");
        btnTambah.setBackground(new Color(102, 205, 170));
        btnTambah.setForeground(Color.WHITE);

        JButton btnEdit = new JButton("Edit");
        btnEdit.setBackground(new Color(255, 140, 0));
        btnEdit.setForeground(Color.WHITE);

        JButton btnHapus = new JButton("Hapus");
        btnHapus.setBackground(new Color(178, 34, 34));
        btnHapus.setForeground(Color.WHITE);

        JButton btnClear = new JButton("Clear");
        btnClear.setBackground(new Color(70, 130, 180));
        btnClear.setForeground(Color.WHITE);

        panelButton.add(btnTambah);
        panelButton.add(btnEdit);
        panelButton.add(btnHapus);
        panelButton.add(btnClear);

        // Panel utama
        add(panelForm, BorderLayout.CENTER);
        add(panelButton, BorderLayout.SOUTH);

        // Listener Tombol
        btnTambah.addActionListener(e -> tambahResep());
        btnEdit.addActionListener(e -> editResep());
        btnHapus.addActionListener(e -> hapusResep());
        btnClear.addActionListener(e -> clearFields());
    }

    private void tambahResep() {
        String nama = txtNama.getText();
        String bahan = txtBahan.getText();
        String instruksi = txtInstruksi.getText();

        if (nama.isEmpty() || bahan.isEmpty() || instruksi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Resep berhasil ditambahkan!");
            clearFields();
        }
    }

    private void editResep() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nama = txtNama.getText();
            String bahan = txtBahan.getText();
            String instruksi = txtInstruksi.getText();

            if (nama.isEmpty() || bahan.isEmpty() || instruksi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Resep berhasil diubah!");
                clearFields();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hapusResep() {
        try {
            int id = Integer.parseInt(txtId.getText());
            manager.hapusResep(id);
            JOptionPane.showMessageDialog(this, "Resep berhasil dihapus!");
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtId.setText("");
        txtNama.setText("");
        txtBahan.setText("");
        txtInstruksi.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ResepGUI());
    }
}
