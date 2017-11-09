FROM node:8.8.1

RUN mkdir code

WORKDIR code

RUN npm install -g cordova ionic
RUN npm install -g bower
RUN npm install -g gulp

WORKDIR /code

RUN npm install

EXPOSE 8100

#ENTRYPOINT ["ionic"]
CMD ["ionic", "serve", "--address", "0.0.0.0"]

