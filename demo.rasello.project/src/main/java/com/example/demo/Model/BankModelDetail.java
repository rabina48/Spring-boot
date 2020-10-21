package com.example.demo.Model;

import java.util.List;

public interface BankModelDetail {

    void addNew(BankModel bankModel);
    BankModel getByID(int checkid);
    void update(int checkid);
    List<BankModel> getAll();


}
