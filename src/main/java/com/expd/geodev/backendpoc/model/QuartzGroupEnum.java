package com.expd.geodev.backendpoc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuartzGroupEnum {

    T1( "测试分组1"),
    T2("测试分组2"),
    DEPARTURE_NOTICE("发车通知");

    private final String value;

}
