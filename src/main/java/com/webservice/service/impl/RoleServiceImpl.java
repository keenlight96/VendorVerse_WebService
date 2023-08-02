package com.webservice.service.impl;

import com.webservice.model.Role;
import com.webservice.repository.IRoleRepository;
import com.webservice.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository iRoleRepository;

    @Override
    public List<Role> getAll() {
        return iRoleRepository.findAll();
    }

    @Override
    public Role getById(int id) {
        return iRoleRepository.findById(id).get();
    }

    @Override
    public Role create(Role account) {
        return iRoleRepository.save(account);
    }

    @Override
    public Role edit(Role account) {
        return iRoleRepository.save(account);
    }

    @Override
    public void deleteById(int id) {
        iRoleRepository.deleteById(id);
    }
}
