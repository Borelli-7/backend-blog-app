package com.kaly7dev.backendblogapp.controllers;

import com.kaly7dev.backendblogapp.dtos.PostDto;
import com.kaly7dev.backendblogapp.services.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void createPost(@RequestBody @Valid PostDto postDto) {
        postService.createPost(postDto);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }
    @GetMapping("/{slug}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getPost(String slug){
        return postService.getPost(slug);
    }
}
