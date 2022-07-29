package ro.msg.learning.shop.exception;

public class NoSuchSupplierExistsException extends RuntimeException{
    private String message;
    public NoSuchSupplierExistsException(){}
    public NoSuchSupplierExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
