package com.example.demo.Controller;

import com.example.demo.Model.BankModel;
import com.example.demo.Services.BankServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public  BankModel getDataById(@PathVariable int checkid){

        return bankServices.getByID(checkid);
    }

     @PostMapping(value = "/banks/{checkid}")
     public void updateData(@PathVariable int checkid) {
          bankServices.update(checkid);

//
//    public  void  updateData(@PathVariable int checkid){
//
//        bankServices.update(checkid);
 }

    @PostMapping(value = "/banksAdded")
    public void  getAddedData(@RequestBody BankModel bankModel) {

        bankServices.addNew(bankModel);
    }

}
