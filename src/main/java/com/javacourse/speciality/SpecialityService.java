package com.javacourse.speciality;

import com.javacourse.shared.service.Service;

import java.util.List;

public interface SpecialityService extends Service<Integer,Speciality> {
    List<Speciality> getAvailableSpecialitiesByApplicantId(int id);
    Speciality getByApplicantId(int id);
}
