import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmployeeMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestResultMap {
    @Test
    public void testResultMap() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        测试自定义映射【resultMap】
//        List<Employee> employees = mapper.selectEmpAndDeptByEmpId(1);
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }

//        测试自定义映射-Association
//        Employee employee = mapper.selectEmpAndDeptByEmpIdAssociation(3);
//        System.out.println("employee = " + employee);

//        测试association的分布查询
        Employee employee = mapper.selectEmpAndDeptByEmpIdAssociationStep(1);
        System.out.println("employee = " + employee.getLastName());
        System.out.println("====================================");
        System.out.println("employee.getDept() = " + employee.getDept());

    }
    @Test
    public void testOneToMoreCollection() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.selectDeptAndEmpByDeptId(1);
        System.out.println("dept = " + dept);
    }

}
