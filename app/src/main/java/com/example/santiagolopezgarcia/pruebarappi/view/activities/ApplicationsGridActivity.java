package com.example.santiagolopezgarcia.pruebarappi.view.activities;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.santiagolopezgarcia.pruebarappi.helpers.util.DividerItemDecoration;
import com.example.santiagolopezgarcia.pruebarappi.R;
import com.example.santiagolopezgarcia.pruebarappi.model.Application;
import com.example.santiagolopezgarcia.pruebarappi.presenters.ApplicationsPresenter;
import com.example.santiagolopezgarcia.pruebarappi.view.IApplicationsView;
import com.example.santiagolopezgarcia.pruebarappi.view.adapters.ApplicationsAdapter;
import com.example.santiagolopezgarcia.pruebarappi.view.popup.ApplicationDetailPopUp;

import java.util.List;

import butterknife.InjectView;

public class ApplicationsGridActivity extends AppCompatActivity implements IApplicationsView {

    @InjectView(R.id.rvApplications)
    RecyclerView rvApplications;
    private ApplicationsPresenter applicationsPresenter;
    private boolean viewGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applications_activity);
        initActivity();
        if(viewGrid){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    public void initActivity() {
        viewGrid = getResources().getBoolean(R.bool.isTablet);
        applicationsPresenter = new ApplicationsPresenter(this);
        applicationsPresenter.init();
    }

    @Override
    public void loadApplications(final List<Application> applicationList) {
        rvApplications = (RecyclerView) findViewById(R.id.rvApplications);
        rvApplications.setAdapter(new ApplicationsAdapter(applicationList, this, viewGrid));
        if (getResources().getBoolean(R.bool.isTablet)) {
            StaggeredGridLayoutManager gridLayoutManager =
                    new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL);
            rvApplications.setLayoutManager(gridLayoutManager);
        }else{
            rvApplications.setLayoutManager(new LinearLayoutManager(this));
            RecyclerView.ItemDecoration itemDecoration = new
                    DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
            rvApplications.addItemDecoration(itemDecoration);
        }
    }

    @Override
    public void openApplicationDetail(Application application) {
        ApplicationDetailPopUp applicationDetailPopUp = new ApplicationDetailPopUp();
        Bundle args = new Bundle();
        args.putSerializable(Application.class.getName(), application);
        FragmentManager fragmentManager = getSupportFragmentManager();
        applicationDetailPopUp.setArguments(args);
        applicationDetailPopUp.show(fragmentManager, "");
    }
}
