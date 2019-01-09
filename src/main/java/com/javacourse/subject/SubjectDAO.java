package com.javacourse.subject;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.user.applicant.Applicant;
import com.javacourse.user.applicant.ApplicantSubject;

import java.util.List;

public interface SubjectDAO <K> extends AbstractDAO<K,Subject> {
    boolean addSubjectApplicant(K subject, K applicant) throws UnsuccessfulDAOException;
    List<ApplicantSubject> getByApplicantId(int applicantId) throws UnsuccessfulDAOException;
    boolean deleteSubjectBySubjectIdAndApplicantId(int subject, int applicant) throws UnsuccessfulDAOException;
    List<Subject> getSubjectsByApplicantId(int applicantId) throws  UnsuccessfulDAOException;
}
