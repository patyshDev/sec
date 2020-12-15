package ru.snakesnake.crudapp.service;

import ru.snakesnake.crudapp.model.Role;

import java.util.List;

public interface RoleService {
    public Role getRoleByName(String name);
    public List<Role> listRoles();
}
