-- Вставка пользователей
INSERT INTO users (id, name, email) VALUES
(1, 'Иван Иванов', 'ivan@example.com'),
(2, 'Мария Смирнова', 'maria@example.com'),
(3, 'Алексей Кузнецов', 'alexey@example.com');

-- Обновление последовательности после ручной вставки
SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));


-- Вставка подписок для пользователя 1
INSERT INTO subscriptions (user_id, service_name) VALUES
(1, 'YouTube Premium'),
(1, 'Netflix');

-- Вставка подписок для пользователя 2
INSERT INTO subscriptions (user_id, service_name) VALUES
(2, 'Яндекс.Плюс'),
(2, 'VK Музыка');

-- Вставка подписок для пользователя 3
INSERT INTO subscriptions (user_id, service_name) VALUES
(3, 'Spotify'),
(3, 'Apple Music');

-- Обновление последовательности после ручной вставки
SELECT setval('subscriptions_id_seq', (SELECT MAX(id) FROM subscriptions));

