package com.example.Framework.controller;

import com.example.Framework.entity.Roles;
import com.example.Framework.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/roles")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @GetMapping
    public List<Roles> getAll() {
        return rolesService.getRoles();
    }

    @GetMapping("/{id}")
    public Optional<Roles> getRole(@PathVariable("id") Long idRol) {
        return rolesService.getRoles(idRol);
    }

    @PostMapping
    public ResponseEntity<Roles> saveOrUpdate(@RequestBody Roles roles) {
        Roles savedRole = rolesService.saveOrUpdate(roles);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable("id") Long idRol) {
        rolesService.deleteById(idRol);
    }
}
