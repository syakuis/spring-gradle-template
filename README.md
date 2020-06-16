# Spring Gradle Template

## TODO

- [ ] checkstyle setting

## Installing Gradle 6.5

https://docs.gradle.org/current/userguide/installation.html

spring boot 2.3.x 부터 gradle 6.x 버전 필요

```
$ ./gradlew wrapper --gradle-version=6.5
```

## 개발 모드시 spring profile props 설정하는 방법

`application-default.yml` 파일을 생성하여 아래와 같이 작성하거나 원하는 설정을 추가하세요.

```yaml
logging:
  level:
    org.springframework: debug
    io.github.syakuis: trace
    org.hibernate.SQL: trace
    org.hibernate.type.descriptor.sql: trace
    org.hibernate.type.descriptor.sql.BasicBinder: trace
```