package br.com.cotiinformatica.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ClientePostDTO;
import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

	// POST PARA CRIAR
	@PostMapping
	public String post(@RequestBody ClientePostDTO dto) { //O REQUESTBODY DIZ AO SPRINGBOOT, QUE OS DADOS VÃO VIR DA CLASSE CLIENTE POSTDTO E TERA O NOME DE DTO
		try {
			//INICIA A ENTITIES CLIENTE.
			Cliente cliente = new Cliente();
			
			
			cliente.setNome(dto.getNome());
			cliente.setEmail(dto.getEmail());
			cliente.setCpf(dto.getCpf());
			cliente.setTelefone(dto.getTelefone());
			cliente.setObservacoes(dto.getObservacoes());

			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.create(cliente);

			// RETORNARÁ
			return "Cliente cadastrado com sucesso!";

		} catch (Exception e) {
			return "Erro" + e.getMessage();
		}
	}

	// PUT PARA ALTERAR
	@PutMapping
	public String put() {
		// TODO

		// RETORNARÁ
		return null;
	}

	// DELETE PARA EXCLUIR
	@DeleteMapping
	public String delete() {
		// TODO

		// RETORNARÁ
		return null;
	}

	// GET PARA RETORNAR (ALL) TODOS
	@GetMapping
	public String getAll() {
		// TODO

		// RETORNARÁ
		return null;
	}
}
