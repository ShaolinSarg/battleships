FROM clojure:alpine

ENV BATTLESHIP_TOKEN "323"

COPY . /usr/src/app

WORKDIR /usr/src/app

CMD ["lein", "ring", "server-headless"]
