package com.kh2null.board.Board.Comments;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final CommentsController commentsController;

    public void createComment(Integer post_id, Integer user_id, String content) {
        Comments comment = new Comments();
        comment.setPost_id(post_id);
        comment.setUser_id(user_id);
        comment.setContent(content);
        commentsRepository.save(comment);
    }

    public Comments getCommentById(Integer comment_id) {
        Optional<Comments> comment = commentsRepository.findById(comment_id);
        return comment.orElseThrow(() -> new IllegalArgumentException("Invalid comment ID"));
    }

    public void updateComment(Integer comment_id, String content) {
        Comments comment = getCommentById(comment_id);
        comment.setContent(content);
        commentsRepository.save(comment);
    }

    public void deleteComment(Integer comment_id) {
        commentsRepository.deleteById(comment_id);
    }

}
