/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanresponsi;

import control.Edit;
import control.MyConnection;
import control.ReadData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Waffiq Aziz / 123190070
 */
public class EditForm_GUI {

  MyConnection myConnection = new MyConnection();
  Daerah d = new Daerah();

  //DEKLARASI KOMPONEN
  JFrame window = new JFrame("Edit Data");
  JLabel lEdit = new JLabel("Edit Daerah :");
  JLabel lNamaDaerah = new JLabel("Nama Daerah");
  JLabel lStatus = new JLabel("Status");

  ButtonGroup inputRB = new ButtonGroup();
  JRadioButton rODP = new JRadioButton("ODP");
  JRadioButton rPDP = new JRadioButton("PDP");
  JRadioButton rPositif = new JRadioButton("Positif");

  JButton btnEdit = new JButton("Edit");

  public EditForm_GUI(Daerah d) {
    window.setLayout(null);
    window.setSize(380, 280);
    window.setVisible(true);
    window.setLocationRelativeTo(null); // center
    window.setResizable(false);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan

//ADD COMPONENT
    window.add(lNamaDaerah);
    window.add(lStatus);
    window.add(lEdit);

    window.add(btnEdit);
    window.add(rODP);
    window.add(rPDP);
    window.add(rPositif);

    inputRB.add(rODP);
    inputRB.add(rPositif);
    inputRB.add(rPDP);

// SETT BOUNDS
// sett bounds(m,n,o,p) >>> (sumbu-x,sumbu-y,panjang komponen, tinggi komponen)
    btnEdit.setBounds(120, 175, 130, 30);
    lNamaDaerah.setBounds(0, 55, 370, 30);
    lNamaDaerah.setHorizontalAlignment(0);
    lEdit.setBounds(150, 25, 160, 30);

    lStatus.setBounds(165, 95, 130, 30);
    rODP.setBounds(100, 125, 50, 30);
    rPDP.setBounds(150, 125, 50, 30);
    rPositif.setBounds(200, 125, 70, 30);

    switch (d.getStatus()) {
      case "ODP":
        rODP.setSelected(true);
        break;
      case "PDP":
        rPDP.setSelected(true);
        break;
      default:
        rPositif.setSelected(true);
        break;
    }
    
    lNamaDaerah.setText(d.getNama());

    btnEdit.addActionListener((ActionEvent arg0) -> {
      Edit e = new Edit();
      
      if (rODP.isSelected()){
        d.setStatus("ODP");
      }else if(rPDP.isSelected()){
        d.setStatus("PDP");
      }else{
        d.setStatus("Positif");
      }
      
      if (e.edit(d)) {
        JOptionPane.showMessageDialog(null, "Edit Berhasil");
        window.dispose();
        new MainMenu_GUI();
      } else {
        JOptionPane.showMessageDialog(null, "Edit Gagal");
      }
    });
  }
}
