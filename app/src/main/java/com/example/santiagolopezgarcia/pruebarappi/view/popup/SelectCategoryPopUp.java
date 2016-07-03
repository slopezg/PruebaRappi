package com.example.santiagolopezgarcia.pruebarappi.view.popup;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.santiagolopezgarcia.pruebarappi.R;
import com.example.santiagolopezgarcia.pruebarappi.model.Feed;
import com.example.santiagolopezgarcia.pruebarappi.view.IApplicationsView;
import com.example.santiagolopezgarcia.pruebarappi.view.adapters.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemSelected;

/**
 * Created by ronaldgallegoduque on 2/07/16.
 */
public class SelectCategoryPopUp extends android.support.v4.app.DialogFragment {

    @InjectView(R.id.spCategories)
    Spinner spCategories;
    private Feed feed;
    private IApplicationsView iApplicationsView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return initDialog();
    }

    @NonNull
    private Dialog initDialog() {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_categories);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ButterKnife.inject(this, dialog.getWindow().getDecorView());
        getParams();
        setData();
        return dialog;
    }

    private void getParams() {
        feed = (Feed) getArguments().getSerializable(Feed.class.getName());
    }

    private void setData() {
        if(getContext() instanceof IApplicationsView){
            iApplicationsView = (IApplicationsView) getContext();
        }
        List<String> categoryList = new ArrayList<String>(feed.getCategoryList());
        spCategories.setAdapter(new CategoryAdapter(getContext(), categoryList));
    }

    @OnItemSelected(R.id.spCategories)
    public void selectedCategory(AdapterView<?> adapterView, View view, int i, long l) {
        if(i > 0) {
            iApplicationsView.changeData(spCategories.getAdapter().getItem(i).toString());
            dismiss();
        }
    }

}
