package com.geekster.EmployeeAddress.controllers;

import com.geekster.EmployeeAddress.models.Address;
import com.geekster.EmployeeAddress.models.Employee;
import com.geekster.EmployeeAddress.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping(value = "/multiple")
    public String insertAddress(@RequestBody List<Address> addresses){
        return addressService.saveAddress(addresses);
    }

    //    get all address data
    @GetMapping(value = "/all")
    public List<Address> getAllAddress(){
        return addressService.fetchAllAddress();
    }

    //    get specific address by their addressId
    @GetMapping(value = "/byId/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }


    //    delete based on addressId
    @DeleteMapping(value = "/byId/{id}")
    public void deleteAddressById(@PathVariable Long id){
        addressService.removeAddressById(id);
    }

    //    update state of address based on addressId
    @PutMapping(value = "/byId/{id}/zipCode/{zipCode}")
    public void updatePincodeById(@PathVariable Long id,@PathVariable String zipCode){
        addressService.updatePincodeById(id,zipCode);
    }

}
