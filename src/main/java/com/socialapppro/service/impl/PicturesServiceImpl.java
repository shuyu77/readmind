package com.socialapppro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.socialapppro.domain.entity.Pictures;
import com.socialapppro.mapper.PicturesMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.socialapppro.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-04-07
 */
@Service
public class PicturesServiceImpl extends ServiceImpl<PicturesMapper, Pictures> implements PicturesService {
    @Autowired
    PicturesMapper picturesMapper;

    @Override
    public List<Pictures> getImageBypostId(Integer postId) {
        QueryWrapper<Pictures> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Posts_id",postId);
        return picturesMapper.selectList(queryWrapper);
    }
}
