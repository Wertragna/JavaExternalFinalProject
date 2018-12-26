package com.javacourse.user.applicant.period;

import com.javacourse.user.applicant.period.state.State;

import java.util.Objects;

public class Period {
    private int id;
    private String name;
    private int state;
    private State stateEntity;

    public Period(int id, String name, int state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public Period() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return id == period.id &&
                Objects.equals(name, period.name) &&
                state == period.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state);
    }

    @Override
    public String toString() {
        return "Period{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
