FROM mysql:5.6



ENV MYSQL_DATABASE=product 
ENV MYSQL_ROOT_PASSWORD=root



ADD deploy/Database/ddl.sql /docker-entrypoint-initdb.d



EXPOSE 3306