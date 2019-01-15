package com.javacourse.user.admin_command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.Applicant;
import com.javacourse.user.applicant.ApplicantService;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowStatisticBySpeciality implements ActionCommand {


    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        final int NUMBER_OF_APPLICANT_ON_PAGE = 6;
        ApplicantService serviceSql = new ApplicantService();
        int specialityId = Integer.parseInt(request.getParameter("speciality"));
        int page = Integer.parseInt(request.getParameter("page"));
        int periodId = Integer.parseInt(request.getParameter("id-period"));
        int numberOfApplicant = serviceSql.getNumberOfApplicantBySpecialityIdAndPeriodId(specialityId, periodId);
        int lastPage = getNumberOfPages(numberOfApplicant, NUMBER_OF_APPLICANT_ON_PAGE);
        if (page > lastPage||page<1) {
            return new Page("/admin/statistic?id-period="+periodId+"&speciality="+ specialityId+"&page=1").setDispatchType(Page.DispatchType.REDIRECT);
        }

        List<Applicant> applicants = serviceSql.getBySpecialityIdAndPeriodId(specialityId, periodId,NUMBER_OF_APPLICANT_ON_PAGE*(page-1),NUMBER_OF_APPLICANT_ON_PAGE);
        request.setAttribute("applicants", applicants);
        request.setAttribute("currentPage", page);

        request.setAttribute("lastPage", getNumberOfPages(numberOfApplicant, NUMBER_OF_APPLICANT_ON_PAGE));
        System.out.println(applicants);
        return new Page(PathPageManager.getProperty("page.statistics")).setDispatchType(Page.DispatchType.FORWARD);
    }

    int getNumberOfPages(int totalNumberOrLine, int numberOnPage) {
        if (totalNumberOrLine == 0)
            return 1;
        if (totalNumberOrLine % numberOnPage == 0)
            return totalNumberOrLine / numberOnPage;
        else
            return totalNumberOrLine / numberOnPage + 1;
    }

}
