package com.socialapppro.controller;

import com.socialapppro.VO.ResultVO;
import com.socialapppro.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@ResponseBody
@Slf4j
public class UploadController {

    @Value("${images.path}")
    private String basePath;


    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ResultVO upload(MultipartFile file) {
        System.out.println(file);
        //原始文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //使用UUID重新生成一个文件名,防止文件名重复造成文件覆盖
        String fileName = UUID.randomUUID().toString() + suffix;

        //创建一个目录
        File dir = new File(basePath);
        //判断当前目录是否存在
        if (!dir.exists()) {
            //如果目录不存在就直接创建
            dir.mkdirs();
        }
        try {
            //将临时文件转存到执行位置
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultVOUtil.succeed(fileName);
    }
}