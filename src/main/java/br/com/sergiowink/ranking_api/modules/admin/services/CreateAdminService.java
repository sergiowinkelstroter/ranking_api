package br.com.sergiowink.ranking_api.modules.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.ranking_api.modules.admin.models.Admin;
import br.com.sergiowink.ranking_api.modules.admin.repositories.AdminRepository;

@Service
public class CreateAdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public Admin execute(Admin admin){
       return this.adminRepository.save(admin);
    }

}
