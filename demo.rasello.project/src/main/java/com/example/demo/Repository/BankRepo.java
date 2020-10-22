package com.example.demo.Repository;

import com.example.demo.Model.BankModel;
import com.example.demo.Model.BankModelDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BankRepo implements BankModelDetail  {


    @Autowired
   // private JdbcTemplate jdbcTemplate;
    private Connection connection;
   //private  List<BankModel bankModels ;
    @Override
    public void addNew(BankModel bankModel) {

        try {
            var sql = "INSERT INTO banks(checkid, first_name, last_name,email,gender,bank_balance, country) " +
                    "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, bankModel.getCheckid());
            st.setString(2,bankModel.getFirst_name());
            st.setString(3,bankModel.getLast_name());
            st.setString(4,bankModel.getEmail());
            st.setString(5,bankModel.getGender());
            st.setString(6,bankModel.getBank_balance());
            st.setString(7,bankModel.getCountry());




           boolean result = st.execute();
           // var sql = "INSERT INTO banks(checkid, first_name, last_name,email,gender,bank_balance, country) " +
              //      "VALUES ('205','Rs','sthaa','rab@gmail.com','female','INR','India')";
//            Object[] param = new Object[]{
//                    bankModel.getCheckid(), bankModel.getFirst_name(), bankModel.getLast_name(),
//                    bankModel.getEmail(), bankModel.getGender(), bankModel.getBank_balance(), bankModel.getCountry()};


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BankModel getByID(int checkid) {
        try {

            var sql = "SELECT * FROM banks WHERE checkid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
              ps.setInt(1, checkid);
            ResultSet result = ps.executeQuery();

            if (result.next()){
                int id = result.getInt("checkid");
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                String email = result.getString("email");
                String gender = result.getString("gender");
                String bank_balance = result.getString("bank_balance");
                String country = result.getString("country");

                BankModel bankModel = new BankModel();
                bankModel.setCheckid(id);
                bankModel.setFirst_name(first_name);
                bankModel.setLast_name(last_name);
                bankModel.setEmail(email);
                bankModel.setGender(gender);
                bankModel.setBank_balance(bank_balance);
                bankModel.setCountry(country);

                return  bankModel;

            }

//         return jdbcTemplate.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(BankModel.class));

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }


    @Override
    public void update(int checkid) {
try{
        //var sql = "Update banks set email ='rs@gmail.com' WHERE checkid =?";

    var sql  = "UPDATE banks SET email = ? WHERE checkid =? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1,checkid);
       pst.setString(2,"email");

        ResultSet result = pst.executeQuery();

        if(result.next() ){
            int id = result.getInt("checkid");
            String first_name = result.getString("first_name");
            String last_name = result.getString("last_name");
            String email = result.getString("email");
            String gender = result.getString("gender");
            String bank_balance = result.getString("bank_balance");
            String country = result.getString("country");

        BankModel bankModel = new BankModel();
            bankModel.setCheckid(id);
            bankModel.setFirst_name(first_name);
            bankModel.setLast_name(last_name);
            bankModel.setEmail(email);
            bankModel.setGender(gender);
            bankModel.setBank_balance(bank_balance);
            bankModel.setCountry(country);

//return bankModel;
        }

    }catch(SQLException e){
    e.printStackTrace();
    }

    }

    @Override
    public List<BankModel> getAll() {

        var sql = "SELECT * FROM banks";
        List<BankModel> getData = new ArrayList<BankModel>();

try{
    Statement st = connection.createStatement();
    ResultSet rs = st.executeQuery(sql);
    while (rs.next()) {
            int checkid = rs.getInt("checkid");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String bank_balance = rs.getString("bank_balance");
            String country = rs.getString("country");

            BankModel bankModel = new BankModel();
            bankModel.setCheckid(checkid);
        bankModel.setFirst_name(first_name);
        bankModel.setLast_name(last_name);
        bankModel.setEmail(email);
        bankModel.setGender(gender);
        bankModel.setBank_balance(bank_balance);
        bankModel.setCountry(country);


        getData.add(bankModel);
    }

}catch (SQLException e){
    e.printStackTrace();
    }

        return  getData;
}}
