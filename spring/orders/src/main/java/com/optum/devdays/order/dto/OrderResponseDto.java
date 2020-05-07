package com.optum.devdays.order.dto;

/**
 * The Class OrderResponseDto.
 */
public class OrderResponseDto {

    /** The message. */
    private String message;

    /**
     * Instantiates a new order response dto.
     *
     * @param message the message
     */
    public OrderResponseDto(String message) {
        super();
        this.message = message;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
