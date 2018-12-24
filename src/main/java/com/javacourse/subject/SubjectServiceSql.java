package com.javacourse.subject;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.service.AbstractServiceSql;
import org.apache.log4j.Logger;

import java.util.List;

public class SubjectServiceSql extends AbstractServiceSql<Integer, Subject> implements SubjectService<Integer> {
    private static final Logger logger = Logger.getLogger(SubjectServiceSql.class);

    public SubjectServiceSql() {
        super(SubjectDAOSql.class);
    }

    @Override
    public boolean addSubjectApplicant(Integer subject, Integer applicant) throws UnsuccessfulDAOException {
        //todo add implementation
        return false;
    }

    @Override
    public List<Subject> getByApplicantId(Integer applicantId) throws UnsuccessfulDAOException {
        //todo add implementation
        return null;
    }
}
