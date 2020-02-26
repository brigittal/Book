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

    DataAdapter(Context context, List<Word> phones) {
        this.words = phones;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.trans_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Word word = words.get(position);
        holder.wordoView.setText(word.getWordo());
        holder.wordtrView.setText(word.getWordtr());
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView wordoView, wordtrView;
        ViewHolder(View view){
            super(view);
            wordoView = view.findViewById(R.id.wordo);
            wordtrView = view.findViewById(R.id.wordtr);
        }
    }
}