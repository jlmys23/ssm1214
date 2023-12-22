import com.atguigu.mybatis.mapper.EmployeeMapper;
import com.atguigu.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void testMybatisInsert(){

        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//            通过SqlSessionFactory获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
//            获取EmployeeMapper的代理对象【com.sun.proxy.$proxy6】
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

//            测试添加员工信息
            Employee employee = new Employee(null, "lisi", "zss@.com", 122345.0);
//            int i = employeeMapper.insertEmployee(employee);
//            System.out.println("i = " + i);
            boolean b = employeeMapper.insertEmployee(employee);
            System.out.println("b = " + b);

//            获取新增员工id
            System.out.println("employee.getId() = " + employee.getId());

//            测试删除
//            employeeMapper.deleteEmployeeById(4);

//            测试修改
//            Employee employee = new Employee(5,"zhangshan123","z123s@.com",1612345.0);
//            employeeMapper.updateEmployee(employee);

//            测试查询所以员工信息
//            List<Employee> employees = employeeMapper.selectAllEmps();
//            for (Employee employee : employees) {
//                System.out.println("employee = " + employee);
//            }
//            提交事务
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
