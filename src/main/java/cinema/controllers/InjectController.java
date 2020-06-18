package cinema.controllers;

import cinema.model.Role;
import cinema.service.RoleService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InjectController {
    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void postConstruct() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.addRole(adminRole);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.addRole(userRole);
    }
}
