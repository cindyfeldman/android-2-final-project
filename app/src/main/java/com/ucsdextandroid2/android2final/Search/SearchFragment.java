package com.ucsdextandroid2.android2final.Search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ucsdextandroid2.android2final.Data.DataSources;
import com.ucsdextandroid2.android2final.Data.DatabaseChord;
import com.ucsdextandroid2.android2final.Data.Debouncer;
import com.ucsdextandroid2.android2final.Data.SongsterrChordItem;
import com.ucsdextandroid2.android2final.R;
import com.ucsdextandroid2.android2final.Saved.AppDatabase;

import java.util.Collections;
import java.util.Objects;

public class SearchFragment extends Fragment {

    private SearchAdapter<SongsterrChordItem> searchAdapter;
    private String latestSearchTerm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchAdapter = new SearchAdapter<SongsterrChordItem>();
        searchAdapter.setOnItemClickListener(new OnItemClickListener<SongsterrChordItem>() {
            @Override
            public void onItemClicked(SongsterrChordItem item) {
                AppDatabase.Companion.get(requireContext() ).chordDao().insertChord(item.toDatabaseChord());
                Toast.makeText(getContext(), "adding to favorites",Toast.LENGTH_SHORT);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentsearch, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.am_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(searchAdapter);


        EditText editText = view.findViewById(R.id.am_toolbar_edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                debouncer.onChange(s.toString());
            }
        });
    }

    private Debouncer<String> debouncer = Debouncer.create(200, new Debouncer.ChangeListener<String>() {
        @Override
        public void onChange(String item) {
            performSearch(item);
        }
    });

    private void performSearch(String term) {
        String trimmedTerm = term.trim();

        if(!Objects.equals(trimmedTerm, latestSearchTerm)) {
            latestSearchTerm = trimmedTerm;
            if(TextUtils.isEmpty(trimmedTerm)) {
                searchAdapter.submitList(Collections.emptyList());
            }
            else {
                DataSources.INSTANCE.search(trimmedTerm, data -> {
                    if(!TextUtils.isEmpty(latestSearchTerm))
                        searchAdapter.submitList(data);
                });
            }
        }
    }
}
