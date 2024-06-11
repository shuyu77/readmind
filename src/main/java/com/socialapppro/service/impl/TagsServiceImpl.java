package com.socialapppro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.socialapppro.domain.entity.Tags;
import com.socialapppro.mapper.TagsMapper;
import com.socialapppro.service.TagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.socialapppro.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements TagsService {

    @Autowired
    private TagsMapper tagsMapper;
    @Override
    public void add(Tags tags) {
        tags.setCreatedAt(LocalDateTime.now());
        tagsMapper.add(tags);
    }

    @Override
    public List<Tags> findByName(Integer name) {
        QueryWrapper<Tags> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("tag_name",name);
        List<Tags> tags=this.tagsMapper.selectList(queryWrapper);
        return (List<Tags>) ResultVOUtil.success(tags);
    }

    @Override
    public void update(Tags tags) {
        tagsMapper.update(tags);
    }

}
