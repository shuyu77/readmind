package com.socialapppro.service;

import com.socialapppro.domain.entity.Messages;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface MessagesService extends IService<Messages> {

    List<Messages> listMessageForm(Integer userId);

    List<Messages> ListChat(Integer userId, Integer senderId);
}
