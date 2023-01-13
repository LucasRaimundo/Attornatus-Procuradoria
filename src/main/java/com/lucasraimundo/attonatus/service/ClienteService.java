package com.lucasraimundo.attonatus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasraimundo.attonatus.domain.Cliente;
import com.lucasraimundo.attonatus.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> findAll(){
		return repo.findAll();
		}
}
