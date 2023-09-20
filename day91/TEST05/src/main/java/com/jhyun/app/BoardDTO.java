package com.jhyun.app;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BoardDTO {

	private int bid; //PK
	private String mid; //FK
	private String content; 
	
	private String search;
}
