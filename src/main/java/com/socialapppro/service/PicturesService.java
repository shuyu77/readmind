package com.socialapppro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.socialapppro.domain.entity.Pictures;

import java.util.List;

public interface PicturesService extends IService<Pictures> {
    List<Pictures> getImageBypostId(Integer postId);
}
