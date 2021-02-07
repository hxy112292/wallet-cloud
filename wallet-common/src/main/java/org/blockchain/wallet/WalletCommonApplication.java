package org.blockchain.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author terry.huang
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WalletCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletCommonApplication.class, args);
	}

}
