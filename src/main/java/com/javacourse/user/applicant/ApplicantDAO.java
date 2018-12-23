package com.javacourse.user.applicant;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.user.User;
import com.javacourse.utils.DataBaseConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ApplicantDAO extends AbstractDAO<Integer,Applicant> {
    @Override
    public List<Applicant> getAll() throws UnsuccessfulDAOException {
        return null;
    }

    @Override
    public boolean update(Applicant v) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean create(Applicant applicant) throws UnsuccessfulDAOException {
        int changeNumber = 0;
        try (Connection con = DataBaseConnectionPool.getConnection();
             PreparedStatement statement =
                     con.prepareStatement
                             ("INSERT INTO applicant(user,period,status) VALUE (?,?,?)")) {
            statement.setInt(1, applicant.getUser().getId());
            statement.setInt(2,applicant.getPeriod().getId());
            statement.setInt(3, applicant.getStatus().getId());
            changeNumber = statement.executeUpdate();
        } catch (SQLException e) {
            // todo logging
            throw new UnsuccessfulDAOException();
        }
        return changeNumber > 0;
    }

    @Override
    public Applicant getById(Integer integer) throws UnsuccessfulDAOException {
        return null;
    }


    public int getByUserIdAndPeriod(User user, Integer period) throws UnsuccessfulDAOException {
        int id=-1;
        try (Connection con = DataBaseConnectionPool.getConnection();
             PreparedStatement statement = con.prepareStatement("select id from applicant where applicant.user=? and period=? ")) {
            statement.setInt(1, user.getId());
            statement.setInt(2, period);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            // todo logging
            throw new UnsuccessfulDAOException();
        }
        return id;
    }


}
