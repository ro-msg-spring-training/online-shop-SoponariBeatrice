package ro.msg.learning.shop.exception;

public class StrategyNotApplicableException extends RuntimeException{
    private String message;
    public StrategyNotApplicableException(){}
    public StrategyNotApplicableException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
