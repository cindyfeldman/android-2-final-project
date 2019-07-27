package com.ucsdextandroid2.android2final.Search;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.ucsdextandroid2.android2final.R;
import com.ucsdextandroid2.android2final.Data.SongsterrChordItem;

public class ChordViewHolder extends RecyclerView.ViewHolder {
private TextView hasTab;
private TextView titleView;
private TextView subtitleView;

private SongsterrChordItem currentChordItem ;
private OnItemClickListener<SongsterrChordItem> clickListener;
public static ChordViewHolder inflate(@NonNull ViewGroup parent) {
    return new ChordViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.activitytabtetails, parent, false));
}
private ChordViewHolder(@NonNull View itemView) {
    super(itemView);
  titleView = itemView.findViewById(R.id.myTitle);
subtitleView = itemView.findViewById(R.id.subTitle);

itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
if(clickListener != null && currentChordItem != null)
    clickListener.onItemClicked(currentChordItem);

    }
});
}
    public void bind(SongsterrChordItem chordItem) {
    this.currentChordItem = chordItem;

    titleView.setText(chordItem.getTitle());
    subtitleView.setText(String.format("%s • %s", chordItem.getArtist(), chordItem.getChordsPresent()));
    }
    public void setClickListener(OnItemClickListener<SongsterrChordItem> clickListener) {
        this.clickListener = clickListener;
    }
}
