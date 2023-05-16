package br.com.cotiinformatica.dtos;

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
public class ClientePutDTO {
	//COLOCAMOS TAMBÉM O IDCLIENTE, POIS PRECISAMOS SABER QUAL CLIENTE SERÁ ACIONADO, DIFERENTE DO POST QUE ESTA SENDO CRIADO E AINDA RECEBERÁ UM ID.
	//INCLUIMOS TODOS OS DADOS QUE PRECISAMOS PARA ACIONAR O CLIENTE.
	
		private Integer idCliente;
		private String nome;
		private String cpf;
		private String email;
		private String telefone;
		private String observacoes;

}
