package org.blockchain.wallet.service;

import org.blockchain.wallet.entity.HotWeb;

import java.util.List;

/**
 * @author hxy
 */
public interface HotWebService {

    List<HotWeb> selectBySelective(HotWeb hotWeb);
}
