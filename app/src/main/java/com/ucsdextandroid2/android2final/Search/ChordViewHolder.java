package com.ucsdextandroid2.android2final.Search;

import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.ucsdextandroid2.android2final.ChordItemInterface;
import com.ucsdextandroid2.android2final.R;
import com.ucsdextandroid2.android2final.Data.SongsterrChordItem;

public class ChordViewHolder<T extends ChordItemInterface> extends RecyclerView.ViewHolder {
    private TextView hasTab;
    private TextView titleView;
    private TextView subtitleView;

    private T currentChordItem;
    private OnItemClickListener<T> clickListener;

    public static <T extends ChordItemInterface> ChordViewHolder<T> inflate(@NonNull ViewGroup parent) {
        return new ChordViewHolder<T>(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activitytabtetails, parent, false));
    }

    private ChordViewHolder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.myTitle);
        subtitleView = itemView.findViewById(R.id.subTitle);

        ImageView star = itemView.findViewById(R.id.imageButton);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickListener != null&& currentChordItem != null) {
                    clickListener.onItemClicked(currentChordItem);

                }
            }
        });
    }

    public void bind(T chordItem) {
        this.currentChordItem = chordItem;

        titleView.setText(chordItem.getChordTitle());
        subtitleView.setText( chordItem.getChordArtist());
    }

    public void setClickListener(OnItemClickListener<T> clickListener) {
        this.clickListener = clickListener;
    }
}
