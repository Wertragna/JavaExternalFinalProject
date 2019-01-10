package com.javacourse.user.applicant.applicant_command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.speciality.Speciality;
import com.javacourse.user.speciality.SpecialityService;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowSpecialitiesCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        SpecialityService service = new SpecialityService();
        List<Speciality> specialities = service.getAll();
        request.setAttribute("specialities",specialities);
        return new Page(PathPageManager.getProperty("page.specialities")).setDispatchType(Page.DispatchType.FORWARD);
    }
}
