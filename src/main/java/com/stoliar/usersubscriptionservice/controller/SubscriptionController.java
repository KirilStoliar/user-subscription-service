package com.stoliar.usersubscriptionservice.controller;

import com.stoliar.usersubscriptionservice.dto.SubscriptionDto;
import com.stoliar.usersubscriptionservice.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Operation(summary = "Добавить подписку пользователю", description = "Добавляет подписку конкретному пользователю по ID")
    @ApiResponse(responseCode = "201", description = "Подписка успешно добавлена")
    @PostMapping("/{id}/subscriptions")
    public ResponseEntity<SubscriptionDto> addSubscription(@PathVariable Long id, @RequestBody SubscriptionDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionService.addSubscription(id, dto));
    }

    @Operation(summary = "Получить подписки пользователя", description = "Возвращает список подписок пользователя по его ID")
    @ApiResponse(responseCode = "200", description = "Список подписок получен")
    @GetMapping("/{id}/subscriptions")
    public ResponseEntity<List<SubscriptionDto>> getUserSubscriptions(@PathVariable Long id) {
        return ResponseEntity.ok(subscriptionService.getUserSubscriptions(id));
    }

    @Operation(summary = "Удалить подписку пользователя", description = "Удаляет подписку по ID пользователя и названию подписки")
    @ApiResponse(responseCode = "204", description = "Подписка удалена")
    @DeleteMapping("/{id}/subscriptions/{subName}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id, @PathVariable String subName) {
        subscriptionService.deleteSubscription(id, subName);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Получить ТОП-3 популярных подписок", description = "Возвращает 3 наиболее популярных подписки среди всех пользователей")
    @ApiResponse(responseCode = "200", description = "ТОП-3 подписок получен")
    @GetMapping("/subscriptions/top")
    public ResponseEntity<List<SubscriptionDto>> getTopSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getTopSubscriptions());
    }
}

