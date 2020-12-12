package ru.snakesnake.crudapp.dao;

import ru.snakesnake.crudapp.model.Role;

public interface RoleDao {
    public Role getRoleByName(String name);
}
