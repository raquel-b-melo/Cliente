package com.raquel.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raquel.entity.Cliente;
import com.raquel.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	@PostMapping("/insert")
	public ResponseEntity<Cliente> inserirCliente(@Valid @RequestBody Cliente cliente) {
		try {
			return new ResponseEntity<>(clienteRepository.save(cliente), HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> buscarTodos() {
			List<Cliente> listaDeClientes = clienteRepository.findAll();
			
			if (listaDeClientes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(listaDeClientes, HttpStatus.OK);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
		Optional<Cliente> clienteEncontrado = clienteRepository.findById(id);

		if (!clienteEncontrado.isPresent()) {
			throw new NullPointerException();
		}
		
		return new ResponseEntity<Cliente>(clienteEncontrado.get(),HttpStatus.OK);

	}

}
