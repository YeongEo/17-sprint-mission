package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;
import com.sprint.mission.discodeit.service.ChannelService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JCFChannelService implements ChannelService {
    private final Map<UUID, Channel> data;

    public JCFChannelService(){
        this.data = new HashMap<>();
    }

    @Override
    public Channel create(ChannelType type, String name, String description){
        Channel channel = new Channel(type, name, description);
        data.put(channel.getId(), channel);
        return channel;
    }

    @Override
    public Channel find(UUID channelId){
        Channel channel = data.get(channelId);
        if(channel == null){
            throw new IllegalArgumentException("채널을 찾을 수 없습니다. id=" + channelId);
        }
        return channel;
    }

    @Override
    public List<Channel> findAll(){
        return new ArrayList<>(data.values());
    }

    @Override
    public Channel update(UUID channelId, ChannelType type, String name, String description){
        Channel channel = find(channelId);
        channel.update(type, name, description);
        return channel;
    }

    @Override
    public void delete(UUID channelId){
        if(!data.containsKey(channelId)){
            throw new IllegalArgumentException("채널을 찾을 수 없습니다. id=" + channelId);
        }
        data.remove(channelId);
    }
}
