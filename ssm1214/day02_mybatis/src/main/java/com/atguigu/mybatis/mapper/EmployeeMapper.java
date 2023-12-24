package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Employee;
import com.sun.org.apache.xpath.internal.objects.XObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
//    通过id获取员工信息
    public Employee selectEmpById(int empId);
//    添加员工信息
    public boolean insertEmployee(Employee employee);
//    删除员工信息
    public void deleteEmployeeById(int empId);
//    修改员工信息
    public void updateEmployee(Employee employee);
//    查询所以员工信息
    public List<Employee> selectAllEmps();
//    通过员工姓名及薪资查询员工信息【多个普通参数】
    public List<Employee> selectEmpByOpr(String lastName,double salary);
//    通过员工姓名及薪资查询员工信息【POJPO参数】
    public List<Employee> selectEmpByPojo(Employee employee);
    //    通过员工姓名及薪资查询员工信息【命名参数】
    public List<Employee> selectEmpByNamed(@Param("lName") String lastName,
                                           @Param("salary") double salary);
//    通过员工姓名及薪资查询员工信息【Map参数】
    public List<Employee> selectEmpByMap(Map<String, Object> map);
}
