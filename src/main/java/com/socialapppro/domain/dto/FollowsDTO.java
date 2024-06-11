package com.socialapppro.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowsDTO {
    private Integer followId;

    private Integer followerId;

    private Integer followeeId;

    private String followStatus;

    @JsonFormat( pattern = "MM-dd")
    private LocalDateTime createdAt;

    private String picture;

    private String username;

    private String introduction;
}
