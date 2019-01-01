package com.javacourse.user.applicant.status;

import com.javacourse.shared.service.Service;

public interface StatusService extends Service<Integer, Status> {
    Status getByApplicantId(int applicantId);
}
