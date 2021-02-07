package org.blockchain.wallet.util;

import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author hxy
 */
public class UUIDUtil {

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return StringUtils.replace(uuid.toString().trim(), "-", "");
    }
}
