package com.lucasraimundo.attonatus.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasraimundo.attonatus.domain.Cidade;
import com.lucasraimundo.attonatus.domain.Cliente;
import com.lucasraimundo.attonatus.domain.Endereco;
import com.lucasraimundo.attonatus.dto.ClienteDTO;
import com.lucasraimundo.attonatus.dto.ClienteNewDTO;
import com.lucasraimundo.attonatus.repositories.ClienteRepository;
import com.lucasraimundo.attonatus.repositories.EnderecoRepository;
import com.lucasraimundo.attonatus.service.exceptions.DataIntegrityException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Cliente> findAll(){
		return repo.findAll();
		}
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName(), obj));
	}
	
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setNasc(obj.getNasc());
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getNasc());
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possivel excluir porque há clientes relacionadas");
		}
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEndereco());
		return obj;
	}
	
	
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getNasc());
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLogadouro(), objDto.getNumber(), objDto.getComplement(), objDto.getDistrict(), objDto.getCep(), cli, cid);
		cli.getEndereco().add(end);
		return cli;
	}
	
	
}
