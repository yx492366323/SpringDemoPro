import com.zjw.Domain.User;
import com.zjw.Mapper.UserMapper;
import com.zjw.Service.Impl.MyUserDetailsServiceImpl;
import com.zjw.Service.Impl.UserServiceImpl;
import com.zjw.Service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class Sql {

    @Test
    public void selectUserByAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("file:T:/IdeaProjects/SpringDemoPro/web/WEB-INF/spring-mybatis.xml");
        //通过容器获取Bean实例
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        MyUserDetailsServiceImpl myUserDetailsService = (MyUserDetailsServiceImpl) applicationContext.getBean("myUserDetailsService");
        User user = userMapper.selectUserByInfo("yx492366323");
        List<User> users = userMapper.fineUsersByField("idcard","2019");
        for(User userone:users)
            System.out.println(userone);
        System.out.println(user.toString());
        System.out.println(myUserDetailsService.loadUserByUsername("yx492366323"));
    }

    @Test
    public void verifyPasswd(){
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("file:T:/IdeaProjects/SpringDemoPro/web/WEB-INF/spring-mybatis.xml");
        //通过容器获取Bean实例
        UserMapper userMapper = (UserMapper) applicationContext1.getBean("userMapper");
        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("file:T:/IdeaProjects/SpringDemoPro/web/WEB-INF/applicationContext.xml");
        //通过容器获取Bean实例
        UserService userService = (UserServiceImpl) applicationContext2.getBean("userService");
        userService.changePassword("209015227","admin","张佳伟");
        User user = userService.selectUserByInfo("yx492366323");
    }

}
