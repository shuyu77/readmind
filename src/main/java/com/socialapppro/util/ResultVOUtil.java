package com.socialapppro.util;

import com.socialapppro.VO.ResultVO;

public class ResultVOUtil {
    public  static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(object);
        return resultVO;
    }

    public static  ResultVO fail(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(-1);
        return resultVO;
    }

//    成功
    public  static ResultVO succeed(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(200);
        resultVO.setData(object);
        return resultVO;
    }

//    客户端数据错误
    public  static ResultVO clienterror(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(400);
        resultVO.setData(object);
        return resultVO;
    }

//    服务器错误
    public  static ResultVO servererror(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(500);
        resultVO.setData(object);
        return resultVO;
    }
}
