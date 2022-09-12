package com.example.demo.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Banco implements Serializable {
	
	private static final long serialVersionUID = 74957674389792978L;
	private String nome;
	private Long conta;
	private Long agencia;
	
}
