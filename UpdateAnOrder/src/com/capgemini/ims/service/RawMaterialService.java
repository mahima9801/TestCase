package com.capgemini.ims.service;

import java.time.LocalDate;
import java.util.List;

public interface RawMaterialService {
	public String updateStatusService(int Id, String place,LocalDate date, String status);
	public boolean validateService(int Id);
	public boolean dateValidate(String date);
	public List<Integer>getId();
}
