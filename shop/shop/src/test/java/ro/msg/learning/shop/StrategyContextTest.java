package ro.msg.learning.shop;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import ro.msg.learning.shop.strategy.IStrategy;
import ro.msg.learning.shop.strategy.MostAbundantStrategy;
import ro.msg.learning.shop.strategy.SingleLocationStrategy;

@TestConfiguration
@Import({SingleLocationStrategy.class, MostAbundantStrategy.class})
public class StrategyContextTest {

    @Bean()
    public IStrategy singleStrategy()
    {
        return new SingleLocationStrategy();
    }

    @Bean(name = "mostAbundantStrategy")
    public IStrategy mostAbundantStrategy()
    {
        return new MostAbundantStrategy();
    }
}