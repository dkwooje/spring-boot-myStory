package practice.semo.comment;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;



   @GetMapping("/menu")
   String menu(Model model){
       List<Comment1> result = commentRepository.findAll();
       model.addAttribute("words",result);
       return "commentMenu.html";
   }

    @GetMapping("menu/write")
    String write(){
        return "commentWrite.html";
    }

   @PostMapping("/save")
   String saveWord(Integer post_id, Integer user_id, String content){
       commentService.saveWord(post_id, user_id, content);
       return  "commentMenu.html";
   }


   @GetMapping("/comment/edit/{comment_id}")
    String edit(@PathVariable Integer comment_id, Model model) {

       Optional<Comment1> result = commentRepository.findById(comment_id);
       if (result.isPresent()) {
           Comment1 comment = result.get();
           CommentDto commentDto = new CommentDto(comment.getContent(), comment.getComment_id());
           model.addAttribute("ed", commentDto);
           return "commentEdit.html";
       } else {
           return "commentMenu.html";
       }
   }

    @GetMapping("/comment/delete/{comment_id}")
    String dele(@PathVariable Integer comment_id, Model model) {

        Optional<Comment1> result = commentRepository.findById(comment_id);
        if (result.isPresent()) {
            Comment1 comment = result.get();
            CommentDto commentDto = new CommentDto(comment.getContent(), comment.getComment_id());
            model.addAttribute("dl", commentDto);
            return "commentDelete.html";
        } else {
            return "commentMenu.html";
        }
    }

    @GetMapping("/delete/{comment_id}")
    String delete(@PathVariable Integer comment_id){
       commentService.deleteWord(comment_id);
        return "commentMenu.html";
    }

    @PostMapping("/comment/contentfix/{comment_id}")
    public String fixedit(@PathVariable Integer comment_id, String content) {
        commentService.contentfix(comment_id, content);
        return "commentMenu.html";
    }

}

class CommentDto {   //DTO 비밀번호 가리기
    public Integer user_id;    //public을 표현해야 한다.
    public Integer post_id;
    public Integer comment_id;
    public String content;

    CommentDto(String A , Integer B) { //
        this.content = A;
        this.comment_id = B;
    }
}