package com.doratias.employeeTask.service.impl;

import com.doratias.employeeTask.model.Spouse;
import com.doratias.employeeTask.repository.SpouseRepository;
import com.doratias.employeeTask.service.SpouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Dor Atias
 */
@Service
@AllArgsConstructor
public class SpouseServiceImpl implements SpouseService {
    private final SpouseRepository spouseRepository;

    @Override
    public Spouse createSpouse(Spouse spouse) {
        return spouseRepository.save(spouse);
    }

    @Override
    public void deleteSpouse(int sp_id) {
        spouseRepository.deleteById(sp_id);
    }

    @Override
    public Spouse updateSpouse(int sp_id, Spouse spouse) {
        Spouse oldSpouse = spouseRepository.getById(sp_id);
        oldSpouse.setName(spouse.getName());
        return spouseRepository.save(oldSpouse);
    }

    @Override
    public Spouse getSpouseById(int sp_id) {
        return spouseRepository.getById(sp_id);
    }
}
