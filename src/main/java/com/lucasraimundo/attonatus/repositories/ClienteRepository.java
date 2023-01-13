package com.lucasraimundo.attonatus.repositories;

import com.lucasraimundo.attonatus.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
