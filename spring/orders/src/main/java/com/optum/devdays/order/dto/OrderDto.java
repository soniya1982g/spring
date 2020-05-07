package com.optum.devdays.order.dto;

/**
 * The Class OrderDto.
 */
public class OrderDto {

    /** The customer id. */
    private Integer customerId;

    /** The product id. */
    private Integer productId;

    /**
     * Gets the customer id.
     *
     * @return the customer id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer id.
     *
     * @param customerId the new customer id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the product id.
     *
     * @return the product id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * Sets the product id.
     *
     * @param productId the new product id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
