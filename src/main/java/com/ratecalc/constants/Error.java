package com.ratecalc.constants;

/**
 * This enum is where we will hold all error codes and error messages.
 *
 * @Author Brian DeSimone
 * @Date 07/14/2018
 */
public enum Error {

    INTERNAL_SERVER_ERROR(1001, "Failed to process the request."),
    INVALID_JSON(1002, "The JSON body is invalid in the request."),
    INVALID_REQUIRED(1003, "One or more request attributes is missing, invalid, or not following constraints."),
    NO_DATA_FOUND(1004, "No data was found."),
    DUPLICATE_EMAIL(1005, "The customer email is already in use."),
    DUPLICATE_USERNAME(1006, "The customer username is already in use."),
    NO_CUSTOMERS_FOUND(1007, "There were no customers found in the DB."),
    ADDRESS_TYPE_ALREADY_EXISTS(1008, "The customer already has an address of this type."),
    NO_ADDRESSES_FOUND(1009, "There were no addresses found in the DB for this customer ID."),
    PHONE_TYPE_ALREADY_EXISTS(1010, "The customer already has a phone of this type."),
    NO_PHONES_FOUND(1011, "There were no phones found in the DB for this customer ID."),
    DUPLICATE_CARD_PAYMENT_METHOD(1012, "The credit card already exists for this customer."),
    DUPLICATE_BANK_PAYMENT_METHOD(1013, "The bank account already exists for this customer."),
    DUPLICATE_ALIAS_PAYMENT_METHOD(1014, "A payment method with this alias already exists for this customer."),
    NO_PAYMENT_METHOD_FOUND(1015, "There were no payment methods found in the DB for this customer ID.");

    /**
     * Variable that holds the error code
     */
    private int code;

    /**
     * Variable that holds the error message
     */
    private String message;

    Error(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Getter for error code
     * @return code
     */
    public int getErrorCode(){
        return code;
    }

    /**
     * Getter for error message
     * @return message
     */
    public String getErrorMessage(){
        return message;
    }
}
