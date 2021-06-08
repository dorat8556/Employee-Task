package com.doratias.employeeTask.service;

import com.doratias.employeeTask.model.Address;

/**
 * @author Dor Atias
 */

public interface AddressService {

    Address createAddress(Address address);

    void deleteAddress(int add_id);

    Address updateAddress(int add_id, Address address);

    Address getAddressById(int add_id);

}
