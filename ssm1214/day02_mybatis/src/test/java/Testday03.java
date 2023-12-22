import com.atguigu.mybatis.mapper.EmployeeMapper;
import com.atguigu.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Testday03 {
    @Test
    public void testParam() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //            通过SqlSessionFactory获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //            获取EmployeeMapper的代理对象【com.sun.proxy.$proxy6】
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        测试多个普通参数
//        List<Employee> zhangshan = mapper.selectEmpByOpr("zhangshan", 1645.0);
//        System.out.println("zhangshan = " + zhangshan);

//        测试Pojo参数
        Employee employee = new Employee();
        employee.setLastName("zhangshan");
        employee.setSalary(1645.0);

//        List<Employee> employees = mapper.selectEmpByPojo(employee);
//        for (Employee employee1 : employees) {
//            System.out.println("employee1 = " + employee1);
//        }
//        测试命名参数
        List<Employee> employees = mapper.selectEmpByNamed("zhangshan", 1645.0);
        for (Employee employee1 : employees) {
            System.out.println("employee1 = " + employee1);
        }
        System.out.println("更新1");
    }
}
