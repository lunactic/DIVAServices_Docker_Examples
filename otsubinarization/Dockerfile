FROM anapsix/alpine-java:8
MAINTAINER marcel.wuersch@unifr.ch
RUN apk update
RUN apk add curl bash nano
RUN mkdir -p /output
RUN mkdir -p /input
COPY algorithm.zip /input/algorithm.zip
COPY script.sh /input/script.sh
RUN unzip /input/algorithm.zip -d /input
WORKDIR /input
RUN chmod +x *
CMD ["/input/script.sh"]

