package com.generali.burritoorderingservice.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class OrderRequest {
	@NotNull
	@Size(min=2, message="Tortilla should not be empty")
	private String tortilla;// (one of):  {corn, flour}
	@NotNull
	@Size(min=2, message="Protein should not be empty")
	private String protein;// (one of):  {bean, beef, chicken, pork, shrimp, steak}
	private List<String> vegetables;//  (zero or more of):  {cabbage, corn, jalapenos}
	@NotNull
	@Size(min=2, message="Salsa should not be empty")
	private String salsa; // (one of):  {mild, medium, hot}
	private List<String> extras;//  (zero or more of):  {avocado}

}
