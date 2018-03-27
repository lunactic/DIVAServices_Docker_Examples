FROM divaservices/ocropus
MAINTAINER marcel.wuersch@unifr.ch
RUN apt-get update && apt-get install bash jq wget unzip curl -y
RUN mkdir -p /input/
RUN mkdir -p /output/
COPY ocropageseg.sh /input/
RUN apt-get clean && rm -rf /tmp/* /var/lib/apt/lists/* /var/tmp/* .git
WORKDIR /input
RUN chmod +x *
CMD ["/input/ocropageseg.sh"]