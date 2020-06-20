package cinema.service;

import cinema.model.Role;

public interface RoleService {
    public void addRole(Role role);

    public Role findRoleByName(String roleName);
}
