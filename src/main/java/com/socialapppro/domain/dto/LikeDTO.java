package com.socialapppro.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeDTO {
    private Integer likeId;

    private Integer userId;

    private Integer postId;

    @JsonFormat( pattern = "MM-dd")
    private LocalDateTime createdAt;

    private String picture;

    private String username;

    private String introduction;

    private String images;
}
