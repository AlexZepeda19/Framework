package com.example.Framework.service;

import com.example.Framework.entity.Roles;
import com.example.Framework.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository ;

    public List<Roles> getRoles() {
        return rolesRepository.findAll();
    }

    public Optional<Roles> getRoles(Long id) {
        return rolesRepository.findById(id);
    }

    public void saveOrUpdate(Roles roles) {
        rolesRepository.save(roles);
    }

    public void deleteById(Long id) {
        rolesRepository.deleteById(id);
    }
}
