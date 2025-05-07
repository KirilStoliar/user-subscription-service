package com.stoliar.usersubscriptionservice.service;

import com.stoliar.usersubscriptionservice.dto.SubscriptionDto;
import com.stoliar.usersubscriptionservice.entity.Subscription;
import com.stoliar.usersubscriptionservice.entity.User;
import com.stoliar.usersubscriptionservice.mapper.SubscriptionMapper;
import com.stoliar.usersubscriptionservice.repository.SubscriptionRepository;
import com.stoliar.usersubscriptionservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subRepo;
    private final UserRepository userRepo;
    private final SubscriptionMapper subscriptionMapper;

    public SubscriptionDto addSubscription(Long userId, SubscriptionDto dto) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Subscription sub = subscriptionMapper.toEntity(dto, user);
        return subscriptionMapper.toDto(subRepo.save(sub));
    }

    public List<SubscriptionDto> getUserSubscriptions(Long userId) {
        return subRepo.findByUserId(userId).stream()
                .map(subscriptionMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteSubscription(Long userId, String subName) {
        Subscription sub = subRepo.findByUserIdAndServiceName(userId, subName);
        if (sub == null) {}
        new EntityNotFoundException("Подписка не найдена для пользователя: " + userId + ", сервис: " + subName);
        subRepo.delete(sub);
    }

    public List<SubscriptionDto> getTopSubscriptions() {
        return subRepo.findTopSubscriptions(PageRequest.of(0, 3)).stream()
                .map(obj -> new SubscriptionDto(null, (String) obj[0]))
                .collect(Collectors.toList());
    }
}

