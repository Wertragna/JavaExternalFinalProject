package com.javacourse.subject;

import com.javacourse.exception.UnsuccessfulDAOException;

import java.util.List;

public interface SubjectService <K>{
    boolean addSubjectApplicant(K subject, K applicant) throws UnsuccessfulDAOException;
    List<Subject> getByApplicantId(K applicantId) throws UnsuccessfulDAOException;
}
