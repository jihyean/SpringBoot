package com.jhyun.app;

import lombok.Data;

@Data
public class BoardDTO {

	private int bid; //PK
	private String mid; //FK
	private String content; 
}
