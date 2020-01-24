package com.example.xdhacks.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.xdhacks.Community;
import com.example.xdhacks.R;

import java.util.ArrayList;

public class NewRecipe extends AppCompatActivity {

    private ArrayList<String> listOfIngredientNames = new ArrayList<>();
    private ArrayList<String> listOfSteps = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapterForSteps;
    private EditText ingredientInput;
    private EditText stepInput;

    public Community community;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);

        Spinner preferences = findViewById(R.id.type_of_dish);
        String[] FoodPrefs = new String[]{"Vegan", "Vegetarian", "Carnivore"};
        // here get the string array of the users drinks
        ArrayAdapter<String> adaptercoffee = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, FoodPrefs);
        preferences.setAdapter(adaptercoffee);

        Button backButton = findViewById(R.id.back_arrow);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(NewRecipe.this, main.class);
                startActivity(backIntent);
            }
        });

        adapter = new ArrayAdapter<String>(this, R.layout.list_item_layout, listOfIngredientNames);


        ingredientInput = (EditText) findViewById(R.id.add_ingredients);

        Button btAdd = (Button) findViewById(R.id.add_button);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listV = (ListView) findViewById(R.id.ingredient_list);
                String newItem = ingredientInput.getText().toString();
                listOfIngredientNames.add(newItem);
                listV.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

        adapterForSteps = new ArrayAdapter<String>(this, R.layout.list_item_layout, listOfSteps);


        stepInput = (EditText) findViewById(R.id.add_steps);

        Button btAdd2 = (Button) findViewById(R.id.add_button2);
        btAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listV = (ListView) findViewById(R.id.step_list);
                String newItem = stepInput.getText().toString();
                listOfSteps.add(newItem);
                listV.setAdapter(adapterForSteps);
                adapterForSteps.notifyDataSetChanged();
            }
        });

    }
}

