# 用@Profile注解控制使用的bean


## 给bean声明使用的环境

如果使用java类做配置:

	@Configuration
	@Profile("production")
	public class ProductionProfileConfig {
    	@Bean
    	public CDPlayer cdPlayer() {
        	return new ProductionCDPlayer();
    	}
	}

也可以在用到方法上	

	@Configuration
	public class ProductionProfileConfig {
    	@Bean
    	@Profile("production")
    	public CDPlayer cdPlayer() {
        	return new ProductionCDPlayer();
    	}
	}
	
如果使用xml文件配置

	<beans profile="dev">




通过两个属性激活`spring.profiles.default`和`spring.profiles.active`

2. 通过web应用的context parameter
3. JNDI
4. 环境变量
5. JVM系统属性
6. 系统集成测试(用@ContextConfiguration注解加载context配置的测试)

通过context parameter配置


通过DispatcherServlet参数配置

	<servlet>

在测试中
	
	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(classes = {DevelopmentProfileConfig.class, ProductionProfileConfig.class})
	@ActiveProfiles("production")
	public class ProductionCDPlayerTest {
		... ...
	}

	