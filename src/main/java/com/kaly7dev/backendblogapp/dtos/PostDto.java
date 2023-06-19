package com.kaly7dev.backendblogapp.dtos;

import com.kaly7dev.backendblogapp.models.PostStatus;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record PostDto(String id,
                      @NotBlank  String title,
                      @NotBlank String body,
                      String slug,
                      PostStatus postStatus,
                      LocalDateTime createdAt,
                      LocalDateTime updatedAt
                      ) {

}
