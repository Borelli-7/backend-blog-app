package com.kaly7dev.backendblogapp.mappers;

import com.kaly7dev.backendblogapp.client.SlugServiceClient;
import com.kaly7dev.backendblogapp.config.SlugServiceProperties;
import com.kaly7dev.backendblogapp.dtos.PostDto;
import com.kaly7dev.backendblogapp.models.Post;
import com.kaly7dev.backendblogapp.models.PostDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class PostMapper {
    private final SlugServiceClient slugServiceClient;

    public Post mapToPost(PostDto postDto, Post post){
        post.setTitle(postDto.title());

        PostDetails postDetails= new PostDetails();
        postDetails.setBody(postDto.body());
        postDetails.setPostStatus(postDto.postStatus());
        postDetails.setSlug(slugServiceClient.getSlug(post.getTitle()));
        postDetails.incrementViewCount();
        postDetails.setCreatedAt(LocalDateTime.now());

        post.setPostDetails(postDetails);
        log.info(" map to Post successfull ! ");
        return post;
    }
    public PostDto mapToDto(Post post){
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getPostDetails().getBody(),
                post.getPostDetails().getSlug(),
                post.getPostDetails().getPostStatus(),
                post.getPostDetails().getCreatedAt(),
                post.getPostDetails().getUpdatedAt()
        );
    }
}
