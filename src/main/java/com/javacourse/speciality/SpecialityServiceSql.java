package com.javacourse.speciality;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SpecialityServiceSql extends AbstractServiceSql<Integer,Speciality> implements SpecialityService {
    FactoryDAO factoryDAO;
    private  final Logger logger = Logger.getLogger(SpecialityServiceSql.class);
    public SpecialityServiceSql(){
        super(SpecialityDAOSql.class);
        factoryDAO= new FactoryDAOSql();
    }

    @Override
    public Speciality getByApplicantId(int id) {
        Speciality speciality = null;
        try(Connection connection = factoryDAO.createConnection()) {
            SpecialityDAO specialityDAO = factoryDAO.createSpecialityDAO(connection);
            speciality = specialityDAO.getByApplicantId(id);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return speciality;
    }

    @Override
    public List<Speciality> getAvailableSpecialitiesByApplicantId(int id) {
        List<Speciality> specialities = null;
        try(Connection connection = factoryDAO.createConnection()) {
            SpecialityDAO specialityDAO = factoryDAO.createSpecialityDAO(connection);
            specialities = specialityDAO.getAvailableByApplicantId(id);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return specialities;
    }
}
