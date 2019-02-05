package com.mesquita.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mesquita.api.utils.SenhaUtils;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
		System.out.println("Meu primeiro projeto");
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			String senha = "123456";
			String senhaEncriptada1 = SenhaUtils.gerarBCrypt(senha);
			System.out.println("Senha encriptada1: " + senhaEncriptada1);
			
			String senhaEncriptada2 = SenhaUtils.gerarBCrypt(senha);
			System.out.println("Senha encriptada2: " + senhaEncriptada2);
			
			System.out.println("Senha válida1: " + SenhaUtils.senhaValida(senha, senhaEncriptada1));
			System.out.println("Senha válida2: " + SenhaUtils.senhaValida(senha, senhaEncriptada2));
		};
	}
}