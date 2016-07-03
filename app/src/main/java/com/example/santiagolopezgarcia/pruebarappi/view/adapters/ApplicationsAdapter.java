package com.example.santiagolopezgarcia.pruebarappi.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.santiagolopezgarcia.pruebarappi.R;
import com.example.santiagolopezgarcia.pruebarappi.model.Application;
import com.example.santiagolopezgarcia.pruebarappi.view.IApplicationsView;

import java.util.List;

/**
 * Created by ronaldgallegoduque on 30/06/16.
 */
public class ApplicationsAdapter extends RecyclerView.Adapter<ApplicationsAdapter.ListApplicationsAdapterViewHolder> {

    private List<Application> applicationsList;
    private Context context;
    private boolean viewGrid;
    private IApplicationsView iApplicationsView;

    public ApplicationsAdapter(List<Application> applicationList, Context context, boolean viewGrid) {
        this.applicationsList = applicationList;
        this.context = context;
        this.viewGrid = viewGrid;
        if(context instanceof IApplicationsView){
            iApplicationsView = (IApplicationsView) context;
        }
    }

    @Override
    public ListApplicationsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView;
        if (viewGrid) {
            rowView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_application_grid, parent, false);
        } else {
            rowView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_application_list, parent, false);
        }
        return new ListApplicationsAdapterViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(ListApplicationsAdapterViewHolder holder, int position) {
        final Application application = applicationsList.get(position);
        holder.setDataApplication(application);
        holder.itemView.setTag(application);
    }

    @Override
    public int getItemCount() {
        return (null != applicationsList ? applicationsList.size() : 0);
    }

    public class ListApplicationsAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvApp;
        private ImageView ivApp;
        private Application application;

        public ListApplicationsAdapterViewHolder(View itemView) {
            super(itemView);
            tvApp = (TextView) itemView.findViewById(R.id.tvApp);
            ivApp = (ImageView) itemView.findViewById(R.id.ivApp);
            ivApp.setOnClickListener(this);
        }

        public void setDataApplication(Application application) {
            this.application = application;
            tvApp.setText(application.getName().getName());
            Glide
                    .with(context)
                    .load(application.getListImages().get(2).getUrl())
                    .centerCrop()
                    .crossFade()
                    .into(ivApp);


        }


        @Override
        public void onClick(View view) {
            view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.image_click));
            iApplicationsView.openApplicationDetail(application);
        }
    }

}

