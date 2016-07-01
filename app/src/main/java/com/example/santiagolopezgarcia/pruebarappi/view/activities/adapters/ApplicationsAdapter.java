package com.example.santiagolopezgarcia.pruebarappi.view.activities.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.santiagolopezgarcia.pruebarappi.R;
import com.example.santiagolopezgarcia.pruebarappi.model.Application;

import java.util.List;

/**
 * Created by ronaldgallegoduque on 30/06/16.
 */
public class ApplicationsAdapter extends RecyclerView.Adapter<ApplicationsAdapter.ListApplicationsAdapterViewHolder> {

    private Context context;
    private List<Application> applicationsList;
    private boolean viewGrid;

    public ApplicationsAdapter(Context context, List<Application> applicationsList, boolean viewGrid) {
        this.context = context;
        this.viewGrid = viewGrid;
        this.applicationsList = applicationsList;
    }

    @Override
    public ListApplicationsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView;
            rowView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_application_grid, parent, false);
         /*else {
            rowView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_elemento_horizontal, parent, false);
        }*/
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

    public class ListApplicationsAdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView tvApp;
        private ImageView ivApp;
        private Application application;

        public ListApplicationsAdapterViewHolder(View itemView) {
            super(itemView);
            tvApp = (TextView) itemView.findViewById(R.id.tvApp);
            ivApp = (ImageView) itemView.findViewById(R.id.ivApp);
        }

        public void setDataApplication(Application application) {
            this.application = application;
            tvApp.setText(application.getName().getName());
            Glide
                    .with(context)
                    .load(application.getListImages().get(1))
                    .centerCrop()
                    .crossFade()
                    .into(ivApp);

        }


    }

}

