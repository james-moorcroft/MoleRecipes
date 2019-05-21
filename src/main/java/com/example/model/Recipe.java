package com.example.model;

import java.io.Serializable;

	public class Recipe implements Serializable {
	  
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	    private long id;
	    private String name;
	    private String method;

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
	    
	    
	    
	}

