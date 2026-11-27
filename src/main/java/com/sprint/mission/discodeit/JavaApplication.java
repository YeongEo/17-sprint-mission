package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.jcf.JCFChannelService;
import com.sprint.mission.discodeit.service.jcf.JCFMessageService;
import com.sprint.mission.discodeit.service.jcf.JCFUserService;

import static com.sprint.mission.discodeit.entity.ChannelType.PUBLIC;

public class JavaApplication {
    public static void main(String[] args){
        //user
        //user
        UserService userService = new JCFUserService();

        User woody = userService.create("woody", "woody@codeit.com", "woody1234");
        userService.create("buzz", "buzz@codeit.com", "buzz1234");

        System.out.println("단건 조회: " + userService.find(woody.getId()));
        System.out.println("다건 조회: " + userService.findAll().size() + "명");

        userService.update(woody.getId(), "woody2", "woody@codeit.com", "newpass");
        System.out.println("수정 후: " + userService.find(woody.getId()));

        try{
            userService.find(woody.getId());
            System.out.println("삭제 확인: 실패");
        } catch (IllegalArgumentException e){
            System.out.println("삭제 확인: 성공 (" + e.getMessage() + ")");
        }
        System.out.println("삭제 후: " + userService.findAll().size() + "명");

        try{
            userService.delete(woody.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("삭제 확인: " + e.getMessage());
        }

        //Channel
        //Channel
        ChannelService channelService = new JCFChannelService();

        Channel notice  = channelService.create(PUBLIC, "공지", "공지 채널입니다.");
        channelService.create(ChannelType.PRIVATE, "관리", "관리 채널입니다.");

        System.out.println("단건 조회: " + channelService.find(notice.getId()));
        System.out.println("다건 조회: " + channelService.findAll().size() + "개");

        channelService.update(notice.getId(),PUBLIC, "공지", "공지 채널입니다.");
        System.out.println("수정 후: " + channelService.find(notice.getId()));

        try{
            channelService.find(notice.getId());
            System.out.println("삭제 확인: 실패");
        } catch (IllegalArgumentException e){
            System.out.println("삭제 확인: 성공 (" + e.getMessage() + ")");
        }
        System.out.println("삭제 후: " + channelService.findAll().size() + "명");

        try{
            channelService.delete(notice.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("삭제 확인: " + e.getMessage());
        }

        //Message
        //Message
        MessageService messageService = new JCFMessageService();

        Message hello = messageService.create(notice.getId(), woody.getId(), "안녕하세요." );

        System.out.println("단건 조회: " + messageService.find(hello.getId()));
        System.out.println("다건 조회: " + messageService.findAll().size() + "개");

        messageService.update(hello.getId(),"수정된 메시지 내용");
        System.out.println("수정 후: " + messageService.find(hello.getId()));

        try{
            messageService.find(hello.getId());
            System.out.println("삭제 확인: 실패");
        } catch (IllegalArgumentException e){
            System.out.println("삭제 확인: 성공 (" + e.getMessage() + ")");
        }
        System.out.println("삭제 후: " + messageService.findAll().size() + "명");

        try{
            messageService.delete(hello.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("삭제 확인: " + e.getMessage());
        }
    }
}
