/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanresponsi;

import control.ReadData;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Waffiq Aziz / 123190070
 */
public class ShowEdit_GUI {
  Daerah d = new Daerah();
  ReadData rd = new ReadData();
 
  //DEKLARASI KOMPONEN
  JFrame window = new JFrame("Lihat Data");
  JTable tabel;
  DefaultTableModel tableModel;
  JScrollPane scrollPane;
  Object namaKolom[] = {"ID", "Nama Daerah", "Status", "Status Zona"};
  JButton btnBack = new JButton("Kembali");
  JButton btnEdit = new JButton("Edit");
  
  JLabel lId = new JLabel("ID yang Akan di Edit : ");
  JLabel lHeader = new JLabel("Data Daerah");
  
  JTextField tfId = new JTextField(3);
  public ShowEdit_GUI() {
    window.setLayout(null);
    window.setSize(550, 520);
    window.setVisible(true);
    window.setLocationRelativeTo(null);
    window.setResizable(false);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan
    
    window.add(btnBack);
    window.add(btnEdit);
    window.add(tfId);
    window.add(lId);
    window.add(lHeader);
    
    // sett bounds(m,n,o,p) >>> (sumbu-x,sumbu-y,panjang komponen, tinggi komponen)
    btnBack.setBounds(0, 450, 80, 30);
    btnEdit.setBounds(235, 400, 70, 30);
    
    lHeader.setBounds(230, 5, 90, 30);
    lId.setBounds(215, 330, 120, 30);
    tfId.setBounds(250, 360, 40, 30);
    
    if(rd.readAllData() == null){
      JOptionPane.showMessageDialog(null, "Tidak Ada Data");
      tabel = new JTable(null, namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
    }else{
      tabel = new JTable(rd.readAllData(), namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
    }
    
    scrollPane = new JScrollPane(tabel);
    window.add(scrollPane);

    scrollPane.setBounds(20, 35, 500, 300);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    
// action listener
    btnBack.addActionListener((ActionEvent arg0) -> {
      window.dispose();
      new MainMenu_GUI();
    });
    btnEdit.addActionListener((ActionEvent arg0) -> {
      window.dispose();
      
      String id = tfId.getText();
      d.getData(id);
      new EditForm_GUI(d);
    });
  }  
}
