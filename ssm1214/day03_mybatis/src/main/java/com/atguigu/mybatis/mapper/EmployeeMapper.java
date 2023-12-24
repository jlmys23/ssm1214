package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

//    通过员工id获取员工信息及员工所属的部门信息
    public List<Employee> selectEmpAndDeptByEmpId(int empId);

    public Employee selectEmpAndDeptByEmpIdAssociation(int empId);
    /*通过员工id获取员工信息及员工所属部门的部门信息【分布查询】
        1.先通过员工id获取员工信息【id、last_lame、email、salary、dept_id】
        2.再通过部门id获取部门信息【dept_id、dept_name】
    */
    public Employee selectEmpAndDeptByEmpIdAssociationStep(int empId);
}
