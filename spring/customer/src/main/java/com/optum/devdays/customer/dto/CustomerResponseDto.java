package com.optum.devdays.customer.dto;

/**
 * The Class CustomerResponseDto.
 */
public class CustomerResponseDto {

	/** The message. */
	private String message;

	/**
	 * Instantiates a new customer response dto.
	 *
	 * @param message the message
	 */
	public CustomerResponseDto(String message) {
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
