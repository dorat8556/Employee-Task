package com.doratias.employeeTask.service;

import com.doratias.employeeTask.model.Spouse;

/**
 * @author Dor Atias
 */

public interface SpouseService {

    Spouse createSpouse(Spouse spouse);

    void deleteSpouse(int sp_id);

    Spouse updateSpouse(int sp_id, Spouse spouse);

    Spouse getSpouseById(int sp_id);
}
