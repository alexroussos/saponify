# Introduction

Saponify is a soap recipe calculator. It is still a work in progress.

Some random commands to help me remember things:
  
Local db config - create user and db, point config to db:

    pg_ctl start
    createuser -s alex
    createdb -U alex Saponify
    export DATABASE_URL=postgres://alex:pw@localhost:5432/Saponify

Push to github, heroku:
    
    git push origin master
    git push heroku master

Run locally:

    mvn package && foreman start
    
Test post locally:

    curl -H "Content-Type: application/json" -X POST -d '{"fullName":"billy b","jobTitle":"engineer"}' http://localhost:5000/people
  
Connect to remote db:
    
  heroku pg:psql
    
Run db migration:

    java -jar target/saponify-SNAPSHOT-0.1.0.jar db migrate saponify.yml

Drop all:

    java $JAVA_OPTS -jar target/saponify-0.1.0-SNAPSHOT.jar db drop-all --confirm-delete-everything saponify.yml
