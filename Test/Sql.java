import com.zjw.Domain.User;
import com.zjw.Mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sql {

    @Test
    public void selectUserByAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/zjw/Config/xml/spring-mybatis.xml");
        //ͨ��������ȡBeanʵ��
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = userMapper.selectUserByAll("yx492366323");
        System.out.println(user.toString());
    }
}
