/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import latihanresponsi.Daerah;

/**
 *
 * @author Waffiq Aziz / 123190070
 */
public class Update {
   public boolean update(Daerah d){
    
    MyConnection myConnection = new MyConnection();
    PreparedStatement ps;    
    
    String query = "INSERT INTO `data`(`namaDaerah`, `status`, `statusZona`) VALUES (?,?,?)";
    
    try {
      ps = myConnection.getConnection().prepareStatement(query);
      ps.setString(1, d.getNama());
      ps.setString(2, d.getStatus());
      ps.setString(3, d.getStatusZona());

      // jika berhasil
      if (ps.executeUpdate() > 0) {        
        System.out.println("Input berhasil");
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
    return false;
  }
}
