package ru.snakesnake.crudapp.dao;

import ru.snakesnake.crudapp.model.Role;
import ru.snakesnake.crudapp.model.User;

import java.util.List;

public interface RoleDao {
    public Role getRoleByName(String name);
    public List<Role> listRoles();
}
