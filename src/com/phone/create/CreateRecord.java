package com.phone.create;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.phone.ConnectOracle;

public class CreateRecord {
    public CreateRecord(){
    	
    }  
        private static String firstname;
        public static String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		private static String secondname;
        public static String getSecondname() {
			return secondname;
		}
		public void setSecondname(String secondname) {
			this.secondname = secondname;
		}
		private static String homeNumber;
        public static String getHomeNumber() {
			return homeNumber;
		}
		public void setHomeNumber(String homeNumber) {
			this.homeNumber = homeNumber;
		}
		private static String mobileNumber;
        public static String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		private static String email;
       public static String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	public static void InputData() throws ClassNotFoundException, SQLException {
		     PreparedStatement preparedStatement = null;
		     try {
	 				String InsertSQL = "INSERT INTO System.Phone (FIRST_NAME,SECOND_NAME,TEL_NUMBER,MOB_NUMBER,EMAIL) VALUES (?,?,?,?,?)";
	 				preparedStatement = ConnectOracle.getDBConnection().prepareStatement(InsertSQL);
					  preparedStatement.setString(1, getFirstname());
					  preparedStatement.setString(2, getSecondname()); 
					  preparedStatement.setString(3, getHomeNumber());
					  preparedStatement.setString(4, getMobileNumber());
					  preparedStatement.setString(5, getEmail());
					   ResultSet rs = preparedStatement.executeQuery(); // Result set - MUST!
                         System.out.println("Record added!");
	 			} catch (SQLException e) {

	 				System.out.println(e.getMessage());

	 			} finally {

	 				if (preparedStatement != null) {
	 					preparedStatement.close();
	 				}
 
       }
     }
}
