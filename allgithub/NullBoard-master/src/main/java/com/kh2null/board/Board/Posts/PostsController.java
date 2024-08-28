package com.kh2null.board.Board.Posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostsController {

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update")
    public String postsUpdate() {
        return "posts-update";
    }

    @GetMapping("/posts")
    public String posts() {
        return "posts";
    }


}
