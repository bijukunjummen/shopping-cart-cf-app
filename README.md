Start redis using `redis-server`
Run using mvn spring-boot:run

Access Page at http://localhost:8080

Now, if you want a little more interesting set-up with [docker-compose](https://docs.docker.com/compose/). 

just run `docker-compose up` and a set-up with redis, two instances of this app, fronted with nginx should start up 
and be available at `http://docker-ip` url(in mac typically http://192.168.59.103)

TODO:
=====
1.  ~~Shopping cart with Session holding the details of a cart~~
2.  ~~Remove/Update items in a cart~~
3.  ~~Templating~~
4.  Negative cases/errors
5.  Potentially integration with Spring security to show the user details being held in session
6.  Ability for admin users to add Product/Category
7.  ~~Category to product drill down~~
8.  Clean up UI
