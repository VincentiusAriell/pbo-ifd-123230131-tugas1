/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugassatu;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author M S I
 */
public class HomePage extends JFrame implements ItemListener{
    private JTextField namaD, namaB;
    private JComboBox<String> gender;
    private JTextArea displayArea;

    public HomePage() {
        setTitle("Input");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 5, 5));
        
         add(new JLabel("Nama Depan"));
        namaD = new JTextField();
        add(namaD);
        
        add(new JLabel("Nama Belakang"));
        namaB = new JTextField();
        add(namaB);
        
        add(new Label("Jenis Kelamin"));
        gender = new JComboBox<>(new String[] {"laki-laki", "perempuan", "kosongkan"});
        add(gender);
        
        JButton saveButton = new JButton("Simpan");
        saveButton.addActionListener(e -> save());
        add(saveButton);
        
        JButton exportButton = new JButton("Convert to .txt File");
        exportButton.addActionListener(e -> download());
        add(exportButton);
        
        displayArea = new JTextArea();
        displayArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);
        
        setVisible(true);
        
        
        
        
        
    }

    public void save() {
       String namaDepan = namaD.getText().trim();
       String namaBelakang= namaB.getText().trim();
       String gender = (String) this.gender.getSelectedItem();
       
        if (namaDepan.isEmpty() || namaBelakang.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "data tidak lengkap", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String file = namaDepan + "" + namaBelakang + "" + gender;
        displayArea.append(file);
    }
    
    
    public void download() {
      if (displayArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada data untuk disimpan!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
      
      try {
         
        String filePath = "C:\\Users\\M S I\\Documents\\PBO\\data.txt";
        FileWriter txt = new FileWriter(filePath, true); 
        displayArea.write(txt);  
        txt.close(); 
        JOptionPane.showMessageDialog(this, "Berhasil");
        
        } catch(IOException e){};
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       
    
}
