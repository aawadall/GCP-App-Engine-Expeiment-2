# Dockerfile bootstrapped from https://mherman.org/blog/dockerizing-a-react-app/
FROM node:10-alpine

WORKDIR /app

ENV PATH=/app/node_modules/.bin:$PATH
ENV PORT=8080
COPY package.json /app/package.json
COPY ./public/ /app/public/
COPY ./src/ /app/src/
RUN npm install --silent
RUN npm install react-scripts@3.0.1 -g --silent
RUN ls
CMD ["npm", "start"]

EXPOSE 8080