package cinema.model.dto;

import java.util.List;

public class ShoppingCartResponseDto {
    private List<TicketResponseDto> ticketResponseDtoList;
    private UserResponseDto userResponseDto;

    public ShoppingCartResponseDto() {
    }

    public ShoppingCartResponseDto(List<TicketResponseDto> ticketResponseDtoList,
                                   UserResponseDto userResponseDto) {
        this.ticketResponseDtoList = ticketResponseDtoList;
        this.userResponseDto = userResponseDto;
    }

    public List<TicketResponseDto> getTicketResponseDtoList() {
        return ticketResponseDtoList;
    }

    public void setTicketResponseDtoList(List<TicketResponseDto> ticketResponseDtoList) {
        this.ticketResponseDtoList = ticketResponseDtoList;
    }

    public UserResponseDto getUserResponseDto() {
        return userResponseDto;
    }

    public void setUserResponseDto(UserResponseDto userResponseDto) {
        this.userResponseDto = userResponseDto;
    }
}
