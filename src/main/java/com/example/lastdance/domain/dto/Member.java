package com.example.lastdance.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Member {
    private Long memberId;
    @NonNull
    private String userId;
    @NonNull private String name;
    @NonNull private String password;

}