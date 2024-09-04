package practice.semo.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private Integer user_id;
    private Integer post_id;
    private Integer comment_id;
    private String content;

   public CommentDto(String content, Integer comment_id) {
        this.content = content;
        this.comment_id = comment_id;
    }

    public CommentDto(String content , Integer comment_id, Integer user_id, Integer post_id) {
        this.content = content;
        this.comment_id = comment_id;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public CommentDto(String content , Integer post_id, Integer user_id) {
        this.content = content;
        this.post_id = post_id;
        this.user_id = user_id;

    }
    public CommentDto(){}
}