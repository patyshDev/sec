package ru.snakesnake.crudapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.snakesnake.crudapp.dao.RoleDao;
import ru.snakesnake.crudapp.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> listRoles() {
        return roleDao.listRoles();
    }
}
