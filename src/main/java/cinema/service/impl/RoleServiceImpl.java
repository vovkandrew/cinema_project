package cinema.service.impl;

import cinema.dao.RoleDao;
import cinema.model.Role;
import cinema.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role findRoleByName(String roleName) {
        return roleDao.findByName(roleName);
    }
}
