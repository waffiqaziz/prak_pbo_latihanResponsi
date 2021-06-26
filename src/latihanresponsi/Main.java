/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package latihanresponsi;

import control.MyConnection;

/**
 *
 * @author Waffiq Aziz / 123190070
 */
public class Main {
  public static void main(String[] args) {
    MyConnection myConnection = new MyConnection();
    if(myConnection.getConnection() == null){
    }else{
      new MainMenu_GUI();
    }
  }
}
