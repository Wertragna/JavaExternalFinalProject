package com.javacourse.user.subject;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.user.applicant.ApplicantSubject;

import java.util.List;
/**
 * Basic interface used for implementing FactoryDAO for switching easily
 */
public interface SubjectDAO  extends AbstractDAO<Integer,Subject> {
    boolean addSubjectApplicant(int subject, int applicant) throws UnsuccessfulDAOException;
    List<ApplicantSubject> getByApplicantId(int applicantId) throws UnsuccessfulDAOException;
    boolean deleteSubjectBySubjectIdAndApplicantId(int subject, int applicant) throws UnsuccessfulDAOException;
    List<Subject> getSubjectsByApplicantId(int applicantId) throws  UnsuccessfulDAOException;
}
