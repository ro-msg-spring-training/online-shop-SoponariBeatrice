package ro.msg.learning.shop.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StrategyContext {
    @Value("${strategy}")
    String strategy;
    @Bean
    public IStrategy getStrategy(){
            if(strategy.equals("singleLocation"))
            {
                return new SingleLocationStrategy();
            }
            else
            {
                return new MostAbundantStrategy();
            }
    }


}
