package cinema.controllers;

import cinema.model.Role;
import cinema.model.dto.UserRequestDto;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

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

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserRequestDto userRequestDto) {
        authenticationService.register(userRequestDto.getEmail(), userRequestDto.getPassword());
    }
}
