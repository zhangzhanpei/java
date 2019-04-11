### 一、默认情况下，`@Controller`、`@Service` 等都是单例的
### 二、可使用 `@Scope(value = "prototype")` 将实例声明为多实例的，分以下情况   
1、只声明 Controller 不声明 Service，则所有 Controller 引用同一个 Service，因为 Service 在容器中是唯一的。   
2、只声明 Service 不声明 Controller，则同一个 Controller 中引用同一个 Service，多个 Controller 则引用不同的 Service。因为 Controller 是单例的，生成 Controller 实例时引入了 Service，下次再走这个 Controller 时依然是同一个 Service 变量。   
3、同时声明 Controller 和 Service，则每次都实例化新的 Service 实例。   
