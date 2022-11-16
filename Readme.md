## 一些异常参考

**1.** Spring默认snakeyaml版本过低问题

描述:

```shell
java.lang.NoSuchMethodError: org.apache.shardingsphere.infra.util.yaml.constructor.ShardingSphereYamlConstructor$1.setCodePointLimit(I)V
```

参考：
https://github.com/apache/shardingsphere/issues/21646

解决：

```shell
<dependency>
    <groupId>org.yaml</groupId>
    <artifactId>snakeyaml</artifactId>
    <version>1.33</version>
</dependency>
```


