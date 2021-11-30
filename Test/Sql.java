import com.zjw.Domain.User;
import com.zjw.Mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sql {

    @Test
    public void selectUserByAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/zjw/Config/xml/spring-mybatis.xml");
        //通过容器获取Bean实例
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = userMapper.selectUserByAll("yx492366323");
        System.out.println(user.toString());
    }
}
