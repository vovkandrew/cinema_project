package cinema.model.dto;

import java.util.List;

public class OrderResponseDto {
    private List<TicketResponseDto> ticketResponseDtoList;
    private String orderDate;
    private String userEmail;

    public OrderResponseDto() {
    }

    public OrderResponseDto(List<TicketResponseDto> ticketResponseDtoList,
                            String orderDate, String userEmail) {
        this.ticketResponseDtoList = ticketResponseDtoList;
        this.orderDate = orderDate;
        this.userEmail = userEmail;
    }

    public List<TicketResponseDto> getTicketResponseDtoList() {
        return ticketResponseDtoList;
    }

    public void setTicketResponseDtoList(List<TicketResponseDto> ticketResponseDtoList) {
        this.ticketResponseDtoList = ticketResponseDtoList;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
