package com.example.xdhacks.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.xdhacks.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ListView list = (ListView) findViewById(R.id.list_items);
        EditText theFilter = (EditText) findViewById(R.id.search_bar);
        Log.d(TAG, "onCreate: Started.");

        ArrayList<String> names = new ArrayList<>();
        names.add("Mitch");
        names.add("Blake");
        names.add("Shelly");
        names.add("Jess");
        names.add("Steve");
        names.add("Mohammed");

        adapter = new ArrayAdapter(this, R.layout.list_item_layout, names);
        list.setAdapter(adapter);

        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (SearchActivity.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.navigation_add:
                        // have stuff here
                        break;

                    case R.id.navigation_profile:
                        Intent profileIntent = new Intent(SearchActivity.this, profile.class);
                        startActivity(profileIntent);
                        break;

                    case R.id.navigation_home:
                        Intent homeIntent = new Intent(SearchActivity.this, main.class);
                        startActivity(homeIntent);
                        break;
                }
                return true;
            }
        });
    }
}
