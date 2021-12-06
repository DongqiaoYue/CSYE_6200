package edu.neu.csye6200;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NortheasternU northeastern = new NortheasternU();
		northeastern.Demo();
	}

}

//------------------Show the state of NortheasternU object-------------------
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//
//-------------------Sort Students by NATURAL ORDER----------------
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//
//------------------Sort Employees by NATURAL ORDER----------------
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//
//------------------------Sort by Age-------------------------
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//
//------------------------Sort by Id--------------------------
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//
//-------------------------Sort Last Name---------------------------
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//
//-----------------------Sort First Name-----------------------
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//
//-----------------------Sort GPA-----------------------
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//
//-----------------------Sort Wage-----------------------
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//
