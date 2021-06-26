/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanresponsi;

import control.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Waffiq Aziz / 123190070
 */
public class Daerah {

  private String nama, status, statusZona, id;

  public void setDaerah(String nama, String status, String statusZona) {
    this.nama = nama;
    this.status = status;
    this.statusZona = statusZona;
  }

  public String getNama() {
    return nama;
  }

  public String getStatus() {
    return status;
  }

  public String getStatusZona() {
    return statusZona;
  }

  public String getId() {
    return id;
  }

  public void getData(String id) {
    MyConnection myConnection = new MyConnection();
    PreparedStatement ps;
    ResultSet rs;

    String query = "Select * from `data` WHERE idZona=?";

    try {
      ps = myConnection.getConnection().prepareStatement(query);
      ps.setString(1, id);
      rs = ps.executeQuery();

      if (rs.next()) {
        this.id = id;
        this.nama = rs.getString(2);
        this.status = rs.getString(3);
        this.statusZona = rs.getString(4);

        System.out.println(nama);
        System.out.println(status);
        System.out.println(statusZona);
      }

    } catch (SQLException ex) {
      System.out.println("Data tidak ditemukan");
      Logger.getLogger(Daerah.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void setStatus(String status) {
    if (status.equals("ODP")) {
      this.status = "ODP";
      this.statusZona = "Hijau";
    } else if (status.equals("PDP")) {
      this.status = "ODP";
      this.statusZona = "Hijau";
    } else{
      this.status = "Positif";
      this.statusZona = "Merah";
    }
  }
}
