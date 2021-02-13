package org.blockchain.wallet.controller;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.BaseResponse;
import org.blockchain.wallet.base.PageResponse;
import org.blockchain.wallet.base.ResultResponse;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.DeepNewsComment;
import org.blockchain.wallet.entity.LiveNewsComment;
import org.blockchain.wallet.resttemplate.JinseIRestAPI;
import org.blockchain.wallet.service.DeepNewsCommentService;
import org.blockchain.wallet.service.LiveNewsCommentService;
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
    public BaseResponse<Page> getLiveNewsDetailCommentList(PageDto pageDto) {
        Page<LiveNewsComment> page = liveNewsCommentService.pageBySelective(pageDto);
        return new PageResponse<>(page, page.getTotal());
    }
    @PostMapping(value = "detail/comment")
    public BaseResponse<Integer> insertLiveNewsDetailComment(LiveNewsComment liveNewsComment) {
        return new ResultResponse<>(liveNewsCommentService.insert(liveNewsComment));
    }
    @PutMapping(value = "detail/comment")
    public BaseResponse<Integer> updateLiveNewsDetailComment(LiveNewsComment liveNewsComment) {
        return new ResultResponse<>(liveNewsCommentService.update(liveNewsComment));
    }
    @DeleteMapping(value = "detail/comment")
    public BaseResponse<Integer> deleteLiveNewsDetailComment(Integer id) {
        return new ResultResponse<>(liveNewsCommentService.delete(id));
    }


    @GetMapping(value = "/deep")
    public Object getDeepNewsList(@RequestParam(value = "id", required = false) String id) {
        if(id == null) {
            return jinseIRestAPI.getDeepNewsList("");
        } else {
            return jinseIRestAPI.getDeepNewsList(id);
        }

    }
    @GetMapping(value = "/deep/detail")
    public BaseResponse<String> getDeepNewsDetail(@RequestParam String url) {
        return new ResultResponse<>(jinseIRestAPI.getDeepNewsDetail(url));
    }
    @GetMapping(value = "/deep/detail/comment/list")
    public BaseResponse<Page> getDeepNewsDetailCommentList(PageDto pageDto) {
        Page<DeepNewsComment> page = deepNewsCommentService.pageBySelective(pageDto);
        return new PageResponse<>(page, page.getTotal());
    }
    @PostMapping(value = "/deep/detail/comment")
    public BaseResponse<Integer> insertDeepNewsDetailComment(DeepNewsComment deepNewsComment) {
        return new ResultResponse<>(deepNewsCommentService.insert(deepNewsComment));
    }
    @PutMapping(value = "/deep/detail/comment")
    public BaseResponse<Integer> updateDeepNewsDetailComment(DeepNewsComment deepNewsComment) {
        return new ResultResponse<>(deepNewsCommentService.update(deepNewsComment));
    }
    @DeleteMapping(value = "/deep/detail/comment")
    public BaseResponse<Integer> deleteDeepNewsDetailComment(Integer id) {
        return new ResultResponse<>(deepNewsCommentService.delete(id));
    }
}
