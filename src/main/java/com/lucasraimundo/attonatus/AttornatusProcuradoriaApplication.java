package com.lucasraimundo.attonatus;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucasraimundo.attonatus.domain.Cliente;
import com.lucasraimundo.attonatus.repositories.ClienteRepository;

@SpringBootApplication
public class AttornatusProcuradoriaApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AttornatusProcuradoriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente cli1 = new Cliente(null, "Maria Silva", "27/11/2002");
		Cliente cli2 = new Cliente(null, "Amélia Santos", "03/10/1988");
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
	}
	
	

}
