package com.javacourse.user.applicant;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.user.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicantDAOSql implements ApplicantDAO<Integer> {
    private static final Logger logger = Logger.getLogger(ApplicantDAOSql.class);
    private Connection connection;

    public ApplicantDAOSql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Applicant> getAll() throws UnsuccessfulDAOException {
        return null;
    }

    @Override
    public boolean update(Applicant entity) throws UnsuccessfulDAOException {
        int changeNumber = 0;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             "update applicant set speciality=?, status=?, rating =? where id =?")) {
            preparedStatement.setObject(1, entity.getSpeciality());
            preparedStatement.setInt(2, entity.getStatus());
            preparedStatement.setObject(3, entity.getRating());
            preparedStatement.setInt(4, entity.getId());
            changeNumber = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public boolean delete(Integer integer) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean updateApplicantSubjectMarks(ApplicantSubject applicantSubject) throws UnsuccessfulDAOException {
        int changeNumber = 0;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             "update applicant_subject set mark = ? where applicant = ? and subject=?")) {
            preparedStatement.setObject(1, applicantSubject.getMark());
            preparedStatement.setInt(2, applicantSubject.getApplicant());
            preparedStatement.setInt(3, applicantSubject.getSubject());
            changeNumber = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public boolean create(Applicant applicant) throws UnsuccessfulDAOException {
        int changeNumber = 0;
        try (PreparedStatement statement =
                     connection.prepareStatement
                             ("INSERT INTO applicant(user,period,status) VALUE (?,?,?)")) {
            statement.setInt(1, applicant.getUser());
            statement.setInt(2, applicant.getPeriod());
            statement.setInt(3, applicant.getStatus());
            changeNumber = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public List<ApplicantSubject> getByPeriodAndSubject(int period, int subject) throws UnsuccessfulDAOException {
        List<ApplicantSubject> applicantSubjects = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from applicant " +
                "inner join applicant_subject on applicant.id = applicant_subject.applicant where subject=? and period =?")) {
            statement.setInt(1, subject);
            statement.setInt(2, period);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                applicantSubjects.add(createApplicantSubject(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return applicantSubjects;
    }

    private ApplicantSubject createApplicantSubject(ResultSet resultSet) throws SQLException {
        ApplicantSubject applicantSubject = new ApplicantSubject();
        applicantSubject.setApplicant(resultSet.getInt("applicant"));
        int mark = resultSet.getInt("mark");
        if (!resultSet.wasNull())
            applicantSubject.setMark(mark);
        applicantSubject.setSubject(resultSet.getInt("subject"));
        return applicantSubject;
    }

    @Override
    public Applicant getById(Integer integer) throws UnsuccessfulDAOException {
        Applicant applicant = null;
        try (PreparedStatement statement = connection.prepareStatement("select * from applicant where id=?")) {
            statement.setInt(1, integer);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                applicant = createApplicant(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());

            throw new UnsuccessfulDAOException(e.getMessage());
        }
        return applicant;
    }

    private Applicant createApplicant(ResultSet resultSet) throws SQLException {
        Applicant applicant = new Applicant();
        applicant.setPeriod(resultSet.getInt("period"));
        applicant.setStatus(resultSet.getInt("status"));
        applicant.setUser(resultSet.getInt("user"));
        applicant.setId(resultSet.getInt("id"));
        int speciality = resultSet.getInt("speciality");
        if (!resultSet.wasNull())
            applicant.setSpeciality(speciality);
        return applicant;
    }


    public int getApplicantIdByUserIdAndPeriod(User user, Integer period) throws UnsuccessfulDAOException {
        int id = -1;
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "select id from applicant where applicant.user=? and period=? ")) {
            statement.setInt(1, user.getId());
            statement.setInt(2, period);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return id;
    }


}
