package com.example.santiagolopezgarcia.pruebarappi.view.popup;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.santiagolopezgarcia.pruebarappi.R;

import butterknife.ButterKnife;

/**
 * Created by ronaldgallegoduque on 2/07/16.
 */
public class ApplicationDetailPopUp extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return initDialog();
    }

    @NonNull
    private Dialog initDialog() {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_application_detail);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ButterKnife.inject(this, dialog.getWindow().getDecorView());
        return dialog;
    }
}
