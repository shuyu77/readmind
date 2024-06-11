package com.socialapppro.controller;


import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Messages;
import com.socialapppro.service.MessagesService;
import com.socialapppro.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
@RestController
@RequestMapping("/messages")
public class MessagesController {
    @Autowired
    private MessagesService messagesService;
    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id")Integer id){
        boolean remove=this.messagesService.removeById(id);
        if(!remove){
            return ResultVOUtil.fail();
        }
        else{
            return ResultVOUtil.success(null);
        }
    }
    @GetMapping("/list")
    public ResultVO<List<Messages>> list(){
        List<Messages> messages = messagesService.list();
        return ResultVO.success(messages);
    }

    @GetMapping("/listMessageForm/{userId}")
    public ResultVO listMessageForm(@PathVariable("userId")Integer userId){
        if(userId == null) return  ResultVOUtil.fail();
        List<Messages> messagesList = messagesService.listMessageForm(userId);
        return ResultVOUtil.succeed(messagesList);
    }

    @GetMapping("/ListChat/{userId}/{senderId}")
    public ResultVO ListChat(@PathVariable("userId")Integer userId, @PathVariable("senderId")Integer senderId){
        if(userId == null || senderId == null) return  ResultVOUtil.fail();
        List<Messages> messagesList = messagesService.ListChat(userId, senderId);
        return ResultVOUtil.succeed(messagesList);
    }

    @PostMapping("/saveMessage")
    public ResultVO saveMessage(@RequestBody Messages newmessages){
        if(messagesService.save(newmessages)){
            return ResultVOUtil.succeed(null);
        }
        return ResultVOUtil.fail();
    }

}

