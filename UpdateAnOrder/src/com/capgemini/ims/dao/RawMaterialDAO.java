package com.capgemini.ims.dao;

import java.time.LocalDate;
import java.util.List;

public interface RawMaterialDAO {
	public List<Integer> getId();
	public String updaterawStatus(int Id, String place,LocalDate date, String status);
	public String getData(int Id);
}
