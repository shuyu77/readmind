package com.socialapppro.mapper;

import com.socialapppro.domain.entity.Messages;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface MessagesMapper extends BaseMapper<Messages> {

    @Select("SELECT m.message_id, m.receiver_id, m.sender_id, m.sent_at, m.content, " +
            "    CASE " +
            "       WHEN m.sender_id = #{userId} THEN u.username " +
            "       ELSE sender.username " +
            "   END AS username, " +
            "   CASE  " +
            "       WHEN m.sender_id = #{userId} THEN u.picture " +
            "       ELSE sender.picture " +
            "   END AS picture, " +
            "   CASE  " +
            "       WHEN m.sender_id = #{userId} THEN u.user_id " +
            "       ELSE sender.user_id " +
            "   END AS user_id " +
            "FROM ( " +
            "   SELECT * " +
            "   FROM messages " +
            "   WHERE sent_at IN ( " +
            "           SELECT MAX(sent_at) " +
            "           FROM messages " +
            "           WHERE receiver_id = #{userId} OR sender_id = #{userId} " +
            "           GROUP BY CONCAT( " +
            "                IF(sender_id > receiver_id, sender_id, receiver_id), " +
            "                IF(sender_id < receiver_id, sender_id, receiver_id ))) " +
            "       AND( receiver_id = #{userId} OR sender_id = #{userId} ) " +
            "   ORDER BY message_id DESC )m " +
            "JOIN users u ON m.receiver_id = u.user_id " +
            "JOIN users sender ON m.sender_id = sender.user_id " +
            "ORDER BY m.sent_at DESC;")
    List<Messages> listMessageForm(Integer userId);
}
