package com.example.demo.Services;

import com.example.demo.Model.BankModel;
import com.example.demo.Model.BankModelDetail;
import com.example.demo.Repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BankServices implements BankModelDetail {

    @Autowired
    protected BankRepo bankRepo;

    @Override
    public void addNew(BankModel bankModel) {
        bankRepo.addNew(bankModel);

    }

    @Override
    public BankModel getByID(int checkid) {
        return bankRepo.getByID(checkid);
    }

    @Override
    public void update(int checkid) {
        bankRepo.update(checkid);

    }

    @Override
    public List<BankModel> getAll() {

        return bankRepo.getAll();
    }
}
