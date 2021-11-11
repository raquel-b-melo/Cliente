package com.raquel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.raquel.controller.ClienteController;
import com.raquel.entity.Cliente;
import com.raquel.repository.ClienteRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClienteTest {

	@Autowired
	private ClienteController clienteController;
	
	@Resource
    private ClienteRepository clienteRepository;

	@Test
	public void deveInserirUmClienteTeste() {
		Cliente novoCliente = new Cliente(1L,"Raquel", LocalDate.parse("1997-06-06"), "(11) 94256-3519");
		clienteController.inserirCliente(novoCliente);
		assertEquals("Raquel", clienteRepository.findById(1L).get().getNome());
	}

	@Test
	public void deveBuscarUmClientePorIdTeste(){
		Cliente novoCliente = new Cliente(1L,"Raquel", LocalDate.parse("1997-06-06"), "(11) 94256-3519");
		clienteController.inserirCliente(novoCliente);
		ResponseEntity<Cliente> clienteEncontrado = clienteController.buscarPorId(1L);
		assertEquals("Raquel", clienteEncontrado.getBody().getNome());
	}

	@Test
	public void deveBuscarTodosOsClientesTeste() {
		Cliente novoCliente = new Cliente(1L,"Raquel", LocalDate.parse("1997-06-06"), "(11) 94256-3519");
		List<Cliente> listaDeClientesNaBase = new ArrayList<Cliente>();
		listaDeClientesNaBase.add(novoCliente);
		clienteController.inserirCliente(novoCliente);
		assertEquals(listaDeClientesNaBase.get(0).getNome(), clienteController.buscarTodos().getBody().get(0).getNome());
	}

}
