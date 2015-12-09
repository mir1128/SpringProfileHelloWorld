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

	<beans profile="dev">		<bean id="cDPlayer" class="com.loobo.DevelopCDPlayer"/>	</beans>
	<beans profile="dev">		<bean id="cDPlayer" class="com.loobo.ProductionCDPlayer"/>	</beans>
	
##  激活Profile

通过两个属性激活`spring.profiles.default`和`spring.profiles.active`激活的方式有：
1. DispatcherServlet初始化参数
2. 通过web应用的context parameter
3. JNDI
4. 环境变量
5. JVM系统属性
6. 系统集成测试(用@ContextConfiguration注解加载context配置的测试)

通过context parameter配置
	<context-param>    	<param-name>spring.profiles.default</param-name>    	<param-value>dev</param-value>	</context-param>

通过DispatcherServlet参数配置

	<servlet>    	<servlet-name>appServlet</servlet-name>    	<servlet-class>      		org.springframework.web.servlet.DispatcherServlet    	</servlet-class>    	<init-param>      		<param-name>spring.profiles.default</param-name>      		<param-value>dev</param-value>    	</init-param>    	<load-on-startup>1</load-on-startup>	</servlet>  	<servlet-mapping>    	<servlet-name>appServlet</servlet-name>    	<url-pattern>/</url-pattern>	</servlet-mapping>

在测试中
	
	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(classes = {DevelopmentProfileConfig.class, ProductionProfileConfig.class})
	@ActiveProfiles("production")
	public class ProductionCDPlayerTest {
		... ...
	}
	
	