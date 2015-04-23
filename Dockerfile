FROM java:8
RUN mkdir /app
ADD target/shopping-cart-cf-app-1.0.0.jar /app/
ADD bootInDocker.sh /app/
WORKDIR /app
RUN chmod a+x bootInDocker.sh

EXPOSE 8080

CMD /app/bootInDocker.sh