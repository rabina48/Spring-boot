package com.example.demo.Repository;

import com.example.demo.Model.BankModel;
import com.example.demo.Model.BankModelDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static javax.swing.text.html.HTML.Tag.SELECT;


@Repository
public class BankRepo implements BankModelDetail  {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addNew(BankModel bankModel) {



        var sql = "INSERT INTO banks(checkid, first_name, last_name,email,gender,bank_balance, country) " +
                "VALUES ('205','Rs','sthaa','rab@gmail.com','female','INR','India')";
        Object[] param = new Object[] {
                bankModel.getCheckid(),bankModel.getFirst_name(),bankModel.getLast_name(),
                bankModel.getEmail(),bankModel.getGender(),bankModel.getBank_balance(),bankModel.getCountry()};


        jdbcTemplate.update(sql,param);


    }

    @Override
    public BankModel getByID(int checkid) {


        var sql = "SELECT * FROM banks WHERE checkid = 50";
        Object[] param = new Object[] {checkid};

         return jdbcTemplate.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(BankModel.class));

    }

    @Override
    public void update(int checkid) {

        var sql = "Update banks set email ='rs@gmail.com' WHERE id =25";
        Object[] param = new  Object[]{checkid};

        jdbcTemplate.update(sql,param);


    }

    @Override
    public List<BankModel> getAll() {

        var sql = "SELECT * FROM banks";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(BankModel.class));

    }
}
