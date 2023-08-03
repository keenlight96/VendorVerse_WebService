package com.webservice.controller;

import com.webservice.model.Role;
import com.webservice.service.IRoleService;
import com.webservice.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/role")
public class RoleController {
    @Autowired
    IRoleService iRoleService;

    @GetMapping
    public ResponseEntity<List<Role>> getAll() {
        return new ResponseEntity<>(iRoleService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return new ResponseEntity<>(iRoleService.create(role), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Role> editRole(@RequestBody Role role) {
        return new ResponseEntity<>(iRoleService.edit(role), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteRole(@RequestBody Role role) {
        iRoleService.deleteById(role.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable int id) {
        return new ResponseEntity<>(iRoleService.getById(id), HttpStatus.OK);
    }
}
