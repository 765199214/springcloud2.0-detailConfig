项目运行注意点：
1、分别移除yml中有关的eureka注册的配置
2、分别去除掉启动类中@EnableEurekaClient的注解信息。
3、需要在consumer(消费者)中配置别名对应的host+port信息，不然无法请求！