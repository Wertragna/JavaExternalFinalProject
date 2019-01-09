package com.javacourse.user.applicant;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.user.User;
import com.javacourse.user.applicant.status.Status;
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
//todo add pagination
    @Override
    public List<Applicant> getBySpecialityIdAndPeriodIdWithUserEntity(int specialityID, int periodId) throws UnsuccessfulDAOException {
        List<Applicant> applicantSubjects = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement
                             ("select * from applicant inner join user on applicant.user = user.id inner join status on applicant.status = status.id where applicant.speciality =? and applicant.period=?")) {
            statement.setInt(1, specialityID);
            statement.setInt(2,periodId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                applicantSubjects.add(createApplicantWithUserEntity(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException(e.getMessage());
        }
        return applicantSubjects;
    }


    @Override
    public boolean updateList(List<Applicant> applicants) throws UnsuccessfulDAOException {
        int changeNumber = 0;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             "update applicant set status=? where id =?")) {
            for (Applicant a:applicants) {
                preparedStatement.setInt(1, a.getStatus());
                preparedStatement.setInt(2,a.getId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            changeNumber = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException(e.getMessage());
        }
        return changeNumber > 0;
    }

    //
    public List<Applicant> getBySpecialityIdAndPeriodId(int specialityID, int periodId) throws UnsuccessfulDAOException {
        List<Applicant> applicantSubjects = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from applicant where applicant.speciality =? and applicant.period=?")) {
            statement.setInt(1, specialityID);
            statement.setInt(2,periodId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                applicantSubjects.add(createApplicant(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException(e.getMessage());
        }
        return applicantSubjects;
    }

    private Applicant createApplicantWithUserEntity(ResultSet resultSet) throws SQLException {
        Applicant applicant = new Applicant();
        applicant.setPeriod(resultSet.getInt("applicant.period"));
        applicant.setStatus(resultSet.getInt("applicant.status"));
        applicant.setUser(resultSet.getInt("applicant.user"));
        applicant.setId(resultSet.getInt("applicant.id"));
        applicant.setRating(resultSet.getInt("applicant.rating"));
        int speciality = resultSet.getInt("applicant.speciality");
        User user = new User();
        user.setSurname( resultSet.getString("user.surname"));
        user.setRole(resultSet.getInt("user.role"));
        user.setFirstname(resultSet.getString("user.firstname"));
        user.setEmail(resultSet.getString("user.email"));
        user.setId(resultSet.getInt("user.id"));
        Status status = new Status();
        status.setName(resultSet.getString("status.name"));
        status.setId(resultSet.getInt("status.id"));
        if (!resultSet.wasNull())
            applicant.setSpeciality(speciality);
        applicant.setUserEntity(user);
        applicant.setStatusEntity(status);
        return applicant;
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
    public boolean updateRatingByApplicantId(int applicantId, Integer rating) throws UnsuccessfulDAOException {
        int changeNumber = 0;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             "update applicant set rating =? where id =?")) {
            preparedStatement.setObject(1, rating);
            preparedStatement.setInt(2, applicantId);
            changeNumber = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException(e.getMessage());
        }
        return changeNumber > 0;
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
    public int calculateRatingForSubjectSpeciality(int idApplicant, int idSpeciality) throws UnsuccessfulDAOException {
        int rating = 0;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             "select sum(applicant_subject.mark) " +
                                     "from applicant_subject " +
                                     "inner join subject_speciality " +
                                     "on subject_speciality.subject = applicant_subject.subject " +
                                     "where applicant=? and subject_speciality.speciality = ?")) {
            preparedStatement.setInt(1, idApplicant);
            preparedStatement.setInt(2, idSpeciality);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                rating = resultSet.getInt(1);
            } else
                throw new UnsuccessfulDAOException();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException(e.getMessage());
        }
        return rating;
    }

    @Override
    public boolean create(Applicant applicant) throws UnsuccessfulDAOException {
        int changeNumber = 0;
        try (PreparedStatement statement =
                     connection.prepareStatement
                             ("INSERT INTO applicant(user,period,status,rating,speciality) VALUE (?,?,?,?,?)")) {
            statement.setInt(1, applicant.getUser());
            statement.setInt(2, applicant.getPeriod());
            statement.setInt(3, applicant.getStatus());
            statement.setObject(4,applicant.getRating());
            statement.setObject(5,applicant.getSpeciality());
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
        applicant.setRating((Integer) resultSet.getObject("rating"));
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
