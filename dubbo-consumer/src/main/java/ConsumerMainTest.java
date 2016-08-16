import cn.com.env.base.model.User;
import cn.com.env.base.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhubaoyuan
 * @date 2016/8/16 13:57
 */
public class ConsumerMainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:dubbo-consumer.xml");
        context.start();
        IUserService demoService = (IUserService) context.getBean("userService"); // 获取远程服务代理
        User user = demoService.findUserById(1); // 执行远程方法
        System.out.println(user.getUsername());
    }
}
