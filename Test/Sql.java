import com.zjw.Domain.User;
import com.zjw.Mapper.UserMapper;
import com.zjw.Service.Impl.MyUserDetailsServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sql {

    @Test
    public void selectUserByAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        //ͨ��������ȡBeanʵ��
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        MyUserDetailsServiceImpl myUserDetailsService = (MyUserDetailsServiceImpl) applicationContext.getBean("myUserDetailsService");
        User user = userMapper.selectUserByAll("yx492366323");
        System.out.println(user.toString());
        System.out.println(myUserDetailsService.loadUserByUsername("yx492366323"));
    }
}
