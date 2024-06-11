package com.socialapppro.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {
    private Integer code;
    private T data;
    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(0, data);
    }

    //快速返回操作成功响应结果
    public static ResultVO success() {
        return new ResultVO(0, null);
    }

    public static ResultVO error() {
        return new ResultVO(1, null);
    }
}
