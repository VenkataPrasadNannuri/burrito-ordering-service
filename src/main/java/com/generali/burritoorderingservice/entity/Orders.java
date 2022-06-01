package com.generali.burritoorderingservice.entity;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	@NotNull
	@Size(min=2, message="Tortilla should not be empty")
	private String tortilla;// (one of):  {corn, flour}
	@NotNull
	@Size(min=2, message="Protein should not be empty")
	private String protein;// (one of):  {bean, beef, chicken, pork, shrimp, steak}
	@ElementCollection
	private Collection<String> vegetables;//  (zero or more of):  {cabbage, corn, jalapenos}
	@NotNull
	@Size(min=2, message="Salsa should not be empty")
	private String salsa; // (one of):  {mild, medium, hot}
	@ElementCollection
	private Collection<String> extras;//  (zero or more of):  {avocado}

}
