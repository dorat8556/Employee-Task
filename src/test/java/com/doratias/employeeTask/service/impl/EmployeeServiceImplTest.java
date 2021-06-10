package com.doratias.employeeTask.service.impl;

import com.doratias.employeeTask.model.Address;
import com.doratias.employeeTask.model.Child;
import com.doratias.employeeTask.model.Employee;
import com.doratias.employeeTask.model.Spouse;
import com.doratias.employeeTask.repository.EmployeeRepository;
import com.doratias.employeeTask.service.AddressService;
import com.doratias.employeeTask.service.ChildService;
import com.doratias.employeeTask.service.SpouseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


/**
 * @author Dor Atias
 */
@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private AddressService addressService;

    @Mock
    private ChildService childService;

    @Mock
    private SpouseService spouseService;

    @Mock
    private Employee employee;

    @InjectMocks
    private EmployeeServiceImpl employeeService;


    @Test
    void createEmployee() {
        Spouse realSpouse = Spouse.builder()
                .id(1)
                .name("stam")
                .build();
        List<Address> addressList = new ArrayList<>();
        Address realAddress = Address.builder()
                .id(1)
                .city("Ashdod")
                .country("Israel")
                .build();
        addressList.add(realAddress);
        List<Child> childList = new ArrayList<>();
        Child realChild = Child.builder()
                .id(1)
                .name("Joe")
                .age(12)
                .build();
        childList.add(realChild);
        Employee realEmp = Employee.builder()
                .first_name("Dor")
                .last_name("Atias")
                .spouse(realSpouse)
                .addresses(addressList)
                .children(childList)
                .build();

        employeeService.createEmployee(realEmp);

        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).save(captor.capture());

        assertEquals("Dor", captor.getValue().getFirst_name());
        assertEquals("Atias", captor.getValue().getLast_name());
//        assertEquals(1, captor.getValue().getAddresses().get(0).getId());
//        assertEquals(1, captor.getValue().getChildren().get(0).getId());
//        assertEquals(1, captor.getValue().getSpouse().getId());
//        assertEquals("stam", captor.getValue().getSpouse().getName());

    }
}