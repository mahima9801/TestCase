package com.capgemini.ims.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.capgemini.ims.model.RawMaterialModel;

public class RawMaterial{
	public RawMaterial(int i, String string, LocalDate of) {
	}
	static Map<Integer, RawMaterialModel> raw = new HashMap<Integer, RawMaterialModel>();
	static
	{
		raw.put(1001, new RawMaterialModel(1001, "Kanpur",LocalDate.of(2020, 03, 24), "Dispatched"));
		raw.put(1002, new RawMaterialModel(1002, "Pune",LocalDate.of(2019, 02, 21),"Not Delivered"));
		raw.put(1003, new RawMaterialModel(1003, "Mumbai",LocalDate.of(2019, 07, 21),"Packaging"));
		raw.put(1004, new RawMaterialModel(1004, "Gurugram",LocalDate.of(2020, 01, 01),"Not Delivered"));
		}
	static public Map<Integer, RawMaterialModel> get()
	{
		return raw;
	}

}
