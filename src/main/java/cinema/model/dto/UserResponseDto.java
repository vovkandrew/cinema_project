package cinema.model.dto;

public class UserResponseDto {
    private String email;

    public UserResponseDto() {
    }

    public UserResponseDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
