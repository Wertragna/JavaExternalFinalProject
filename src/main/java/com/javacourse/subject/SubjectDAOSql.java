package com.javacourse.subject;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.utils.DataBaseConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOSql implements SubjectDAO<Integer> {
    private static final Logger logger = Logger.getLogger(SubjectDAOSql.class);
    Connection connection;

    public SubjectDAOSql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Subject> getAll() throws UnsuccessfulDAOException {
        List<Subject> subjects = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "select * from subject")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                subjects.add(createSubject(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return subjects;
    }

    @Override
    public boolean update(Subject entity) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean create(Subject entity) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public Subject getById(Integer integer) throws UnsuccessfulDAOException {
        return null;
    }

    @Override
    public List<Subject> getByApplicantId(Integer applicantId) throws UnsuccessfulDAOException {
        List<Subject> subjects = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "select name, id from subject " +
                                     "join applicant_subject on subject.id = applicant_subject.subject " +
                                     "where aplicant=?")) {
            statement.setInt(1, applicantId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                subjects.add(createSubject(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return subjects;
    }

    @Override
    public boolean deleteSubjectBySubjectIdAndApplicantId(int subject, int applicant) throws UnsuccessfulDAOException {
        int changeNumber = 0;
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "delete from applicant_subject where subject=? and aplicant=?")) {
            statement.setInt(1, subject);
            statement.setInt(2, applicant);
            changeNumber = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return changeNumber > 0;
    }

    private Subject createSubject(ResultSet resultSet) throws SQLException {
        Subject subject = new Subject();
        subject.setName(resultSet.getString("name"));
        subject.setId(resultSet.getInt("id"));
        return subject;
    }

    @Override
    public boolean addSubjectApplicant(Integer subject, Integer applicant) throws UnsuccessfulDAOException {
        int changeNumber = 0;
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "INSERT INTO applicant_subject(subject, aplicant) VALUE (?,?)")) {
            statement.setInt(1, subject);
            statement.setInt(2, applicant);
            changeNumber = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return changeNumber > 0;
    }
}
