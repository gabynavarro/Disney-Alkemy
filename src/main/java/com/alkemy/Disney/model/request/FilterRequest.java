package com.alkemy.Disney.model.request;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterRequest {
    	private String name_character;
	private Integer age;
	private Set<Long> movies;
}
