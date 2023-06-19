package com.kaly7dev.backendblogapp.services;

import com.kaly7dev.backendblogapp.dtos.PostDto;
import com.kaly7dev.backendblogapp.exceptions.PostNotFoundException;
import com.kaly7dev.backendblogapp.mappers.PostMapper;
import com.kaly7dev.backendblogapp.models.Post;
import com.kaly7dev.backendblogapp.repositories.PostRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    private final PostMapper postMapper;
    @Override
    public void createPost(PostDto postDto) {
        Post post= new Post();
        post= postMapper.mapToPost(postDto, post);
        postRepo.save(post);
        log.info("post created successfully ! ");
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<PostDto> postDtoList= postRepo.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .toList();
        log.info("All posts listed successfully ! ");
        return postDtoList;
    }

    @Override
    public PostDto getPost(String slug) {
        Post post= getPostBySlug(slug);
        PostDto postDto= postMapper.mapToDto(post);
        log.info("Post by slug {} found successfully", slug);
        return postDto;
    }

    @Override
    public boolean postExistsWithTitle(String title) {
        return postRepo.findByTitle(title);
    }

    private Post getPostBySlug(String slug) {
        return postRepo.findBySlug(slug)
                .orElseThrow(()-> new PostNotFoundException("Cannot find by slug - " +slug));
    }
}
