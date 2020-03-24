package com.capgemini.ims.dao;

import java.time.LocalDate;
import java.util.List;

public interface ProductDAO {
	public List<Integer> getId();
	public String updateproductStatus(int Id, String place, LocalDate date, String status);
	public String getData(int Id);
}
