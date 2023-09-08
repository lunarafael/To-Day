package com.example.today;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<CategoryItem> {
    public CategoryAdapter(Context context, List<CategoryItem> categories) {
        super(context, 0, categories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obter o item atual da lista
        CategoryItem category = getItem(position);

        // Verifique se uma view está sendo reutilizada, caso contrário, inflamos uma nova
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_layout, parent, false);
        }

        // Encontre as Views no layout do card
        TextView categoryName = convertView.findViewById(R.id.categoryNameTextView);
        TextView categoryTotal = convertView.findViewById(R.id.categoryTotalTextView);

        // Configure as informações do card com base nos dados da categoria
        categoryName.setText(category.getCategoryName());
        categoryTotal.setText(String.valueOf(category.getTotalItems()));

        return convertView;
    }
}

