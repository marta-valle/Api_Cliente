package br.com.cotiinformatica.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Cliente {
	// PADRÃO JAVABEANS USANDO O LOMBOK PARA DECLARA-LOS 
	private Integer idCliente;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String observacoes;
}
