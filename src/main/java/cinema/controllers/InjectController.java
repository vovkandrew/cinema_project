package cinema.controllers;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InjectController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void injectTestRolesAndUsers() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.addRole(adminRole);
        User adminUser = new User();
        adminUser.setRoles(Set.of(adminRole));
        adminUser.setEmail("admin@gmail.com");
        adminUser.setPassword("admin007");
        userService.add(adminUser);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.addRole(userRole);
        User justUser = new User();
        justUser.setRoles(Set.of(userRole));
        justUser.setEmail("user@yahoo.com");
        justUser.setPassword("qwerty");
        userService.add(justUser);
    }
}
