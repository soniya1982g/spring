package com.optum.devdays.product.dto;

import java.math.BigDecimal;

/**
 * The Class ProductDto.
 */
public class ProductDto {

    /** The description. */
    private String description;

    /** The price. */
    private BigDecimal price;

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
