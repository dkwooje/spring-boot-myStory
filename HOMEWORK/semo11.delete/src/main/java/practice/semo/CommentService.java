package practice.semo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    public void saveWord(Integer post_id, Integer user_id, String content) {
        Comment1 comment = new Comment1();
        comment.setPost_id(post_id);
        comment.setUser_id(user_id);
        comment.setContent(content);
        commentRepository.save(comment);
    }

    public void deleteWord(Integer comment_id){
        Comment1 cancle = new Comment1();
        cancle.setComment_id(comment_id);
        commentRepository.deleteById(comment_id);
    }

    public void contentfix(Integer comment_id, String content) {
        Comment1 comment = commentRepository.findById(comment_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid comment ID: " + comment_id));
        comment.setContent(content);
        commentRepository.save(comment);
    }
}



