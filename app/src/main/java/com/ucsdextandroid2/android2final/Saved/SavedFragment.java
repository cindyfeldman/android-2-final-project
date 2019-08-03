package com.ucsdextandroid2.android2final.Saved;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ucsdextandroid2.android2final.ChordItemInterface;
import com.ucsdextandroid2.android2final.Data.DatabaseChord;
import com.ucsdextandroid2.android2final.Data.SongsterrChordItem;
import com.ucsdextandroid2.android2final.R;
import com.ucsdextandroid2.android2final.Search.SearchAdapter;

import java.util.List;

public class SavedFragment extends Fragment {

    SearchAdapter<DatabaseChord> searchAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchAdapter = new SearchAdapter<DatabaseChord>();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentsaved, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.list_favs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(searchAdapter);

        AppDatabase.Companion.get(requireContext()).chordDao()
                .getAllChordsLiveData()
                .observe(getViewLifecycleOwner(), new Observer<List<DatabaseChord>>() {
                    @Override
                    public void onChanged(List<DatabaseChord> databaseChords) {
                        searchAdapter.submitList(databaseChords);
                    }
                });
    }
}
