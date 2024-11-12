INSERT INTO public.news (title, date, url, body, author)
VALUES 
  ('Заголовок новости 1', '2023-10-26', 'https://example.com/news1', 'Текст новости 1', 'Автор 1'),
  ('Заголовок новости 2', '2023-10-25', 'https://example.com/news2', 'Текст новости 2', 'Автор 2'),
  ('Заголовок новости 3', '2023-10-24', 'https://example.com/news3', 'Текст новости 3', 'Автор 3')
ON CONFLICT (title) DO NOTHING;