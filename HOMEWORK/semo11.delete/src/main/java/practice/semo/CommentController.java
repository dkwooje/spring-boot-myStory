package practice.semo;


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
           model.addAttribute("ed", result.get());
           return "commentEdit.html";
       } else {
           return "commentMenu.html";
       }
   }

    @GetMapping("/comment/delete/{comment_id}")
    String dele(@PathVariable Integer comment_id, Model model) {

        Optional<Comment1> result = commentRepository.findById(comment_id);
        if (result.isPresent()) {
            model.addAttribute("dl", result.get());
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
        // 댓글 수정 서비스 호출
        commentService.contentfix(comment_id, content);
        // 수정 후 리다이렉트할 페이지로 이동
        return "commentMenu.html"; // 리다이렉트 경로 수정
    }



}
