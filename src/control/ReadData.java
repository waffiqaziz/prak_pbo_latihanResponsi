/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import latihanresponsi.ShowEdit_GUI;

/**
 *
 * @author Waffiq Aziz / 123190070
 */
public class ReadData {

  public String[][] readAllData() {
    // untuk menghitung jumlah baris
    CountRow cr = new CountRow();

    // untuk menyimpan data
    String data[][] = new String[cr.countRow()][4];

    try {
      MyConnection myConnection = new MyConnection();
      PreparedStatement ps;
      ResultSet rs;

      String query = "Select * from `data`";
      ps = myConnection.getConnection().prepareStatement(query);
      rs = ps.executeQuery();

      int n = 0;
      while (rs.next()) { //konversi tabel ke string
        data[n][0] = rs.getString(1);
        data[n][1] = rs.getString(2);
        data[n][2] = rs.getString(3);
        data[n][3] = rs.getString(4);
        n++;
      }
      return data;
    } catch (SQLException ex) {
      System.out.println("Read Data Gagal");
      Logger.getLogger(ShowEdit_GUI.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }
}
