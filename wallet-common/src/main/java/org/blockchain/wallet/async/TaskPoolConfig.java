package org.blockchain.wallet.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author hxy
 */
@EnableAsync
@Configuration
public class TaskPoolConfig {

    @Bean("taskExecutor")
    public TaskExecutor taskExecutor () {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(10);
        // 设置最大线程数
        executor.setMaxPoolSize(50);
        // 设置队列容量
        executor.setQueueCapacity(10);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(30);
        // 设置默认线程名称
        executor.setThreadNamePrefix("taskExecutor-");
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
