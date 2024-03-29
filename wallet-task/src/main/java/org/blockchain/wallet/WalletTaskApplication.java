package org.blockchain.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author terry.huang
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class},scanBasePackages = "org.blockchain.wallet")
@EnableDiscoveryClient
public class WalletTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletTaskApplication.class, args);
	}

}
