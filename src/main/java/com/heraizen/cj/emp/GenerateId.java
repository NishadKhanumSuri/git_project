package com.heraizen.cj.emp;

public enum GenerateId {
		obj;
		static int empNo=1;
		public static int  generateEmpno()
		{
			return empNo++;
		}
	}

