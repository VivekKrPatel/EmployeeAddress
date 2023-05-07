package com.geekster.EmployeeAddress.services;

import com.geekster.EmployeeAddress.models.Address;
import com.geekster.EmployeeAddress.models.Employee;
import com.geekster.EmployeeAddress.repositories.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    IAddressRepo iAddressRepo;

    public String saveAddress(List<Address> addresses) {
        Iterable<Address> added = iAddressRepo.saveAll(addresses);

        if(added != null){
            return "Added succesfully...";
        }
        return "Failed...";
    }

    public List<Address> fetchAllAddress() {
        return iAddressRepo.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return iAddressRepo.findById(id);
    }

    public void removeAddressById(Long id) {
        iAddressRepo.deleteById(id);
    }

    public void updatePincodeById(Long id, String zipCode) {
        Optional<Address> findAddress = iAddressRepo.findById(id);
        Address myAddress = findAddress.get();
        myAddress.setZipCode(zipCode);
        iAddressRepo.save(myAddress);
    }
}
