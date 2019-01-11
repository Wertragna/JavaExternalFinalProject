package com.javacourse.shared.service;

import com.javacourse.user.UserService;
import com.javacourse.user.applicant.ApplicantService;

public class ServiceLoader {
    public ApplicantService applicantService() {
        return new ApplicantService();
    }

    public UserService userService() {
        return new UserService();
    }
}
