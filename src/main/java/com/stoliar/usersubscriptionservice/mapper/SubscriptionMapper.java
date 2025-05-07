package com.stoliar.usersubscriptionservice.mapper;

import com.stoliar.usersubscriptionservice.dto.SubscriptionDto;
import com.stoliar.usersubscriptionservice.entity.Subscription;
import com.stoliar.usersubscriptionservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMapper {

    public SubscriptionDto toDto(Subscription sub) {
        return new SubscriptionDto(sub.getId(), sub.getServiceName());
    }

    public Subscription toEntity(SubscriptionDto dto, User user) {
        Subscription sub = new Subscription();
        sub.setServiceName(dto.serviceName());
        sub.setUser(user);
        return sub;
    }
}
