package com.example.xdhacks.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.xdhacks.Community;
import com.example.xdhacks.R;

import java.util.ArrayList;
import java.util.List;

public class main<firstStep1, chicken, potatoes> extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> trendingNames = new ArrayList<>();
    private ArrayList<String> trendingImageUrls = new ArrayList<>();
    private ArrayList<String> mNames2 = new ArrayList<>();
    private ArrayList<String> mImageUrls2 = new ArrayList<>();
    private ArrayList<String> mNames3 = new ArrayList<>();
    private ArrayList<String> mImageUrls3 = new ArrayList<>();

    public Community community = new Community();
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button filterButton = findViewById(R.id.filter);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilterActivity();
            }
        });

        Button searchButton = findViewById(R.id.search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchActivity();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.navigation_add:
                        Intent addIntent = new Intent(main.this, NewRecipe.class);
                        startActivity(addIntent);
                        break;

                    case R.id.navigation_profile:
                        Intent profileIntent = new Intent(main.this, profile.class);
                        startActivity(profileIntent);
                        break;

                    case R.id.navigation_home:
                        Intent homeIntent = new Intent(main.this, main.class);
                        startActivity(homeIntent);
                        break;
                }
                return true;
            }
        });

        getImages();

        Recipe recipe1 = new Recipe("Roast Chicken and Vegtables",null,"This is a really simple recipe by me to decrease cholestrol " +
                "content while having a healthy dose of protein",this.user);
        Ingredient chicken = new Ingredient("3 chicken breasts",300);
        Ingredient potatoes = new Ingredient("half a pound of potatoes",300);
        Ingredient onion = new Ingredient("3 onions",50);
        Ingredient salt = new Ingredient("2 teaspoons of salt",0);

        String firstStep = "Put it in the cooker";
        String secondStep = "Let it cook for 2 hours till the chicken is brown";
        String thirdStep = "Add potatoes";
        String fourthStep = "Enjoy!";
        List<String> steps = new ArrayList<>();
        steps.add(firstStep);
        steps.add(secondStep);
        steps.add(thirdStep);
        steps.add(fourthStep);
        for(int i = 0; i < steps.size(); i++) {
            recipe1.addSteps(steps.get(i));
        }

        Recipe recipe2 = new Recipe("Antipasti Penne",null,"",this.user);
        Ingredient penne = new Ingredient("12 ounces of penne pasta",400);
        Ingredient artichokes = new Ingredient("artichoke hearts",100);
        recipe2.ingredients.add(penne);
        recipe2.ingredients.add(artichokes);
        recipe2.ingredients.add(onion);
        recipe2.ingredients.add(salt);
        String firstStep1 = "Put pasta is the boiler";
        String secondStep2 = "Add the onions and the salt";
        String thirdStep3 = "";
        String fourthStep4 = "Enjoy!";
        List<String> steps1 = new ArrayList<>();
        steps1.add(firstStep1);
        steps1.add(secondStep2);
        steps1.add(thirdStep3);
        steps1.add(fourthStep4);
        for(int i = 0; i < steps.size(); i++) {
            recipe2.addSteps(steps.get(i));
        }

        Recipe  recipe3 = new Recipe("Tofu Stirfry",null,"",this.user);
        Ingredient tofu = new Ingredient("1 pound of tofu",400);
        Ingredient tofuSauce = new Ingredient("",100);
        recipe3.ingredients.add(penne);
        recipe3.ingredients.add(artichokes);
        recipe3.ingredients.add(onion);
        recipe3.ingredients.add(salt);
        String firstStep2 = "Put pasta is the boiler";
        String secondStep3 = "Add the onions and the salt";
        String thirdStep4 = "";
        String fourthStep5 = "Enjoy!";
        List<String> steps2 = new ArrayList<>();
        steps2.add(firstStep2);
        steps2.add(secondStep3);
        steps2.add(thirdStep4);
        steps2.add(fourthStep5);
        for(int i = 0; i < steps.size(); i++) {
            recipe2.addSteps(steps2.get(i));
        }
        Community.allRecipes.add(recipe1);
        Community.allRecipes.add(recipe2);
        Community.allRecipes.add(recipe3);
    }

    public void openFilterActivity() {
        Intent filterIntent = new Intent(main.this, FilterActivity.class);
        startActivity(filterIntent);
}

    public void openSearchActivity() {
        Intent searchIntent = new Intent(main.this, SearchActivity.class);
        startActivity(searchIntent);
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

//        trendingImageUrls.add("URL here");
//        trendingNames.add("Name of photo");
        //1
        trendingImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        trendingNames.add("Spaghetti and Meat Balls");

        trendingImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        trendingNames.add("Fruit Salad");

        trendingImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        trendingNames.add("Vegetarian Taco");

        trendingImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        trendingNames.add("Tofu Stir Fry");


        trendingImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        trendingNames.add("Green Tea");
//
//        trendingImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
//        trendingNames.add("Frozen Lake");
//
//
//        trendingImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
//        trendingNames.add("White Sands Desert");
//
//        trendingImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
//        trendingNames.add("Austrailia");
//
//        trendingImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
//        trendingNames.add("Washington");

//        for (Recipe r : Community.trendingRecipes()) {
//            trendingImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
//            trendingNames.add(r.getName());
//        }


        // 2
        mImageUrls2.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames2.add("Teriaky Chicken");

        mImageUrls2.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames2.add("Vegan Pizza");

        mImageUrls2.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames2.add("Free Juice");

        mImageUrls2.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames2.add("Beef Mince");

        mImageUrls2.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames2.add("Protein Shake");

//        mImageUrls2.add("https://i.redd.it/k98uzl68eh501.jpg");
//        mNames2.add("Frozen Lake");
//
//
//        mImageUrls2.add("https://i.redd.it/glin0nwndo501.jpg");
//        mNames2.add("White Sands Desert");
//
//        mImageUrls2.add("https://i.redd.it/obx4zydshg601.jpg");
//        mNames2.add("Austrailia");
//
//        mImageUrls2.add("https://i.imgur.com/ZcLLrkY.jpg");
//        mNames2.add("Washington");

        // 3
        mImageUrls3.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames3.add("Chicken Curry");

        mImageUrls3.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames3.add("Tomato Soup");

        mImageUrls3.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames3.add("Pho");

        mImageUrls3.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames3.add("Vegetarian Burger");

        mImageUrls3.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames3.add("Pasta");

        mImageUrls3.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames3.add("Roast Chicken and Potatoes");

//        mImageUrls3.add("https://i.redd.it/glin0nwndo501.jpg");
//       mNames3.add("White Sands Desert");
//
//        mImageUrls3.add("https://i.redd.it/obx4zydshg601.jpg");
//        mNames3.add("Austrailia");
//
//        mImageUrls3.add("https://i.imgur.com/ZcLLrkY.jpg");
//        mNames3.add("Washington");

//        for (RecipeActivity r : Community.filter(Diet.VEGAN)) {
//            mNames3.add(r.getName());
//        }

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, trendingNames, trendingImageUrls);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(layoutManager2);
        RecyclerViewAdapter adapter2 = new RecyclerViewAdapter(this, mNames2, mImageUrls2);
        recyclerView2.setAdapter(adapter2);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView3 = findViewById(R.id.recyclerView3);
        recyclerView3.setLayoutManager(layoutManager3);
        RecyclerViewAdapter adapter3 = new RecyclerViewAdapter(this, mNames3, mImageUrls3);
        recyclerView3.setAdapter(adapter3);
    }




}