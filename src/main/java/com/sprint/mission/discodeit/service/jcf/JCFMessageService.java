package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.MessageService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JCFMessageService implements MessageService {
    private final Map<UUID, Message> data;

    public JCFMessageService(){
        this.data = new HashMap<>();
    }

    @Override
    public Message update(UUID messageId, String content) {
        Message message = find(messageId);
        message.update(content);
        return message;
    }

    @Override
    public Message create(UUID channelId, UUID authorId, String content){
        Message message = new Message(channelId, authorId, content);
        data.put(message.getId(), message);
        return message;
    }

    @Override
    public Message find(UUID messageId){
        Message message = data.get(messageId);
        if(message == null){
            throw new IllegalArgumentException("메시지를 찾을 수 없습니다. id=" + messageId);
        }
        return message;
    }

    @Override
    public List<Message> findAll(){
        return new ArrayList<>(data.values());
    }

    @Override
    public void delete(UUID messageId){
        if(!data.containsKey(messageId)){
            throw new IllegalArgumentException("메시지를 찾을 수 없습니다. id=" + messageId);
        }
        data.remove(messageId);
    }
}
