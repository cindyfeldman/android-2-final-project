package com.ucsdextandroid2.android2final.Search;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.ucsdextandroid2.android2final.Data.DatabaseChord;
import com.ucsdextandroid2.android2final.Data.SongsterrChordItem;
import com.ucsdextandroid2.android2final.R;

public class GuitarTabinfoviewholder extends RecyclerView.ViewHolder {

    private SongsterrChordItem currentChordItem ;
    private TextView titleView;
    private TextView artist;
    private ImageView star ;

    private OnItemClickListener<SongsterrChordItem> clickListener;

    public GuitarTabinfoviewholder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.myTitle);

        artist = itemView.findViewById(R.id.subTitle);

        star = itemView.findViewById(R.id.imageButton);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickListener != null&& currentChordItem != null) {
                    clickListener.onItemClicked(currentChordItem);
                }
            }
        });
    }

    public void bind(SongsterrChordItem chordItem) {
        this.currentChordItem = chordItem;
        titleView.setText(currentChordItem.getTitle());
        artist.setText(currentChordItem.getArtist().getName());
    }
}
