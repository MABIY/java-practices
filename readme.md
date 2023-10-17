# local sonatype nexus
```shell
docker run --restart=always -d -p 8081:8081 --name nexus -v ~/test/nexus-data:/nexus-data sonatype/nexus3:3.60.0
```
