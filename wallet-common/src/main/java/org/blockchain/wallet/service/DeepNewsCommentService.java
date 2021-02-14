package org.blockchain.wallet.service;

import com.github.pagehelper.Page;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.DeepNewsComment;
import org.blockchain.wallet.entity.DeepNewsCommentLike;
import org.blockchain.wallet.entity.LiveNewsCommentLike;

/**
 * @author hxy
 */
public interface DeepNewsCommentService {

    Page<DeepNewsComment> pageBySelective(PageDto pageDto);

    int insert(DeepNewsComment deepNewsComment);

    int update(DeepNewsComment deepNewsComment);

    int delete(int id);

    int insertLike(DeepNewsCommentLike deepNewsCommentLike);

    int deleteLike(DeepNewsCommentLike deepNewsCommentLike);

    boolean isLike(DeepNewsCommentLike deepNewsCommentLike);
}
