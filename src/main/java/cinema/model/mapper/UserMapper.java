package cinema.model.mapper;

import cinema.model.User;
import cinema.model.dto.UserRequestDto;
import cinema.model.dto.UserResponseDto;
import cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private UserService userService;

    public UserResponseDto getUserResponseDtoFromUser(User user) {
        return new UserResponseDto(user.getEmail());
    }

    public User getUserFromUserRequestDto(UserRequestDto userRequestDto) {
        return userService.findByEmail(userRequestDto.getEmail());
    }
}
