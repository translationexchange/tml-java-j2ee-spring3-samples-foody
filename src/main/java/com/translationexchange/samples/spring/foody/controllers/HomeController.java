/**
 * Copyright (c) 2015 Translation Exchange, Inc. All rights reserved.
 *
 *  _______                  _       _   _             ______          _
 * |__   __|                | |     | | (_)           |  ____|        | |
 *    | |_ __ __ _ _ __  ___| | __ _| |_ _  ___  _ __ | |__  __  _____| |__   __ _ _ __   __ _  ___
 *    | | '__/ _` | '_ \/ __| |/ _` | __| |/ _ \| '_ \|  __| \ \/ / __| '_ \ / _` | '_ \ / _` |/ _ \
 *    | | | | (_| | | | \__ \ | (_| | |_| | (_) | | | | |____ >  < (__| | | | (_| | | | | (_| |  __/
 *    |_|_|  \__,_|_| |_|___/_|\__,_|\__|_|\___/|_| |_|______/_/\_\___|_| |_|\__,_|_| |_|\__, |\___|
 *                                                                                        __/ |
 *                                                                                       |___/
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.translationexchange.samples.spring.foody.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.translationexchange.core.Utils;

@Controller
public class HomeController {
	
	private Map<String, Object> data;
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> getData() throws IOException {
		if (data == null) {
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/data.json")));
			String read = br.readLine();
			while (read != null) {
			    sb.append(read);
			    read = br.readLine();
			}
			data = (Map<String, Object>) Utils.parseJSON(sb.toString());
		}
		return data;
	}
	
	@SuppressWarnings("unchecked")
	private Object findRecipeById(String id) throws IOException {
		List<Map<String, Object>> allRecipies = (List<Map<String, Object>>) getData().get("recipes");
		for (Map<String, Object> recipe : allRecipies) {
			if (recipe.get("id").equals(id))
				return recipe;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private List<Map<String, String>> getCategories() throws IOException {
		return (List<Map<String, String>>) getData().get("categories");
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, List<Object>> getRecipesByCategories() throws IOException {
		Map<String, List<Object>> recipiesByCategories = new HashMap<String, List<Object>>();
		
		List<Map<String, Object>> allRecipies = (List<Map<String, Object>>) getData().get("recipes");
		for (Map<String, Object> recipe : allRecipies) {
			List<Object> recipies = (List<Object>) recipiesByCategories.get(recipe.get("category"));
			if (recipies == null) {
				recipies = new ArrayList<Object>();
				recipiesByCategories.put((String) recipe.get("category"), recipies);
			}
			recipies.add(recipe);
		}

		return recipiesByCategories;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelMap modelMap) throws ServletException, IOException {		
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("categories", getCategories());
		model.addObject("recipes_by_categories", getRecipesByCategories());
		return model;
	}

	@RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
	public ModelAndView recipe(@PathVariable("id") String id) throws ServletException, IOException {		
		ModelAndView model = new ModelAndView();
		model.setViewName("recipe");
		model.addObject("recipe", findRecipeById(id));
		return model;
	}
	
}