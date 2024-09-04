package practice.semo.comment;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;



   @GetMapping("/menu")
   String menu(Model model){

       List<Comment1> comments = commentRepository.findAll();
       List<CommentDto> result = comments.stream()
               .map(comment -> new CommentDto(comment.getContent(), comment.getComment_id(), comment.getUser_id(),comment.getPost_id()))
               .collect(Collectors.toList());
        model.addAttribute("words", result);
        return "commentMenu.html";
   }

    @GetMapping("menu/write")
    String write(){return "commentWrite.html";}

    @PostMapping("menu/save")
    String saveword( CommentDto commentDto) {
        commentService.saveWord(commentDto);
        return "commentMenu.html";
    }

    @GetMapping("/comment/edit/{comment_id}")
    String edit(@PathVariable Integer comment_id, Model model){
        Optional<Comment1> result = commentRepository.findById(comment_id);
        if(result.isPresent()){
            Comment1 comment = result.get();
            CommentDto commentDto = new CommentDto(comment.getContent(), comment.getComment_id());
            model.addAttribute("ed",commentDto);
            return "commentEdit.html";
        }else{
            return "commentMenu.html";
        }
    }

    @GetMapping("/comment/delete/{comment_id}")
    String delete(@PathVariable Integer comment_id, Model model){
       Optional<Comment1> result = commentRepository.findById(comment_id);
       if(result.isPresent()){
           Comment1 comment = result.get();
           CommentDto commentDto = new CommentDto(comment.getContent(), comment.getComment_id());
           model.addAttribute("dl", commentDto);
           return "commentDelete.html";
       }else{
           return "commentMenu.html";
       }
    }

    @PostMapping("/delete/{comment_id}")
    String delete(@PathVariable Integer comment_id){
       commentService.deleteWord(comment_id);
        return "commentMenu.html";
    }

    @PostMapping("/comment/contentfix/{comment_id}")
    public String fixedit(@PathVariable Integer comment_id, String content) {
        commentService.contentfix(comment_id, content);
        return "commentMenu.html";
    }

    @GetMapping("/menu/page/{abc}")
    String getListPage(Model model, @PathVariable Integer abc) {

        Page<Comment1> result = commentRepository.findPageBy(PageRequest.of(abc -1, 5));
        result.getTotalPages(); //전체페이지 개수 알려줌
        result.hasNext();//다음페이지 있는지 알려줌
        model.addAttribute("words", result);
        return "commentMenu.html";
    }

}

