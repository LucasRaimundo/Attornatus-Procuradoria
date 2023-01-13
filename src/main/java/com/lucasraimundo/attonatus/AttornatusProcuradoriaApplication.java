package com.lucasraimundo.attonatus;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucasraimundo.attonatus.domain.Cidade;
import com.lucasraimundo.attonatus.domain.Cliente;
import com.lucasraimundo.attonatus.domain.Endereco;
import com.lucasraimundo.attonatus.domain.State;
import com.lucasraimundo.attonatus.repositories.CidadeRepository;
import com.lucasraimundo.attonatus.repositories.ClienteRepository;
import com.lucasraimundo.attonatus.repositories.EnderecoRepository;
import com.lucasraimundo.attonatus.repositories.StateRepository;

@SpringBootApplication
public class AttornatusProcuradoriaApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AttornatusProcuradoriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	
		
			
		State s1 = new State(null, "Minas Gerais");
		State s2 = new State(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", s1);
		Cidade c2 = new Cidade(null, "São Paulo", s2);
		Cidade c3 = new Cidade(null, "Campinas", s2);
		
		s1.getCities().addAll(Arrays.asList(c1));
		s2.getCities().addAll(Arrays.asList(c2, c3));
		
		
		stateRepository.saveAll(Arrays.asList(s1, s2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "27/11/2002");
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardins", "15989356", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "45978652", cli1, c2);
				
		
		cli1.getEndereco().addAll(Arrays.asList(e1, e2));
		
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
		
		
	}
	
	

}
