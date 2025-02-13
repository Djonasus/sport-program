-- Создание таблицы users
CREATE TABLE IF NOT EXISTS public.users (
    user_id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    "name" varchar(255),
    "last_name" varchar(255),
    role varchar(30),
    activated boolean
);

-- Создание таблицы news
CREATE TABLE IF NOT EXISTS public.news (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    "date" VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    body VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.coordinates (
    coordinate_id SERIAL PRIMARY KEY,
    x double precision NOT NULL,
    y double precision NOT NULL,
    "name" varchar,
    description VARCHAR(255)
--    type VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS public.events (
    event_id BIGINT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    type varchar(255),
    "date" VARCHAR(50),
    "time" VARCHAR(50),
    referee_volunteer_id BIGINT,
    max_count_in_one_team INT,
    coordinates_id bigint,
    CONSTRAINT fk_referee FOREIGN KEY (referee_volunteer_id) REFERENCES users(user_id),
    CONSTRAINT fk_coordinates FOREIGN KEY (coordinates_id) REFERENCES coordinates(coordinate_id)
);

CREATE TABLE IF NOT EXISTS public.teams (
    team_id BIGSERIAL PRIMARY KEY,
    event_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    team_num INT NOT NULL,
    CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES events(event_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS public.type_of_event (
    type_id BIGSERIAL PRIMARY KEY,  -- Автоинкрементирующийся первичный ключ
    type VARCHAR(255) NOT NULL,     -- Поле для хранения типа события
    coordinate_id BIGINT,           -- Внешний ключ для связи с таблицей coordinates
    CONSTRAINT fk_coordinate FOREIGN KEY (coordinate_id) REFERENCES coordinates(coordinate_id)  -- Внешний ключ
);




