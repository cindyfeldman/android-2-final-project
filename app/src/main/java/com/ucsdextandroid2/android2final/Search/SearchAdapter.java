package com.ucsdextandroid2.android2final.Search;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.ucsdextandroid2.android2final.Data.SongsterrChordItem;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<ChordViewHolder> {
private List<? extends SongsterrChordItem> items = new ArrayList<>();

private OnItemClickListener<SongsterrChordItem> onItemClickListener;
@NonNull
    @Override
    public ChordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    ChordViewHolder chordViewHolder = ChordViewHolder.inflate(parent);
    chordViewHolder.setClickListener(item -> {
        if(onItemClickListener != null)
            onItemClickListener.onItemClicked(item);

    });
    return chordViewHolder;
}
    public void submitList(@Nullable List<? extends SongsterrChordItem> list) {
        this.items = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener<SongsterrChordItem> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private SongsterrChordItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ChordViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

