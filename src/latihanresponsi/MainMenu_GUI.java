/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanresponsi;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Waffiq Aziz
 */
public class MainMenu_GUI extends JFrame{

  //DEKLARASI KOMPONEN
  JFrame window = new JFrame("Main Menu");

  JButton btnInput = new JButton("Input Data");
  JButton btnShow = new JButton("Show & Edit Data");
  
  JLabel lTitle1 = new JLabel("Program Pendataan Daerah");
  JLabel lTitle2 = new JLabel("Terdampak Covid");
  
  public MainMenu_GUI(){
    window.setLayout(null);
    window.setSize(380, 230);
    window.setVisible(true);
    window.setLocationRelativeTo(null); // center
    window.setResizable(false);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan
    
//ADD COMPONENT
    window.add(btnInput);
    window.add(btnShow);
    window.add(lTitle1);
    window.add(lTitle2);
    
// SETT BOUNDS
// sett bounds(m,n,o,p) >>> (sumbu-x,sumbu-y,panjang komponen, tinggi komponen)
    lTitle1.setBounds(100, 5, 200, 30);
    lTitle2.setBounds(135, 35, 130, 30);
    
    btnInput.setBounds(120, 75, 130, 30);
    btnShow.setBounds(110, 125, 150, 30);
    
// ACTION LISTENER
    btnInput.addActionListener((ActionEvent arg0) -> {
      window.dispose();
      new InputData_GUI();
    });
    btnShow.addActionListener((ActionEvent arg0) -> {
      window.dispose();
      new ShowEdit_GUI();
    });
  }
}
