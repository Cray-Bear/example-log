# 1.中文乱码问题及解决
参考: https://github.com/docker-library/mysql/issues/131
```shell
    command:
      - '--character-set-server=utf8mb4'
      - '--collation-server=utf8mb4_general_ci'
      
    environment:
      TZ: Asia/Shanghai
      LANG: C.UTF-8
```

## 2.自定义my.cnf配置
新增配置：
```YML
    volumes:
      - './mysql/my.cnf:/etc/mysql/my.cnf"
```

完整配置：
```YML
version: '3.3'
services:
  db-hz:
    image: mysql:5.7
    container_name: mysql-hz
    environment:
      MYSQL_DATABASE: 'db_hz'
      MYSQL_USER: 'query'
      MYSQL_PASSWORD: 'nJze!CmT'
      MYSQL_ROOT_PASSWORD: '65y*pXQbWw1&%h9x'
      MYSQL_ROOT_HOST: '%'
      TZ: Asia/Shanghai
      LANG: C.UTF-8
    ports:
      - '13306:3306'
    expose:
      - '13306'
    volumes:
      - './mysql/initial.sql:/docker-entrypoint-initdb.d/initial.sql:rw'
      - './mysql/my.cnf:/etc/mysql/my.cnf"
    command:
      - '--character-set-server=utf8mb4'
      - '--collation-server=utf8mb4_general_ci'
```


## 3.数据库文件信息
新增配置：
```YML
    volumes:
      - './mysql/my.cnf:/etc/mysql/my.cnf"
```
完整配置：
```YML
version: '3.3'
services:
  db-hz:
    image: mysql:5.7
    container_name: mysql-hz
    environment:
      MYSQL_DATABASE: 'db_hz'
      MYSQL_USER: 'query'
      MYSQL_PASSWORD: 'nJze!CmT'
      MYSQL_ROOT_PASSWORD: '65y*pXQbWw1&%h9x'
      MYSQL_ROOT_HOST: '%'
      TZ: Asia/Shanghai
      LANG: C.UTF-8
    ports:
      - '13306:3306'
    expose:
      - '13306'
    volumes:
      - './mysql/initial.sql:/docker-entrypoint-initdb.d/initial.sql:rw'
      - './mysql/data/mysql-data/db-hz:/var/lib/mysql:rw'
    command:
      - '--character-set-server=utf8mb4'
      - '--collation-server=utf8mb4_general_ci'
```
