package com.optum.devdays.product.dto;

/**
 * The Class ProductResponseDto.
 */
public class ProductResponseDto {

    /** The message. */
    private String message;

    /**
     * Instantiates a new product response dto.
     *
     * @param message the message
     */
    public ProductResponseDto(String message) {
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
