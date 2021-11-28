package io.saud.vendingmachine.exception;


public class VendingMachineException extends RuntimeException {

    private String message;

    public VendingMachineException(String message) {
        this.message = message;
    }
}
