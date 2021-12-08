# Back-End Code Eric Boutique
## Edit Data Model
https://plantuml.com/class-diagram

## Installation
- Install the docker to the machine
- Go to document folder to start the PostgresSQL database
```bash
docker-compose -f .\docker-compose.postgres.yml up -d
```
- Open CLI in Docker-Desktop to access database and see if it works with this syntax: psql -U <user-name> -W <database-name>
```
psql -U postgres -W code-tutor
```