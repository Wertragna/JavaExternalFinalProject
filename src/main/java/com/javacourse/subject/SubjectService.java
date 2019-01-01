package com.javacourse.subject;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.service.Service;

import java.util.List;

public interface SubjectService <K> extends Service<K,Subject> {
    boolean addSubjectApplicant(K subject, K applicant) throws UnsuccessfulDAOException;
    boolean deleteSubjectBySubjectIdAndApplicantId(int subject, int applicant);
    List<Subject> getByApplicantId(K applicantId);
}
