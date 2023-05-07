package com.geekster.EmployeeAddress.repositories;

import com.geekster.EmployeeAddress.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends JpaRepository<Address,Long> {

}
