package com.ucsdextandroid2.android2final.Search;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.ucsdextandroid2.android2final.ChordItemInterface;
import com.ucsdextandroid2.android2final.Data.SongsterrChordItem;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter<T extends ChordItemInterface> extends RecyclerView.Adapter<ChordViewHolder<T>> {

    private List<T> items = new ArrayList<>();

    private OnItemClickListener<T> onItemClickListener;

    @NonNull
    @Override
    public ChordViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ChordViewHolder<T> chordViewHolder = ChordViewHolder.inflate(parent);
        chordViewHolder.setClickListener(item -> {
            if (onItemClickListener != null)
                onItemClickListener.onItemClicked(item);

        });
        return chordViewHolder;
    }

    public void submitList(@Nullable List<T> list) {
        this.items = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private T getItem(int position) {
        return items.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ChordViewHolder<T> holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

