-- Создание таблицы role
CREATE TABLE IF NOT EXISTS public.role (
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(255) UNIQUE NOT NULL
);

-- Создание таблицы users
CREATE TABLE IF NOT EXISTS public.users (
    user_id SERIAL PRIMARY KEY,
    login VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id INTEGER,
    FOREIGN KEY (role_id) REFERENCES public.role(role_id)
);

-- Создание таблицы news
CREATE TABLE IF NOT EXISTS public.news (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    date VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    body VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS public.coordinate (
    coordinate_id SERIAL PRIMARY KEY,
    x double precision  NOT NULL,
    y double precision  NOT NULL,
    description VARCHAR(255),
    type VARCHAR(50)
);