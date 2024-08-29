package com.kh2null.board.Board.Comments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsRepository commentsRepository;
    private final CommentsService commentsService;


    // 댓글 작성
    @PostMapping("/board/post/{post_id}/comment")
    public String createComment(@PathVariable Integer post_id,
                                @RequestParam Integer user_id,
                                @RequestParam String content) {
        commentsService.createComment(post_id, user_id, content);
        return "redirect:/board";
    }

    // 댓글 수정 페이지 이동
    @GetMapping("/board/post/{post_id}/comment/{comment_id}/edit")
    public String editCommentPage(@PathVariable Integer post_id,
                                  @PathVariable Integer comment_id,
                                  Model model) {
        Comments comment = commentsService.getCommentById(comment_id);
        model.addAttribute("fixdata", comment);
        return "editComment";
    }

// 댓글 수정
    @PostMapping("/board/post/{post_id}/comment/{comment_id}/edit")
    public String editComment(@PathVariable Integer post_id,
                              @PathVariable Integer comment_id,
                              @RequestParam String content) {
        commentsService.updateComment(comment_id, content);
        return "redirect:/board";
    }

    // 댓글 삭제 페이지 이동
    @GetMapping("/board/post/{post_id}/comment/{comment_id}/delete")
    public String deleteCommentPage(@PathVariable Integer post_id,
                                    @PathVariable Integer comment_id,
                                    Model model) {
        model.addAttribute("deletedata", comment_id);
        return "deleteComment";
    }

    // 댓글 삭제
    @PostMapping("/board/post/{post_id}/comment/{comment_id}/delete")
    public String deleteComment(@PathVariable Integer post_id,
                                @PathVariable Integer comment_id) {
        commentsService.deleteComment(comment_id);
        return "redirect:/board";
    }


}
