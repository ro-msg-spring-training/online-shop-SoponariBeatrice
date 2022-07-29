package ro.msg.learning.shop.exception;

public class NoSuchCategoryExistsException extends RuntimeException{
    private String message;
    public NoSuchCategoryExistsException(){}
    public NoSuchCategoryExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
