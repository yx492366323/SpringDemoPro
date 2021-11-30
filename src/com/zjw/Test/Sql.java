import com.zjw.Domain.User;
import com.zjw.Mapper.UserMapper;
import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Sql {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void selectUserByAll(){
        User user = userMapper.selectUserByAll("yx492366323");
        System.out.println(user.toString());
    }
}
