package com.kaly7dev.backendblogapp.validation;

import com.kaly7dev.backendblogapp.models.Post;
import com.kaly7dev.backendblogapp.services.PostService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public record BlogPostTitleValidator(
        PostService postService) implements ConstraintValidator<DuplicateBlogTitle, Post> {
    @Override
    public void initialize(DuplicateBlogTitle constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Post post, ConstraintValidatorContext constraintValidatorContext) {
         if(!post.getTitle().isBlank() && postService.postExistsWithTitle(post.getTitle())){
             constraintValidatorContext.disableDefaultConstraintViolation();
             constraintValidatorContext.buildConstraintViolationWithTemplate("{TitleAlreadyExists}")
                     .addPropertyNode("Title")
                     .addConstraintViolation();
             return false;
         }
        return true;
    }
}
