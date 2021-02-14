package org.blockchain.wallet.service;

import com.github.pagehelper.Page;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.LiveNewsComment;
import org.blockchain.wallet.entity.LiveNewsCommentLike;

/**
 * @author hxy
 */
public interface LiveNewsCommentService {

    Page<LiveNewsComment> pageBySelective(PageDto pageDto);

    int insert(LiveNewsComment liveNewsComment);

    int update(LiveNewsComment liveNewsComment);

    int delete(int id);

    int insertLike(LiveNewsCommentLike liveNewsCommentLike);

    int deleteLike(LiveNewsCommentLike liveNewsCommentLike);

    boolean isLike(LiveNewsCommentLike liveNewsCommentLike);
}
