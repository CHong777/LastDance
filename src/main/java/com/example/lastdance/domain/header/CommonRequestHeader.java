package com.example.lastdance.domain.header;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
public class CommonRequestHeader {
    private String authKey;
    private String osType;
    private String osVer;
    private String appVer;
    private String appVerCode;
    private String device;
    private String mdn;
}
