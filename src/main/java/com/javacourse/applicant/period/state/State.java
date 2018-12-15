package com.javacourse.applicant.period.state;

public enum  State {
    CHOICE_SUBJECT("user"),
    CHECK_TEST(""),
    CHOICE_SPECIALITY(""),
    ENDED("");

    private int id;
    private String name;
    private State(String name){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
