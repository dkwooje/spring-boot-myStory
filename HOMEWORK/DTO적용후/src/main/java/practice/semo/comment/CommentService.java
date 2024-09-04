package practice.semo.comment;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void saveWord(CommentDto commentDto) {

        Comment1 comment1 = new Comment1();

        comment1.setContent(commentDto.getContent());
        comment1.setPost_id(commentDto.getPost_id());
        comment1.setUser_id(commentDto.getUser_id());

        commentRepository.save(comment1);
    }

    public void deleteWord(Integer comment_id){
        commentRepository.deleteById(comment_id);
    }

    public void contentfix(Integer comment_id, String content) {
        /*
        Comment1 comment = commentRepository.findById(comment_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid comment ID: " + comment_id));
        comment.setContent(content);
        commentRepository.save(comment);

         */
        Optional<Comment1> result = commentRepository.findById(comment_id);
        if(result.isPresent()){
            Comment1 comment1 = result.get();
            comment1.setContent(content);
            commentRepository.save(comment1);
        }else{
            throw new IllegalArgumentException("Invalid comment ID: " + comment_id);
        }
    }


}




