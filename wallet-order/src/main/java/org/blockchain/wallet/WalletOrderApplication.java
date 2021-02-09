package org.blockchain.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hxy
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WalletOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletOrderApplication.class, args);
    }

}
