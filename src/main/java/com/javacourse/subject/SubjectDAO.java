package com.javacourse.subject;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.utils.DataBaseConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO extends AbstractDAO<Integer, Subject> {
    public SubjectDAO() {
    }

    @Override
    public List<Subject> getAll() throws UnsuccessfulDAOException {
        List<Subject> subjects = new ArrayList<>();
        try (Connection con = DataBaseConnectionPool.getConnection();
             PreparedStatement statement = con.prepareStatement("select *from subject")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                subjects.add(createSubject(resultSet));
            }
        } catch (SQLException e) {
            // todo loging
            throw new UnsuccessfulDAOException();
        }
        return subjects;
    }

    public List<Subject> getByApplicantId(int applicantId) throws UnsuccessfulDAOException {
        List<Subject> subjects = new ArrayList<>();
        try (Connection con = DataBaseConnectionPool.getConnection();
             PreparedStatement statement = con.prepareStatement("select name, id from subject join applicant_subject on subject.id = applicant_subject.subject where aplicant=?")) {
            statement.setInt(1, applicantId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                subjects.add(createSubject(resultSet));
            }
        } catch (SQLException e) {
            // todo loging
            throw new UnsuccessfulDAOException();
        }
        return subjects;
    }

    private Subject createSubject(ResultSet resultSet) throws SQLException {
        Subject subject = new Subject();
        subject.setName(resultSet.getString("name"));
        subject.setId(resultSet.getInt("id"));
        return subject;
    }

    @Override
    public boolean update(Subject v) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean create(Subject v) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public Subject getById(Integer integer) throws UnsuccessfulDAOException {
        return null;
    }


    public boolean addSubjectApplicant(int subject, int applicant) throws UnsuccessfulDAOException {
        int changeNumber = 0;
        try (Connection con = DataBaseConnectionPool.getConnection();
             PreparedStatement statement = con.prepareStatement("INSERT INTO applicant_subject(subject, aplicant) VALUE (?,?)")) {
            statement.setInt(1, subject);
            statement.setInt(2, applicant);
            changeNumber = statement.executeUpdate();
        } catch (SQLException e) {
            // todo logging
            throw new UnsuccessfulDAOException();
        }
        return changeNumber > 0;
    }
}
