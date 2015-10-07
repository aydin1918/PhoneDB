package com.phone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NomerData{
    public NomerData(){
    	  
    }
      private static String firstName;
	       public static String getFirstName() {
		       return firstName;
	        }
	       public void setFirstName(String firstName) {
		       this.firstName = firstName;
	        }
	  private static String secondName;
           public static String getSecondName() {
		       return secondName;
	        }
	       public void setSecondName(String secondName) {
		       this.secondName = secondName;
	        }
	public static void  GetDataFromMobile() throws ClassNotFoundException, SQLException{ //Polucheniye nomera po name
    	   PreparedStatement preparedStatement = null;
 		     
 		  try {
 				String selectSQL = "SELECT TEL_NUMBER,MOB_NUMBER FROM System.Phone WHERE FIRST_NAME = ? AND SECOND_NAME = ?";
 				preparedStatement = ConnectOracle.getDBConnection().prepareStatement(selectSQL);
				  preparedStatement.setString(1, getFirstName());
				  preparedStatement.setString(2, getSecondName()); 
 				ResultSet rs = preparedStatement.executeQuery();

 				while (rs.next()) {
 	               String tel_number = rs.getString("TEL_NUMBER");
 	               String mob_number = rs.getString("MOB_NUMBER");
 	                System.out.println("Home number: " + tel_number);
 	                System.out.println("Mobile number: " + mob_number);
 				}

 			} catch (SQLException e) {

 				System.out.println(e.getMessage());

 			} finally {

 				if (preparedStatement != null) {
 					preparedStatement.close();
 				}

 			}
       }
}
