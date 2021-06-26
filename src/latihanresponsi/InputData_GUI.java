/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package latihanresponsi;

import control.MyConnection;
import control.Input;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Waffiq Aziz / 123190070
 */
public class InputData_GUI {
  MyConnection myConnection = new MyConnection();
  Input MyInput = new Input();
  Daerah d = new Daerah();
  
  //DEKLARASI KOMPONEN
  JFrame window = new JFrame("Input Data");
  JLabel lNamaDaerah = new JLabel("Nama Daerah");
  JLabel lStatus = new JLabel("Status");
  JTextField tfNamaDaerah = new JTextField(35);
  
  ButtonGroup inputRB = new ButtonGroup();
  JRadioButton rODP = new JRadioButton("ODP");
  JRadioButton rPDP = new JRadioButton("PDP");
  JRadioButton rPositif = new JRadioButton("Positif");
  
  JButton btnInput = new JButton("Input");
  JButton btnBatal = new JButton("Batal");
  
  Container container = new Container();
  
  public InputData_GUI(){
    window.setLayout(null);
    window.setSize(380, 280);
    window.setVisible(true);
    window.setLocationRelativeTo(null); // center
    window.setResizable(false);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan
    
//ADD COMPONENT
    window.add(lNamaDaerah);
    window.add(lStatus);
    window.add(tfNamaDaerah);
    
    window.add(btnBatal);
    window.add(btnInput);
    window.add(rODP);
    window.add(rPDP);
    window.add(rPositif);
    
    inputRB.add(rODP);
    inputRB.add(rPositif);
    inputRB.add(rPDP);
       
// SETT BOUNDS
// sett bounds(m,n,o,p) >>> (sumbu-x,sumbu-y,panjang komponen, tinggi komponen)
    btnInput.setBounds(190, 175, 80, 30);
    btnBatal.setBounds(90, 175, 80, 30);
    
    lNamaDaerah.setBounds(80, 35, 80, 30);
    tfNamaDaerah.setBounds(160, 35, 130, 30);
    
    lStatus.setBounds(165, 85, 130, 30);
    rODP.setBounds(100, 115, 50, 30);
    rPDP.setBounds(150, 115, 50, 30);
    rPositif.setBounds(200, 115, 70, 30);
    
    btnInput.addActionListener((ActionEvent arg0) -> {
      String nama = tfNamaDaerah.getText();
      
      if(rODP.isSelected()){
        d.setDaerah(nama, "ODP", "Hijau");
      }else if (rPDP.isSelected()) {
        d.setDaerah(nama, "PDP", "Hijau");
      }else if (rPositif.isSelected()) {
        d.setDaerah(nama, "Positif", "Merah");
      }
      
      if(MyInput.input(d)){
        window.dispose();
        new MainMenu_GUI();
        JOptionPane.showMessageDialog(null, "Input Berhasil");
      }else{
        JOptionPane.showMessageDialog(null, "Input Gagal");
      }
    });
    btnBatal.addActionListener((ActionEvent arg0) -> {
      window.dispose();
      new MainMenu_GUI();
    });
  }
}
