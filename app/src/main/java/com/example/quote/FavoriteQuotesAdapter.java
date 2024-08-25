package com.example.quote;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FavoriteQuotesAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> favoriteQuotes;

    public FavoriteQuotesAdapter(Context context, ArrayList<String> favoriteQuotes) {
        super(context, 0, favoriteQuotes);
        this.context = context;
        this.favoriteQuotes = favoriteQuotes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.favorite_quote_item, parent, false);
        }

        TextView quoteTextView = view.findViewById(R.id.quote_text_view);
        quoteTextView.setText(favoriteQuotes.get(position));

        return view;
    }
}