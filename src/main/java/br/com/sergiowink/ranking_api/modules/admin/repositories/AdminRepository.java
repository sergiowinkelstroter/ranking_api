package br.com.sergiowink.ranking_api.modules.admin.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sergiowink.ranking_api.modules.admin.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID> {
  
    
}