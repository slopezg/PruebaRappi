package com.example.santiagolopezgarcia.pruebarappi.view;

import com.example.santiagolopezgarcia.pruebarappi.model.Application;

import java.util.List;

/**
 * Created by ronaldgallegoduque on 30/06/16.
 */
public interface IApplicationsView{

    void loadApplications(final List<Application> applicationList);

    void openApplicationDetail(Application application);

}
