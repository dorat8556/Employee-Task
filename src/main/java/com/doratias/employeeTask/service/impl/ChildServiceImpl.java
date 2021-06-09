package com.doratias.employeeTask.service.impl;

import com.doratias.employeeTask.model.Child;
import com.doratias.employeeTask.repository.ChildRepository;
import com.doratias.employeeTask.service.ChildService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dor Atias
 */
@Service
@AllArgsConstructor
public class ChildServiceImpl implements ChildService {
    private final ChildRepository childRepository;

    @Override
    public Child createChild(Child child) {
        return childRepository.save(child);
    }

    @Override
    public List<Child> createChildren(List<Child> childrenList) {
        return childrenList.stream().map(childRepository::save).collect(Collectors.toList());
    }

    @Override
    public void deleteChild(int ch_id) {
        childRepository.deleteById(ch_id);
    }

    @Override
    public Child updateChild(int ch_id, Child child) {
        Child oldChild = childRepository.getById(ch_id);
        oldChild.setAge(child.getAge());
        oldChild.setName(child.getName());
        return childRepository.save(oldChild);
    }

    @Override
    public Child getChildById(int ch_id) {
        return childRepository.getById(ch_id);
    }
}
