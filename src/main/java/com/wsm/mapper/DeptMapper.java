package com.wsm.mapper;

import com.wsm.po.Dept;
import com.wsm.po.DeptExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DeptMapper {
    long countByExample(DeptExample example);

	int deleteByExample(DeptExample example);

	int deleteByPrimaryKey(Integer deptno);

	int insert(Dept record);

	int insertSelective(Dept record);

	List<Dept> selectByExample(DeptExample example);

	Dept selectByPrimaryKey(Integer deptno);

	int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

	int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

	int updateByPrimaryKeySelective(Dept record);

	int updateByPrimaryKey(Dept record);
    List<Dept> findAll();
    void save(Dept d);
    void delete(int deptno);
    void merge(Dept d);
    Dept findByID(int deptno);
}