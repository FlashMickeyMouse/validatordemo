## SpringBoot 使用validation数据校验
### 案例大纲
+ 分组校验
+ 嵌套校验
+ 自定义校验

### 后端对数据进行验证

#### 添加包

hibernate-validator
```
    <!-- https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator -->
        <dependency>
            <groupId>org.hibernate.validator</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>6.0.2.Final</version>
        </dependency>
```
或者添加spring-boot-starter-validation
```
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation -->
     <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
            <version>1.4.0.RELEASE</version>
        </dependency>
```
或者添加spring-boot-starter-web
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```
这两个springboot包里面都包含hibernate-validator包，这三个包只有有一个就可以

### 两个注释

@Valid java 提供的 不含分组  但是可以递归验证
@Validated spring 拓展  会分组  但是不会递归
两个注解均可提示程序走验证