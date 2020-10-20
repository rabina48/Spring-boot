package com.example.demo.Model;

import java.util.List;

public interface BankModelDetail {

    void addNew(BankModel bankModel);
    void delete(int checkid);
    void update(BankModel bankModel);
    List<BankModel> getAll();


}
