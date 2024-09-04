package practice.semo.post;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;


    @GetMapping("/post")
    String post(){
        return "postMenu.html";
    }

    @GetMapping("/post/write-form")
    String write(){

        return "postWrite.html";
    }
    @GetMapping("/post/edit-form")
    String edit(){
        return "postEdit.html";
    }
    @GetMapping("/post/delete-form")
    String delete(){
        return "postDelete.html";
    }



}
