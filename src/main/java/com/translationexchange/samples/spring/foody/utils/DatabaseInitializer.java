package com.translationexchange.samples.spring.foody.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.javalite.activejdbc.Base;

import com.translationexchange.core.Utils;
import com.translationexchange.samples.spring.foody.models.Category;
import com.translationexchange.samples.spring.foody.models.Direction;
import com.translationexchange.samples.spring.foody.models.Ingredient;
import com.translationexchange.samples.spring.foody.models.Recipe;

public class DatabaseInitializer {

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getData() throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(DatabaseInitializer.class.getResourceAsStream("/recipes.json")));
		String read = br.readLine();
		while (read != null) {
			sb.append(read);
			read = br.readLine();
		}
		return (Map<String, Object>) Utils.parseJSON(sb.toString());
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Base.open("org.sqlite.JDBC", "jdbc:sqlite:src/main/resources/recipes.db", "root", "");

		Category.deleteAll();
		Recipe.deleteAll();
		Direction.deleteAll();
		Ingredient.deleteAll();
		
		try {
			Map<String, Object> data = DatabaseInitializer.getData();
			List<Map<String, String>> categories = (List<Map<String, String>>) data.get("categories");

			for (Map<String, String> category : categories) {
				Category c = new Category();
				c.set("keyword", category.get("id"));
				c.set("name", category.get("name"));
				c.saveIt();
			}
			
			List<Map<String, Object>> recipies = (List<Map<String, Object>>) data.get("recipes");

			for (Map<String, Object> recipe : recipies) {
				Category c = Category.findFirst("keyword = ?", recipe.get("category"));
				
				Recipe r = new Recipe();
				if (c != null) r.set("category_id", c.getId());
				r.set("keyword", recipe.get("id"));
				r.set("name", recipe.get("name"));
				r.set("description", recipe.get("description"));
				r.set("image", recipe.get("image"));
				r.set("preparation", recipe.get("preparation"));
				r.saveIt();
				
				List<String> directions = (List<String>) recipe.get("directions");
				for (String direction : directions) {
					Direction d = new Direction();
					d.set("recipe_id", r.getId());
					d.set("description", direction);
					d.saveIt();
				}	

				List<Map<String, Object>> ingredients = (List<Map<String, Object>>) recipe.get("ingredients");
				for (Map<String, Object> ingredient : ingredients) {
					Ingredient i = new Ingredient();
					i.set("recipe_id", r.getId());
					i.set("quantity", ingredient.get("quantity"));
					i.set("name", ingredient.get("name"));
					i.set("measurements", ingredient.get("measurements"));
					i.saveIt();
				}	
			}
			

		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace(System.out);
		}

		System.out.println(Category.count());
		System.out.println(Recipe.count());
		System.out.println(Direction.count());
		System.out.println(Ingredient.count());

		Base.close();
	}

}
