package com.example.model;

import java.io.Serializable;
import java.util.List;

	public class Recipe implements Serializable {
	  
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	    private long id;
	    private String name;
	    private String method;
	    private List<Ingredient> ingredients;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}
	    
		public List<Ingredient> getIngredients() {
			return ingredients;
		}

		public void setIngredients(List<Ingredient> ingredients) {
			this.ingredients = ingredients;
		}

	    
	    
	}

