package mao.redis_fragment_cluster.config;

import io.lettuce.core.ReadFrom;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project name(项目名称)：redis_fragment_cluster
 * Package(包名): mao.redis_fragment_cluster.config
 * Class(类名): RedisConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/5/24
 * Time(创建时间)： 13:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Configuration
public class RedisConfig
{
    /**
     * 配置redis读写分离
     *
     * @return LettuceClientConfigurationBuilderCustomizer
     */
    @Bean
    public LettuceClientConfigurationBuilderCustomizer lettuceClientConfigurationBuilderCustomizer()
    {
        //MASTER：从主节点读取
        //MASTER_PREFERRED：优先从master节点读取，master不可用才读取replica
        //REPLICA：从slave（replica）节点读取
        //REPLICA _PREFERRED：优先从slave（replica）节点读取，所有的slave都不可用才读取master
        return clientConfigurationBuilder -> clientConfigurationBuilder.readFrom(ReadFrom.REPLICA_PREFERRED);
    }
}
