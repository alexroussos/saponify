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

    curl -H "Content-Type: application/json" -X POST -d '{"name": "coconut", "sapNaoh": 0.183}' http://localhost:5000/ingredient
    
Connect to locat db:

    psql -h localhost -p 5432 -U alex Saponify
  
Connect to remote db:

    heroku pg:psql
    
Run db migration:

    java -jar target/saponify-SNAPSHOT-0.1.0.jar db migrate saponify.yml

Drop all:

    java $JAVA_OPTS -jar target/saponify-0.1.0-SNAPSHOT.jar db drop-all --confirm-delete-everything saponify.yml
    
IntelliJ run config:
![Config to run in IntelliJ](https://www.evernote.com/shard/s23/sh/57099c2c-deda-4684-ab91-952d2601dc11/bb866fd4e77f9d5d81ee5b7c5079925e/res/f46a76bc-87e6-4cf2-8f50-71781c9719dc/skitch.png)
