package csv1;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileUtil.demo();
		System.out.println("---------------------------List of Teacher & Student & Person-----------------------");
		Person.demo();
		Teacher.demo();
		Student.demo();
		
	}

}


//--------------------------List of Student------------------------
//Student [studentID=74565, GPA=3.92, ID=75467, Age=34, FirstName=Hou, LastName=Liu, ParentFirstName=Wu, ParentLastName=Wu]
//Student [studentID=15645, GPA=3.85, ID=34567, Age=24, FirstName=Liu, LastName=Yang, ParentFirstName=Peng, ParentLastName=Fei]
//Student [studentID=65641, GPA=3.95, ID=65154, Age=13, FirstName=Shang, LastName=Ou, ParentFirstName=Yu, ParentLastName=Huang]
//Student [studentID=25656, GPA=3.45, ID=98416, Age=27, FirstName=Hang, LastName=Yu, ParentFirstName=Qiu, ParentLastName=Fei]
//--------------------------List of Teacher------------------------
//Teacher [hourlyWage=6000, ID=16545, Age=26, FirstName=Lang, LastName=Ou, ParentFirstName=Feng, ParentLastName=Liu]



//---------------------------List of Teacher & Student & Person-----------------------
//Person [ID=45367, age=13, firstName=Wang, lastName=Wang, parentFirstName=Pao, parentLastName=Liu]
//Teacher [HourlyWage=8000, Age=34, FirstName=Dundun, LastName=Yue]
//Teacher [HourlyWage=9000, Age=34, FirstName=De, LastName=Tue]
//Teacher [HourlyWage=7000, Age=34, FirstName=Du, LastName=Tue]
//Teacher [HourlyWage=8700, Age=34, FirstName=Den, LastName=Yu]
//Student [GPA=3.6, Age=23, FirstName=Dongqiao, LastName=Yue]
//Student [GPA=3.87, Age=56, FirstName=Xunuo, LastName=Yuan]
//Student [GPA=3.45, Age=67, FirstName=Sheng, LastName=Yuan]
//Student [GPA=3.57, Age=45, FirstName=Li, LastName=Li]



//----------------------------Sort by ID----------------------------
//Student [studentID=56876, GPA=3.57, ID=46576, Age=45, FirstName=Li, LastName=Li, ParentFirstName=Xing, ParentLastName=Peng]
//Student [studentID=67546, GPA=3.87, ID=64573, Age=56, FirstName=Xunuo, LastName=Yuan, ParentFirstName=Kun, ParentLastName=Yun]
//Student [studentID=54344, GPA=3.45, ID=67857, Age=67, FirstName=Sheng, LastName=Yuan, ParentFirstName=Yang, ParentLastName=Liu]
//Student [studentID=98416, GPA=3.6, ID=98234, Age=23, FirstName=Dongqiao, LastName=Yue, ParentFirstName=Xinya, ParentLastName=Cao]
//--------------------------Sort by StudentID-----------------------
//Student [studentID=54344, GPA=3.45, ID=67857, Age=67, FirstName=Sheng, LastName=Yuan, ParentFirstName=Yang, ParentLastName=Liu]
//Student [studentID=56876, GPA=3.57, ID=46576, Age=45, FirstName=Li, LastName=Li, ParentFirstName=Xing, ParentLastName=Peng]
//Student [studentID=67546, GPA=3.87, ID=64573, Age=56, FirstName=Xunuo, LastName=Yuan, ParentFirstName=Kun, ParentLastName=Yun]
//Student [studentID=98416, GPA=3.6, ID=98234, Age=23, FirstName=Dongqiao, LastName=Yue, ParentFirstName=Xinya, ParentLastName=Cao]
//--------------------------Sort by Last Name-----------------------
//Student [studentID=56876, GPA=3.57, ID=46576, Age=45, FirstName=Li, LastName=Li, ParentFirstName=Xing, ParentLastName=Peng]
//Student [studentID=54344, GPA=3.45, ID=67857, Age=67, FirstName=Sheng, LastName=Yuan, ParentFirstName=Yang, ParentLastName=Liu]
//Student [studentID=67546, GPA=3.87, ID=64573, Age=56, FirstName=Xunuo, LastName=Yuan, ParentFirstName=Kun, ParentLastName=Yun]
//Student [studentID=98416, GPA=3.6, ID=98234, Age=23, FirstName=Dongqiao, LastName=Yue, ParentFirstName=Xinya, ParentLastName=Cao]
//--------------------------Sort by First Name----------------------
//Student [studentID=98416, GPA=3.6, ID=98234, Age=23, FirstName=Dongqiao, LastName=Yue, ParentFirstName=Xinya, ParentLastName=Cao]
//Student [studentID=56876, GPA=3.57, ID=46576, Age=45, FirstName=Li, LastName=Li, ParentFirstName=Xing, ParentLastName=Peng]
//Student [studentID=54344, GPA=3.45, ID=67857, Age=67, FirstName=Sheng, LastName=Yuan, ParentFirstName=Yang, ParentLastName=Liu]
//Student [studentID=67546, GPA=3.87, ID=64573, Age=56, FirstName=Xunuo, LastName=Yuan, ParentFirstName=Kun, ParentLastName=Yun]
//----------------------------Sort by GPA---------------------------
//Student [studentID=54344, GPA=3.45, ID=67857, Age=67, FirstName=Sheng, LastName=Yuan, ParentFirstName=Yang, ParentLastName=Liu]
//Student [studentID=56876, GPA=3.57, ID=46576, Age=45, FirstName=Li, LastName=Li, ParentFirstName=Xing, ParentLastName=Peng]
//Student [studentID=98416, GPA=3.6, ID=98234, Age=23, FirstName=Dongqiao, LastName=Yue, ParentFirstName=Xinya, ParentLastName=Cao]
//Student [studentID=67546, GPA=3.87, ID=64573, Age=56, FirstName=Xunuo, LastName=Yuan, ParentFirstName=Kun, ParentLastName=Yun]