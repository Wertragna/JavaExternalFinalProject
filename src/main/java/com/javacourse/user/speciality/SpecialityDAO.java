package com.javacourse.user.speciality;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;

import java.util.List;

public interface SpecialityDAO extends AbstractDAO<Integer,Speciality>{
    List<Speciality> getAvailableByApplicantId(int id) throws UnsuccessfulDAOException;
    Speciality getByApplicantId(int id) throws UnsuccessfulDAOException;
}
