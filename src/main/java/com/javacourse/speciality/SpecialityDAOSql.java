package com.javacourse.speciality;

import com.javacourse.exception.UnsuccessfulDAOException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialityDAOSql implements SpecialityDAO {
    private final Logger logger = Logger.getLogger(SpecialityDAOSql.class);
    Connection connection;

    public SpecialityDAOSql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Speciality> getAll() throws UnsuccessfulDAOException {
        List<Speciality> specialities = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from speciality")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                specialities.add(createSpeciality(resultSet));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException(e.getMessage());
        }
        return specialities;
    }

    @Override
    public boolean update(Speciality entity) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean create(Speciality entity) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public Speciality getByApplicantId(int id) throws UnsuccessfulDAOException {
        Speciality speciality = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from speciality inner join applicant on speciality.id = applicant.speciality  where applicant.id= ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                speciality = createSpeciality(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException(e.getMessage());
        }
        System.out.println(speciality);
        return speciality;
    }

    @Override
    public Speciality getById(Integer integer) throws UnsuccessfulDAOException {
        Speciality speciality = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from speciality where id=?")) {
            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
               speciality = createSpeciality(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException(e.getMessage());
        }
        return speciality;
    }

    @Override
    public List<Speciality> getAvailableByApplicantId(int id) throws UnsuccessfulDAOException {
        List<Speciality> specialities = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from speciality as x\n" +
                "where not exists(" +
                "    select * from subject_speciality as y" +
                "    where y.speciality = x.id and not exists(" +
                "       select* from applicant_subject as z" +
                "       where z.applicant = ? and y.subject = z.subject and z.mark is not null" +
                "    )" +
                ")"
        )) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                specialities.add(createSpeciality(resultSet));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException(e.getMessage());
        }
        return specialities;
    }

    private Speciality createSpeciality(ResultSet resultSet) throws SQLException {
        Speciality speciality = new Speciality();
        speciality.setId(resultSet.getInt("id"));
        speciality.setName(resultSet.getString("name"));
        return speciality;
    }
}
