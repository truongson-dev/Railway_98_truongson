package com.vti.entity;

import java.util.Comparator;

public class Department implements Comparator<Department> {
	public int id;
	public String name;

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compare(Department d1, Department d2) {
		return d1.name.compareTo(d2.name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Department that = (Department) obj;
		return name != null ? name.equals(that.name) : that.name == null;
	}
}