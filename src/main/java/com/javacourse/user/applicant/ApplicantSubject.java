package com.javacourse.user.applicant;

import com.javacourse.subject.Subject;

import java.util.Objects;

public class ApplicantSubject {
    private int applicant;
    private int subject;
    private Subject SubjectEntity;
    private Integer mark;

    public ApplicantSubject() {
    }

    public Subject getSubjectEntity() {
        return SubjectEntity;
    }

    public void setSubjectEntity(Subject subjectEntity) {
        SubjectEntity = subjectEntity;
    }

    public int getApplicant() {
        return applicant;
    }

    public void setApplicant(int applicant) {
        this.applicant = applicant;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicantSubject that = (ApplicantSubject) o;
        return applicant == that.applicant &&
                subject == that.subject &&
                mark == that.mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicant, subject, mark);
    }

    @Override
    public String toString() {
        return "ApplicantSubject{" +
                "applicant=" + applicant +
                ", subject=" + subject +
                ", mark=" + mark +
                '}';
    }
}
