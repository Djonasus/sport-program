# Спорт-Пульс

## Описание проекта

"Спорт-Пульс" - это интерактивная платформа для поиска спортивных мероприятий и площадок. Приложение позволяет пользователям находить ближайшие спортивные локации, создавать и присоединяться к спортивным событиям, а также получать актуальную информацию о спортивных мероприятиях в вашем районе.

### Основные возможности

- **Интерактивная карта спортивных локаций**: Поиск спортивных площадок, стадионов, тренажерных зон и других мест для активного отдыха
- **Создание и участие в мероприятиях**: Возможность организовать собственное спортивное событие или присоединиться к существующему
- **Личный кабинет пользователя**: Управление профилем, отслеживание участия в мероприятиях
- **Новостная лента**: Актуальная информация о спортивных событиях

## Архитектура проекта

Проект построен на основе микросервисной архитектуры и состоит из следующих компонентов:

### Backend (SportProgam)

- **Технологии**: Java 21, Spring Boot 3.3.5, Spring Security, Spring Data JPA
- **База данных**: PostgreSQL
- **Аутентификация**: JWT (JSON Web Token)
- **Документация API**: Swagger (OpenAPI)

### Frontend (source-frontend)

- **Технологии**: React 18, React Bootstrap, React Router
- **Карты**: Яндекс Карты (через @pbe/react-yandex-maps)
- **HTTP-клиент**: Axios

### Основные модули системы

- **Authentication**: Регистрация, авторизация и управление пользователями
- **Coordinates**: Управление геолокациями спортивных объектов
- **Events**: Создание и управление спортивными мероприятиями
- **News**: Управление новостным контентом
- **Images**: Хранение и управление изображениями

## Установка и запуск

### Требования

- Docker и Docker Compose
- Git

### Шаги по установке

1. Клонируйте репозиторий:
   ```bash
   git clone <url-репозитория>
   cd sport-program
   ```

2. Запустите приложение с помощью Docker Compose:
   ```bash
   docker-compose up -d
   ```

   Эта команда запустит все необходимые сервисы в фоновом режиме:
   - PostgreSQL (база данных) на порту 5443
   - Backend (Spring Boot) на порту 8082
   - Frontend (React) на порту 3000

3. Откройте приложение в браузере:
   ```
   http://localhost:3000
   ```

## Структура проекта

```
├── SportProgam/            # Backend на Spring Boot
│   ├── src/                # Исходный код
│   ├── Dockerfile          # Конфигурация Docker для backend
│   └── pom.xml             # Конфигурация Maven
│
├── source-frontend/        # Frontend на React
│   ├── src/                # Исходный код
│   ├── public/             # Статические файлы
│   └── Dockerfile          # Конфигурация Docker для frontend
│
└── docker-compose.yaml     # Конфигурация Docker Compose
```

## Использование приложения

1. **Регистрация и вход**: Создайте аккаунт или войдите в систему
2. **Просмотр карты**: Исследуйте спортивные локации на интерактивной карте
3. **Создание события**: Выберите локацию и создайте новое спортивное мероприятие
4. **Участие в событиях**: Присоединяйтесь к существующим мероприятиям
5. **Управление профилем**: Отслеживайте свою активность в личном кабинете

## Разработка

### Backend (SportProgam)

Для локальной разработки backend:

```bash
# Запуск только базы данных
docker-compose up database -d

# Запуск Spring Boot приложения
cd SportProgam
./mvnw spring-boot:run
```

### Frontend (source-frontend)

Для локальной разработки frontend:

```bash
cd source-frontend
npm install
npm start
```

## Лицензия

Данный проект распространяется под лицензией [указать лицензию].