package com.example.demo.Repository;

import com.example.demo.Config.BankDbConfig;
import com.example.demo.Model.BankModel;
import com.example.demo.Model.BankModelDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BankRepo implements BankModelDetail  {

    protected BankDbConfig bankDbConfig;




    @Override
    public void addNew(BankModel bankModel) {


    }

    @Override
    public void delete(int checkid) {
        if

    }

    @Override
    public void update(BankModel bankModel) {

    }

    @Override
    public List<BankModel> getAll() {
        return null;
    }
}
