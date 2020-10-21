package com.example.demo.Controller;

import com.example.demo.Config.BankDbConfig;
import com.example.demo.Model.BankModel;
import com.example.demo.Services.BankServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    private BankServices bankServices;

    @GetMapping(value = "/banks")
    public List<BankModel> getAllData() {
        
        return bankServices.getAll();
    }


    @GetMapping(value ="/banks/{checkid}")

    public  BankModel getData(@PathVariable int checkid){
        return bankServices.getByID(checkid);
    }

     @PostMapping(value = "/banks/{checkid}")

    public  void  updateData(@PathVariable int checkid){
         bankServices.update(checkid);
 }

    @GetMapping(value = "/banksAdded")
    public void  getAddedData(BankModel bankModel) {

        bankServices.addNew(bankModel);
    }

}
