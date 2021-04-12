package org.blockchain.wallet.controller;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.BaseResponse;
import org.blockchain.wallet.base.PageResponse;
import org.blockchain.wallet.base.ResultResponse;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.DeepNewsComment;
import org.blockchain.wallet.entity.DeepNewsCommentLike;
import org.blockchain.wallet.entity.LiveNewsComment;
import org.blockchain.wallet.entity.LiveNewsCommentLike;
import org.blockchain.wallet.resttemplate.JinseIRestAPI;
import org.blockchain.wallet.service.DeepNewsCommentService;
import org.blockchain.wallet.service.LiveNewsCommentService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/liveNews")
@RequiredArgsConstructor
public class LiveNewsController {

    private final JinseIRestAPI jinseIRestAPI;

    private final LiveNewsCommentService liveNewsCommentService;

    private final DeepNewsCommentService deepNewsCommentService;

    @GetMapping
    public Object getLiveNews(@RequestParam(value = "id", required = false) String id) {
        if(id == null) {
            return jinseIRestAPI.getLive("");
        } else {
            return jinseIRestAPI.getLive(id);
        }
    }
    @GetMapping(value = "detail")
    public Object getLiveNewsDetail(String id) {
        return jinseIRestAPI.getLiveDetail(id);
    }
    @GetMapping(value = "detail/comment/list")
    public BaseResponse<Page<LiveNewsComment>> getLiveNewsDetailCommentList(PageDto pageDto) {
        Page<LiveNewsComment> page = liveNewsCommentService.pageBySelective(pageDto);
        return new PageResponse<>(page, page.getTotal());
    }
    @PostMapping(value = "detail/comment")
    public BaseResponse<Integer> insertLiveNewsDetailComment(@RequestBody LiveNewsComment liveNewsComment, Authentication auth) {
        liveNewsComment.setUserId((Integer) auth.getPrincipal());
        return new ResultResponse<>(liveNewsCommentService.insert(liveNewsComment));
    }
    @PutMapping(value = "detail/comment")
    public BaseResponse<Integer> updateLiveNewsDetailComment(@RequestBody LiveNewsComment liveNewsComment, Authentication auth) {
        liveNewsComment.setUserId((Integer) auth.getPrincipal());
        return new ResultResponse<>(liveNewsCommentService.update(liveNewsComment));
    }
    @DeleteMapping(value = "detail/comment")
    public BaseResponse<Integer> deleteLiveNewsDetailComment(Integer id) {
        return new ResultResponse<>(liveNewsCommentService.delete(id));
    }
    @PostMapping(value = "detail/comment/like")
    public BaseResponse<Integer> insertLiveNewsDetailCommentLike(@RequestBody LiveNewsCommentLike liveNewsCommentLike, Authentication auth) {
        liveNewsCommentLike.setUserId((Integer) auth.getPrincipal());
        return new ResultResponse<>(liveNewsCommentService.insertLike(liveNewsCommentLike));
    }
    @DeleteMapping(value = "detail/comment/like")
    public BaseResponse<Integer> deleteLiveNewsDetailCommentLike(LiveNewsCommentLike liveNewsCommentLike, Authentication auth) {
        liveNewsCommentLike.setUserId((Integer) auth.getPrincipal());
        return new ResultResponse<>(liveNewsCommentService.deleteLike(liveNewsCommentLike));
    }
    @GetMapping(value = "detail/comment/isLike")
    public BaseResponse<Boolean> isLiveNewsDetailCommentLike(LiveNewsCommentLike liveNewsCommentLike, Authentication auth) {
        if(auth == null) {
            return new ResultResponse<>(false);
        }
        liveNewsCommentLike.setUserId((Integer) auth.getPrincipal());
        return new ResultResponse<>(liveNewsCommentService.isLike(liveNewsCommentLike));
    }

    @GetMapping(value = "/deep")
    public Object getDeepNewsList(@RequestParam(value = "id", required = false) String id) {
        if(id == null) {
            return jinseIRestAPI.getCommonNewsList("");
        } else {
            return jinseIRestAPI.getCommonNewsList(id);
        }
    }
    @GetMapping(value = "/deep/detail")
    public BaseResponse<String> getDeepNewsDetail(@RequestParam String url) {
        return new ResultResponse<>(jinseIRestAPI.getCommonNewsDetail(url));
    }
    @GetMapping(value = "/deep/detail/comment/list")
    public BaseResponse<Page<DeepNewsComment>> getDeepNewsDetailCommentList(PageDto pageDto) {
        Page<DeepNewsComment> page = deepNewsCommentService.pageBySelective(pageDto);
        return new PageResponse<>(page, page.getTotal());
    }
    @PostMapping(value = "/deep/detail/comment")
    public BaseResponse<Integer> insertDeepNewsDetailComment(@RequestBody DeepNewsComment deepNewsComment, Authentication auth) {
        deepNewsComment.setUserId((Integer) auth.getPrincipal());
        return new ResultResponse<>(deepNewsCommentService.insert(deepNewsComment));
    }
    @PutMapping(value = "/deep/detail/comment")
    public BaseResponse<Integer> updateDeepNewsDetailComment(@RequestBody DeepNewsComment deepNewsComment, Authentication auth) {
        deepNewsComment.setUserId((Integer) auth.getPrincipal());
        return new ResultResponse<>(deepNewsCommentService.update(deepNewsComment));
    }
    @DeleteMapping(value = "/deep/detail/comment")
    public BaseResponse<Integer> deleteDeepNewsDetailComment(Integer id) {
        return new ResultResponse<>(deepNewsCommentService.delete(id));
    }
    @PostMapping(value = "deep/detail/comment/like")
    public BaseResponse<Integer> insertDeepNewsDetailCommentLike(@RequestBody DeepNewsCommentLike deepNewsCommentLike, Authentication auth) {
        deepNewsCommentLike.setUserId((Integer) auth.getPrincipal());
        return new ResultResponse<>(deepNewsCommentService.insertLike(deepNewsCommentLike));
    }
    @DeleteMapping(value = "deep/detail/comment/like")
    public BaseResponse<Integer> deleteDeepNewsDetailCommentLike(DeepNewsCommentLike deepNewsCommentLike, Authentication auth) {
        deepNewsCommentLike.setUserId((Integer) auth.getPrincipal());
        return new ResultResponse<>(deepNewsCommentService.deleteLike(deepNewsCommentLike));
    }
    @GetMapping(value = "deep/detail/comment/isLike")
    public BaseResponse<Boolean> isDeepNewsDetailCommentLike(DeepNewsCommentLike deepNewsCommentLike, Authentication auth) {
        if(auth == null) {
            return new ResultResponse<>(false);
        }
        deepNewsCommentLike.setUserId((Integer) auth.getPrincipal());
        return new ResultResponse<>(deepNewsCommentService.isLike(deepNewsCommentLike));
    }
}
