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
```shell
    volumes:
      - './mysql/my.cnf:/etc/mysql/my.cnf"
```


## 3.数据库文件信息
```shell
    volumes:
      - './mysql/data/mysql-data/db-hz:/var/lib/mysql:rw'
```
