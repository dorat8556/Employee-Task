package com.doratias.employeeTask.service.impl;

import com.doratias.employeeTask.model.Address;
import com.doratias.employeeTask.repository.AddressRepository;
import com.doratias.employeeTask.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dor Atias
 */

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> createAddresses(List<Address> addresses) {
        return addresses.stream().map(addressRepository::save).collect(Collectors.toList());
    }

    @Override
    public void deleteAddress(int add_id) {
        addressRepository.deleteById(add_id);
    }

    @Override
    public Address updateAddress(int add_id, Address address) {
        Address oldAddress = addressRepository.getById(add_id);
        oldAddress.setCity(address.getCity());
        oldAddress.setCountry(address.getCountry());
        return addressRepository.save(oldAddress);
    }

    @Override
    public Address getAddressById(int add_id) {
        return addressRepository.getById(add_id);
    }
}
