package org.blockchain.wallet.service;

import com.github.pagehelper.Page;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.LiveNewsComment;

/**
 * @author hxy
 */
public interface LiveNewsCommentService {

    Page<LiveNewsComment> pageBySelective(PageDto pageDto);

    int insert(LiveNewsComment liveNewsComment);

    int update(LiveNewsComment liveNewsComment);

    int delete(int id);
}
