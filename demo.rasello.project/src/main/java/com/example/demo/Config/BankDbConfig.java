package com.example.demo.Config;

import com.example.demo.Model.BankModel;
import com.example.demo.Model.BankModelDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Repository
public class BankDbConfig  {


   public void dbConnection()
    //public static void main(String[] args)
    {

        try {

        String myDriver = "org.postgresql.Driver";
        String myUrl = "jdbc:postgresql://localhost:5432/bank";
        Class.forName(myDriver);
        Connection connection = DriverManager.getConnection(myUrl, "postgres", "postgres");

        String query = "SELECT * FROM banks";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        //inserting a new  records
//        int rowsAdd = st.executeUpdate(
//                "insert into banks" +
//                        " (checkid, first_name, last_name,email,gender,bank_balance, country)"
//                        + "values"
//                        + "('205','Rs','sthaa','rab@gmail.com','female','INR','India')");
            boolean data;
        while ( data = rs.next()) {
            int checkid = rs.getInt("checkid");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String bank_balance = rs.getString("bank_balance");
            String country = rs.getString("country");
            System.out.format("%d, %s, %s, %s,%s,%s,%s,\n", checkid, first_name, last_name,email,gender,bank_balance,country);

        }
        connection.close();
    } catch (ClassNotFoundException | SQLException e) {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
        e.printStackTrace();
    }



    }


}
