package com.javacourse.user.applicant;

import com.javacourse.user.applicant.period.Period;
import com.javacourse.user.applicant.status.Status;
import com.javacourse.speciality.Speciality;
import com.javacourse.user.User;

import java.util.Objects;

public class Applicant {
    private int id;
    private User user;
    private Period period;
    private Speciality speciality;
    private Status status;
    int rating;

    public Applicant(int id, User user, Period period, Speciality speciality, Status status, int rating) {
        this.id = id;
        this.user = user;
        this.period = period;
        this.speciality = speciality;
        this.status = status;
        this.rating = rating;
    }

    public Applicant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Applicant)) return false;
        Applicant applicant = (Applicant) o;
        return id == applicant.id &&
                rating == applicant.rating &&
                Objects.equals(user, applicant.user) &&
                Objects.equals(period, applicant.period) &&
                Objects.equals(speciality, applicant.speciality) &&
                Objects.equals(status, applicant.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, period, speciality, status, rating);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Applicant{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", period=").append(period);
        sb.append(", speciality=").append(speciality);
        sb.append(", status=").append(status);
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}
