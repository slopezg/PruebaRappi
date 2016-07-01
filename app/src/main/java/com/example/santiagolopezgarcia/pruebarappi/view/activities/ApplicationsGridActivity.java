package com.example.santiagolopezgarcia.pruebarappi.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.santiagolopezgarcia.pruebarappi.R;
import com.example.santiagolopezgarcia.pruebarappi.model.Application;
import com.example.santiagolopezgarcia.pruebarappi.presenters.ApplicationsPresenter;
import com.example.santiagolopezgarcia.pruebarappi.view.IApplicationsView;
import com.example.santiagolopezgarcia.pruebarappi.view.activities.adapters.ApplicationsAdapter;

import java.util.List;

import butterknife.InjectView;

public class ApplicationsGridActivity extends AppCompatActivity implements IApplicationsView {

    @InjectView(R.id.rvApplications)
    RecyclerView rvApplications;
    private ApplicationsPresenter applicationsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applications_activity);
        initActivity();
    }

    public void initActivity() {
        applicationsPresenter = new ApplicationsPresenter(this);
        applicationsPresenter.init();
    }

    @Override
    public void loadApplications(final List<Application> applicationList) {
        rvApplications.setAdapter(new ApplicationsAdapter(this, applicationList, true));
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvApplications.setLayoutManager(gridLayoutManager);

    }
}
