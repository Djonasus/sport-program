INSERT INTO public.news (title, date, url, body, author)
VALUES 
  ('Заголовок новости 1', '2023-10-26', '/api/image/12', 'Текст новости 1', 'Автор 1'),
  ('Заголовок новости 2', '2023-10-25', '/api/image/13', 'Текст новости 2', 'Автор 2'),
  ('Заголовок новости 3', '2023-10-24', '/api/image/14', 'Текст новости 3', 'Автор 3')
ON CONFLICT (title) DO NOTHING;