package com.socialapppro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.socialapppro.domain.entity.Messages;
import com.socialapppro.mapper.MessagesMapper;
import com.socialapppro.service.MessagesService;
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
public class MessagesServiceImpl extends ServiceImpl<MessagesMapper, Messages> implements MessagesService {

    @Autowired
    private  MessagesMapper messagesMapper;
    @Override
    public List<Messages> listMessageForm(Integer userId) {
        return messagesMapper.listMessageForm(userId);
    }

    @Override
    public List<Messages> ListChat(Integer userId, Integer senderId) {
        QueryWrapper<Messages> wrapper = new QueryWrapper<>();
        wrapper.eq("sender_id", userId).eq("receiver_id", senderId)
                .or()
                .eq("sender_id", senderId).eq("receiver_id", userId)
                .orderByAsc("sent_at");
        return messagesMapper.selectList(wrapper);
    }
}
