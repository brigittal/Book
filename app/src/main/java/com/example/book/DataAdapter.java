package com.example.book;

import android.content.Context;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Word> words;

    DataAdapter(Context context, List<Word> words) {
        this.words = words;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.translate_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Word word = words.get(position);
        holder.original_wordView.setText(word.getOriginal_word());
        holder.translate_wordView.setText(word.getTranslate_word());
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView original_wordView, translate_wordView;
        ViewHolder(View view){
            super(view);
            original_wordView = view.findViewById(R.id.original_word);
            translate_wordView = view.findViewById(R.id.translate_word);
        }
    }
}