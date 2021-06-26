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
public class Edit {
  public boolean edit(Daerah d){
    MyConnection myConnection = new MyConnection();
    PreparedStatement ps;    
    String statusZona;
    
    String query = "UPDATE `data` SET `status`=?,`statusZona`=? WHERE `idZona`=?";
    
    try {
      ps = myConnection.getConnection().prepareStatement(query);
      ps.setString(1, d.getStatus());
      ps.setString(2, d.getStatusZona());
      ps.setString(3, d.getId());
      int i = ps.executeUpdate();

      return i == 1; // jika success

    } catch (SQLException ex) {
      Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }
}
