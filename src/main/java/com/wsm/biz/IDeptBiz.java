package com.wsm.biz;

import java.util.List;

import com.wsm.po.Dept;

public interface IDeptBiz {
	public List<Dept> findAll();
	public void save(Dept d);
	public void delete(int deptno);
	public void merge(Dept d);
	public Dept findById(int deptno);
	public void add();
}
