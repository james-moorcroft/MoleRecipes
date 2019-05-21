package com.example.recipes;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.example.model.Recipe;



@Controller
public class RecipesController {
    @Value("${spring.application.name}")
    String appName;
    
    @Value("${recipes.service.url}")
    String url;
 
    @GetMapping("/")
    public String homePage(Model model) {
    	model.addAttribute("appName", appName);
        return "home";
    }
    
    @GetMapping("/home")
    public String backToHomePage(Model model) {
    	model.addAttribute("appName", appName);
        return "home";
    }
    
    @GetMapping("/recipes")
    public String recipes(Model model) {
    	List<Recipe> recipes = getRecipes();
    	model.addAttribute("recipes", recipes);
        return "recipes";
    }
    
    @GetMapping("/saveRecipe")
    public String saveRecipeGet(Model model) {
    	model.addAttribute("recipe", new Recipe());
    	return "saveRecipe";
    }
    
    @PostMapping(value = "/saveRecipe")
    public String saveRecipePost(@ModelAttribute Recipe recipe, BindingResult errors, Model model) {
    	postRecipe(recipe);
    	model.addAttribute("recipes", getRecipes());
        return "recipes";
    }

	private void postRecipe(Recipe recipe) {
		RestTemplate restTemplate = new RestTemplate();
    	HttpEntity<Recipe> request = new HttpEntity<>(recipe);;
    	ResponseEntity<Recipe> response = restTemplate.exchange(url, 
    			  HttpMethod.POST,
    			  request, 
    			  Recipe.class);
	}
	
	private List<Recipe> getRecipes() {
		RestTemplate restTemplate = new RestTemplate();
     	ResponseEntity<List<Recipe>> response = restTemplate.exchange(
    			  url,
    			  HttpMethod.GET,
    			  null,
    			  new ParameterizedTypeReference<List<Recipe>>(){});
    	List<Recipe> recipes = response.getBody();
		return recipes;
	}
    
}
