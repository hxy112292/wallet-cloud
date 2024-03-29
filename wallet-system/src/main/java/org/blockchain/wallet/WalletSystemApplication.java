package org.blockchain.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hxy
 */
@SpringBootApplication(scanBasePackages = "org.blockchain.wallet")
@EnableDiscoveryClient
public class WalletSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletSystemApplication.class, args);
    }

}
