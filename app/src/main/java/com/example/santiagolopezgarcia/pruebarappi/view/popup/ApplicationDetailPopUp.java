package com.example.santiagolopezgarcia.pruebarappi.view.popup;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.method.ScrollingMovementMethod;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.santiagolopezgarcia.pruebarappi.R;
import com.example.santiagolopezgarcia.pruebarappi.model.Application;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by ronaldgallegoduque on 2/07/16.
 */
public class ApplicationDetailPopUp extends DialogFragment {

    @InjectView(R.id.ivAppDetail)
    ImageView ivApp;
    @InjectView(R.id.tvCategory)
    TextView tvCategory;
    @InjectView(R.id.tvName)
    TextView tvName;
    @InjectView(R.id.tvPrice)
    TextView tvPrice;
    @InjectView(R.id.tvSummary)
    TextView tvSummary;
    @InjectView(R.id.tvArtist)
    TextView tvArtist;
    @InjectView(R.id.tvRights)
    TextView tvRights;
    private Application application;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return initDialog();
    }

    @NonNull
    private Dialog initDialog() {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_application_detail);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ButterKnife.inject(this, dialog.getWindow().getDecorView());
        getParams();
        setData();
        return dialog;
    }

    private void setData() {
        tvCategory.setText(application.getCategory().getCategoryPropieties().getNameCategory());
        tvName.setText(application.getName().getName());
        tvPrice.setText(application.getPrice().getDetailPrice().getAmount() + " " + application.getPrice().getDetailPrice().getCurrency());
        tvSummary.setText(application.getSummary().getDescription());
        tvSummary.setMovementMethod(new ScrollingMovementMethod());
        tvArtist.setText(application.getArtist().getNameArtist());
        tvRights.setText(application.getRights().getRightsDescription());
        Glide
                .with(getContext())
                .load(application.getListImages().get(2).getUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_loading)
                .error(R.mipmap.ic_error)
                .crossFade()
                .into(ivApp);

        setAnimation();
    }

    private void setAnimation() {
        ivApp.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.wobble));

    }

    private void getParams() {
        application = (Application) getArguments().getSerializable(Application.class.getName());
    }


}
