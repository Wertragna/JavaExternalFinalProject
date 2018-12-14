package com.javacourse.aplicant.period;

import java.util.Objects;

public class Period {
    int id;
    String name;

    public Period(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Period() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Period)) return false;
        Period period = (Period) o;
        return id == period.id &&
                Objects.equals(name, period.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Period{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
