package com.socialapppro.service.impl;

import com.socialapppro.domain.entity.PostTags;
import com.socialapppro.domain.entity.Posts;
import com.socialapppro.mapper.PostTagsMapper;
import com.socialapppro.service.PostTagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class PostTagsServiceImpl extends ServiceImpl<PostTagsMapper, PostTags> implements PostTagsService {
    @Autowired
    PostTagsMapper postTagsMapper;

    @Override
    public List<Posts> getAll(Integer id){
        return postTagsMapper.getPosts(id);
    }
}
