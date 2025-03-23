FROM node:18 AS build
 # Используем официальный образ Node.js для сборки
 # Устанавливаем рабочую директорию
WORKDIR /app

 # Копируем package.json и package-lock.json (если есть)
COPY package*.json ./

 # Устанавливаем зависимости
RUN npm install

 # Копируем все файлы проекта
COPY . .

 # Собираем проект
RUN npm run build

 # Используем Nginx для обслуживания собранного приложения
FROM nginx:alpine

 # Копируем сгенерированные файлы в папку, которую будет использовать Nginx
COPY --from=build /app/build /usr/share/nginx/html

 # Открываем порты (по умолчанию 80 для Nginx)
EXPOSE 80

 # Запускаем Nginx
CMD ["nginx", "-g", "daemon off;"]
