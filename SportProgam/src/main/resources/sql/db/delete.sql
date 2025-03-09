-- Удаление таблицы teams (дочерняя таблица)
DROP TABLE IF EXISTS public.teams;

-- Удаление таблицы events (дочерняя таблица)
DROP TABLE IF EXISTS public.events;

-- Удаление таблицы news (независимая таблица)
DROP TABLE IF EXISTS public.news;

-- Удаление таблицы users (родительская таблица)
DROP TABLE IF EXISTS public.users;

DROP TABLE IF EXISTS public.type_of_event;

-- Удаление таблицы coordinates (дочерняя таблица)
DROP TABLE IF EXISTS public.coordinates;