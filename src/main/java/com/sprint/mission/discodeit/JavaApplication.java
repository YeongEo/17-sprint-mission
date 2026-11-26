package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.jcf.JCFUserService;

public class JavaApplication {
    public static void main(String[] args){
        //user
        UserService userService = new JCFUserService();

        User woody = userService.create("woody", "woody@codeit.com", "woody1234");
        userService.create("buzz", "buzz@codeit.com", "buzz1234");

        System.out.println("단건 조회: " + userService.find(woody.getId()));
        System.out.println("다건 조회: " + userService.findAll().size() + "명");

        userService.update(woody.getId(), "woody2", "woody@codeit.com", "newpass");
        System.out.println("수정 후: " + userService.find(woody.getId()));

        userService.delete(woody.getId());
        System.out.println("삭제 후: " + userService.find(woody.getId()));

        userService.delete(woody.getId());
        System.out.println("삭제 후: " + userService.findAll().size() + "명");
        try{
            userService.delete(woody.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("삭제 확인: " + e.getMessage());
        }

        //Channel
        UserService userService = new JCFUserService();

        User woody = userService.create("woody", "woody@codeit.com", "woody1234");
        userService.create("buzz", "buzz@codeit.com", "buzz1234");

        System.out.println("단건 조회: " + userService.find(woody.getId()));
        System.out.println("다건 조회: " + userService.findAll().size() + "명");

        userService.update(woody.getId(), "woody2", "woody@codeit.com", "newpass");
        System.out.println("수정 후: " + userService.find(woody.getId()));

        userService.delete(woody.getId());
        System.out.println("삭제 후: " + userService.find(woody.getId()));

        userService.delete(woody.getId());
        System.out.println("삭제 후: " + userService.findAll().size() + "명");
        try{
            userService.delete(woody.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("삭제 확인: " + e.getMessage());
        }
    }
}
