#Contruir imagem
#    docker build -t <IMAGE-NAME> -f ./Dockerfile .
#Rodar os testes
#    docker run --ipc=host -v "$PWD/target:/usr/target" <IMAGE-NAME>:latest mvn test -Dcucumber.filter.tags=@Tag -Denv=des
FROM mcr.microsoft.com/playwright/java:v1.31.0-focal
WORKDIR /usr
COPY . /usr
ENV TZ=America/Sao_Paulo
RUN mvn dependency:go-offline -B