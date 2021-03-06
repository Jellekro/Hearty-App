package com.example.xdhacks.Activities;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.xdhacks.Diet;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@TargetApi(19)
public class Recipe {

    private String name;
    private Drawable image;
    private String description;
    public List<Ingredient> ingredients;
    private List<String> steps;
    private User user;
    private int likeCount;
    private Diet diet;

    public Recipe(String name, Drawable image, String description, User user) {
        this.name = name;
        this.description = description;
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.user = user;
        this.likeCount = 0;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public Drawable getImage() {
        return this.image;
    }

    public String getDescription() {
        return this.description;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public List<String> getSteps() {
        return this.steps;
    }

    public Diet getDiet() {
        return this.diet;
    }

    public void addLike() {
        this.likeCount += 1;
    }

    public void addIngredients(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void addSteps(String step) {
        this.steps.add(step);
    }

    public void setDiet(Diet d) {
        this.diet = d;
    }

    public void removeStep (){
        this.steps.remove(this.steps.size() - 1);
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int totalCalories() {
        int totalCount = 0;
        for (Ingredient i: ingredients)
            totalCount += i.getCalCount();
        return totalCount;
    }

    public void toFirebase() {
        DatabaseReference root = FirebaseDatabase.getInstance().getReference();
        DatabaseReference recipesRef = root.child("Recipes");
        DatabaseReference recipeRef = recipesRef.push();
        recipeRef.setValue(toJSON());
    }


    public String toJSON() {
        JSONObject recipe = new JSONObject();
        try {
            recipe.put("name", name);
            recipe.put("image", image);
            recipe.put("description", description);
            JSONArray ingsArr = new JSONArray();
            for (Ingredient i: ingredients) {
                JSONObject ingObj = new JSONObject();
                ingObj.put("name", i.getName());
                ingObj.put("calCount", i.getCalCount());
                ingsArr.put(ingObj);
            }
            recipe.put("ingredients", ingsArr);
            JSONArray stepsArr = new JSONArray();
            for (int i = 0; i < steps.size(); i++) {
                JSONObject stepObj = new JSONObject();
                stepObj.put("step "+(i+1), steps.get(i));
            }
            recipe.put("steps", stepsArr);
            recipe.put("user", user);
            recipe.put("likeCount", likeCount);
            recipe.put("diet", diet);
            return recipe.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return likeCount == recipe.likeCount &&
                Objects.equals(name, recipe.name) &&
                Objects.equals(image, recipe.image) &&
                Objects.equals(description, recipe.description) &&
                Objects.equals(ingredients, recipe.ingredients) &&
                Objects.equals(steps, recipe.steps) &&
                Objects.equals(user, recipe.user) &&
                diet == recipe.diet;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, image, description, ingredients, steps, user, likeCount, diet);
    }


}
