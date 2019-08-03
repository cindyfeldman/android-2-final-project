package com.ucsdextandroid2.android2final.Search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ucsdextandroid2.android2final.R;
import com.ucsdextandroid2.android2final.Data.DataSources;
import com.ucsdextandroid2.android2final.Data.Debouncer;

import java.util.Collections;
import java.util.Objects;


public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysearch);
        setUpBottomNavBar();

    }
        private void setUpBottomNavBar() {
            BottomNavigationView bottomNavigationView = findViewById(R.id.ai_bottom_nav_view);

            NavController navController = Navigation
                    .findNavController(this, R.id.activity_search_nav_controller);

            NavigationUI.setupWithNavController(bottomNavigationView, navController);


            //findNavController from host id
        }

}
