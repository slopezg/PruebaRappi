package com.example.santiagolopezgarcia.pruebarappi.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.santiagolopezgarcia.pruebarappi.R;
import com.example.santiagolopezgarcia.pruebarappi.model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronaldgallegoduque on 2/07/16.
 */
public class CategoryAdapter extends ArrayAdapter<Category> {

    private Context context;
    private Category categoryInit;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        super(context, 0, categoryList);
        this.context = context;
        adicionarValorPorDefecto(categoryList);
    }

    private void adicionarValorPorDefecto(List<Category> categoryList) {
        categoryInit = new Category();
        categoryInit.getCategoryPropieties().setDescripitionCategory("Select Category");
        categoryList.add(0, categoryInit);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = getViewItem(position, convertView, parent);
        return convertView;
    }

    @NonNull
    private View getViewItem(int position, View convertView, ViewGroup parent) {
        CategoryViewHolder categoryViewHolder;
        final Category category = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_spinner, parent, false);
            categoryViewHolder = new CategoryViewHolder();
            categoryViewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            convertView.setTag(categoryViewHolder);
        } else {
            categoryViewHolder = (CategoryViewHolder) convertView.getTag();
        }
        categoryViewHolder.tvName.setText(category.getCategoryPropieties().getNameCategory());
        if (position == 0) {
            categoryViewHolder.tvName.setText("Category");
            categoryViewHolder.tvName.setTextColor(context.getResources().getColor(R.color.letter_spinner));
        } else {
                categoryViewHolder.tvName.setTextColor(context.getResources().getColor(R.color.black));
        }
        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = getViewItem(position, convertView, parent);
        return convertView;
    }

    public static class CategoryViewHolder {
        TextView tvName;
    }


}