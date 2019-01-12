package com.wsm.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsm.mapper.DeptMapper;
import com.wsm.po.Dept;

@Service(value="deptbiz")
@Transactional// --为整个类添加事务
public class DeptBiz implements IDeptBiz{
	@Resource
	private DeptMapper deptMapper;

	@Override
	public List<Dept> findAll() {
		return deptMapper.findAll();
	}
	
	@Override
	public void save(Dept d) {
		deptMapper.save(d);
	}
	//@Transactional//添加事务 ---为单个方法添加事务
	@Override
	public void delete(int deptno) {
		deptMapper.delete(deptno);
	}

	@Override
	public void merge(Dept d) {
		deptMapper.merge(d);
	}

	@Override
	public Dept findById(int deptno) {
		return deptMapper.findByID(deptno);
	}
	public void add() {
		Dept d=new Dept();
		d.setDeptno(7);
		d.setDname("学术部");
		d.setLoc("济南");
		Dept d1=new Dept();
		d.setDeptno(7);
		d.setDname("市场部");
		d.setLoc("长清");
		deptMapper.insert(d);
		deptMapper.insert(d1);
		
	}
	
}
