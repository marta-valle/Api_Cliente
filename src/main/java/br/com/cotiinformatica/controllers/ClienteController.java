package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ClientePostDTO;
import br.com.cotiinformatica.dtos.ClientePutDTO;
import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

	// POST PARA CRIAR
	@PostMapping
	public ResponseEntity<String> post(@RequestBody ClientePostDTO dto) { // O REQUESTBODY DIZ AO SPRINGBOOT, QUE OS
																			// DADOS VÃO VIR DA
		// CLASSE CLIENTE POST DTO E TERA O NOME DE DTO
		try {
			// INICIA A ENTITIES CLIENTE.
			Cliente cliente = new Cliente();

			cliente.setNome(dto.getNome());
			cliente.setEmail(dto.getEmail());
			cliente.setCpf(dto.getCpf());
			cliente.setTelefone(dto.getTelefone());
			cliente.setObservacoes(dto.getObservacoes());

			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.create(cliente);

			// RETORNARÁ
			return ResponseEntity.status(200).body("Cliente cadastrado com sucesso!");

		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro" + e.getMessage());
		}
	}

	// PUT PARA ALTERAR
	@PutMapping
	public ResponseEntity<String> put(@RequestBody ClientePutDTO dto) {

		try {
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findbyId(dto.getIdCliente());
			// DECLARANDO O CLIENTE, E DANDO A ELE O VALOR DO CLIENTE QUE FOI PESQUISADO
			// DENTRO DE FINDBYID. ESTE ID SERÁ RECEBIDO PELO DTO.IDCLIENTE

			if (cliente != null) {
				// SE A BUSCA DO CLIENTE RETORNAR DIFERENTE DE NULL ELE ATUARIZARÁ OS DADOS
				// RECEBIDO PELO USUARIO UM A UM
				cliente.setNome(dto.getNome());
				cliente.setEmail(dto.getEmail());
				cliente.setCpf(dto.getCpf());
				cliente.setTelefone(dto.getTelefone());
				cliente.setObservacoes(dto.getObservacoes());

				// USARÁ O CLIENTEREPOSITORY.UPDATE PARA ATUALIZAR OS DADOS
				clienteRepository.update(cliente);
				// RETORNARÁ
				return ResponseEntity.status(200).body("Cliente Alterado com sucesso!");
			} else {
				return ResponseEntity.status(400).body("Cliente não encontradon verifique o id informado");
			}

		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro" + e.getMessage());

		}

	}

	// DELETE PARA EXCLUIR já é diferente dos demais.
	@DeleteMapping("{idCliente}")
	public ResponseEntity<String> delete(@PathVariable("idCliente") Integer idCliente) {
		try {
			// BUSCA O CLIENTE ATRAVES DO ID
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findbyId(idCliente);

			if (cliente != null) {

				clienteRepository.delete(cliente);

				// RETORNARÁ
				return ResponseEntity.status(200).body("Cliente excluido com sucesso");

			} else {
				return ResponseEntity.status(400).body("Cliente não encontradon verifique o id informado");
			}

		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro" + e.getMessage());
		}
	}

	// GET PARA RETORNAR (ALL) TODOS
	@GetMapping
	public List<Cliente> getAll() {
		try {
			ClienteRepository clienteRepository = new ClienteRepository();
			return clienteRepository.findall();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// Get para RETORNAR APENAS UM CLIENTE.
	@GetMapping("{idCliente}")
	public Cliente findById(@PathVariable("idCliente") Integer idCliente) {

		try {
			ClienteRepository clienteRepository = new ClienteRepository();
			return clienteRepository.findbyId(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

}
