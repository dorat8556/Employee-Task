package com.doratias.employeeTask.service;

import com.doratias.employeeTask.model.Child;

import java.util.List;

/**
 * @author Dor Atias
 */

public interface ChildService {
    Child createChild(Child child);

    List<Child> createChildren(List<Child> childSet);

    void deleteChild(int ch_id);

    Child updateChild(int ch_id, Child child);

    Child getChildById(int ch_id);
}
