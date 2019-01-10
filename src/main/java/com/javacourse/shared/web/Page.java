package com.javacourse.shared.web;

import java.util.Objects;

public class Page {
    String name;
    private boolean isRedirect;

    private DispatchType dispatchType;

    public Page(String name) {
        this.name = name;
    }

    public DispatchType getDispatchType() {
        return dispatchType;
    }

    public Page setDispatchType(DispatchType dispatchType) {
        this.dispatchType = dispatchType;
        return this;
    }

    public String getName() {
        return name;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return isRedirect == page.isRedirect &&
                Objects.equals(name, page.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isRedirect);
    }


    public enum DispatchType {FORWARD, REDIRECT}

    public enum WebPath {
        HOME(""),
        SIGN_IN("/login/sign-in"),
        SIGN_UP("/login/sign-up"),
        APPLICANT_PERIOD("/period"),
        APPLICANT_INFO("/applicant/info"),
        APPLICANT_SUBJECT("/applicant/choose-subjects"),
        APPLICANT_SPECIALITY("/applicant/choose-speciality"),
        ADMIN_CREATE_NEW_PERIOD("/admin/create-new-period"),
        ADMIN_PERIOD("/admin/periods"),
        ADMIN_PERIOD_INFO("/admin/period-info"),
        ADMIN_PERIOD_EDIT("/admin/period-edit"),
        ADMIN_PERIOD_MARK("/admin/period-mark");
        private final String path;

        WebPath(String path) {
            this.path = path;
        }
        }


}
