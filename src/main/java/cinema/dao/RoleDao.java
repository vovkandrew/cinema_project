package cinema.dao;

import cinema.model.Role;

public interface RoleDao {
    public void addRole(Role role);

    public Role findByName(String roleName);
}
