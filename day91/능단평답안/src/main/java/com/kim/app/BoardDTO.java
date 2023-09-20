package com.kim.app;

import lombok.Data;

@Data
public class BoardDTO { // VO
	private int bid; // PK
	private String mid; // FK
	private String content;
}
