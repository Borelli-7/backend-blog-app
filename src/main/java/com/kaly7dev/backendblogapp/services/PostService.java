package com.kaly7dev.backendblogapp.services;

import com.kaly7dev.backendblogapp.dtos.PostDto;

import java.util.List;

public interface PostService {
    void createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPost(String slug);

    boolean postExistsWithTitle(String title);
}
