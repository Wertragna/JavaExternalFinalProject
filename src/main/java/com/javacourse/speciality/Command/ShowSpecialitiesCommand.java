package com.javacourse.speciality.Command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.speciality.Speciality;
import com.javacourse.speciality.SpecialityService;
import com.javacourse.speciality.SpecialityServiceSql;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowSpecialitiesCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        SpecialityServiceSql service = new SpecialityServiceSql();
        List<Speciality> specialities = service.getAll();
        request.setAttribute("specialities",specialities);
        return new Page(PathPageManager.getProperty("page.specialities"),false);
    }
}
