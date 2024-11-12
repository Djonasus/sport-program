CREATE TABLE public.news (
  id SERIAL PRIMARY KEY,
  title varchar(255) NOT NULL,
  date varchar(255) NOT NULL,
  url text NOT NULL,
  body text NOT NULL,
  author varchar(255) NOT NULL

);