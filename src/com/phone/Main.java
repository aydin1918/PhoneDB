package com.phone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.phone.create.CreateRecord; // Podkluchaem packet! 

public class Main {
	
	private static Scanner in;
       
	public static void main(String[] argv) throws ClassNotFoundException {
	   System.out.println("Vvedite slovo: ");	
		in = new Scanner(System.in);
		String vvod = in.nextLine();
		 if (vvod.equals("info")) {
		        try {
		          	selectEmailFromTableByTel();
		            } catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	  }  /// Konec uslovnoqo operatora - INFO
         if (vvod.equals("nomer")) {
        	 NomerData input = new NomerData();
        	   System.out.println("Vvedite First Name: ");
        	     String firstname = in.nextLine();
        	     input.setFirstName(firstname);
        	   System.out.println("Vvedite Second Name: "); 
        	     String secondname = in.nextLine();
        	     input.setSecondName(secondname);
        	       try {
        	    	   NomerData.GetDataFromMobile();
 		            } catch (SQLException e) {
 			     System.out.println(e.getMessage());
 		   }
        }  /// Konec uslovnoqo operatora - Nomer
          if((vvod.equals("new")) || (vvod.equals("noviy"))) {
        	    CreateRecord inputData = new CreateRecord();
        	      System.out.println("Vvedite First Name: ");
        	        String firstname = in.nextLine();
        	        inputData.setFirstname(firstname);
        	      System.out.println("Vvedite Second Name: "); 
        	        String secondname = in.nextLine();
        	        inputData.setSecondname(secondname);
        	      System.out.println("Vvedite Home Number: "); 
        	        String homenumber = in.nextLine();
      	            inputData.setHomeNumber(homenumber);
      	          System.out.println("Vvedite Mobile Number: "); 
      	            String mobilenumber = in.nextLine();
  	                inputData.setMobileNumber(mobilenumber);
  	              System.out.println("Vvedite Email: "); 
  	                String email = in.nextLine();
	                inputData.setEmail(email);
	             try {
	            	    CreateRecord.InputData();
	 		         } catch (SQLException e) {
	 			     System.out.println(e.getMessage());
	 		   }
          }
	}

	private static void selectEmailFromTableByTel() throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement = null;
		  System.out.println("Vvedite nomer tel: ");
          String telNumber = in.nextLine();
		
		try {
			String selectSQL = "SELECT FIRST_NAME,SECOND_NAME,EMAIL FROM System.Phone WHERE TEL_NUMBER = ? OR MOB_NUMBER = ?";
			preparedStatement = ConnectOracle.getDBConnection().prepareStatement(selectSQL);
			 preparedStatement.setString(1, telNumber);
			 preparedStatement.setString(2, telNumber); 
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
               String firstname = rs.getString("FIRST_NAME");
               String secondname = rs.getString("SECOND_NAME");
			   String email = rs.getString("EMAIL");
                System.out.println("First name: " + firstname);
                System.out.println("Second name: " + secondname);
				System.out.println("email : " + email);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

		}

	} /// Konec function Select
}
