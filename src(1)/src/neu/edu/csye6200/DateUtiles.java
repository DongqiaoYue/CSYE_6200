package neu.edu.csye6200;


import java.util.Date;

// 01-1998 MM-yyyy
public class DateUtiles {
    //assume 1 > 2
    public static int getMonthDiff(int year1, int year2, int month1, int month2) {
        int monthDiff = 0;
        if (year1 > year2 || (year1 == year2 && month1 >= month2)) {
            int yearGap = year1 - year2;
            int monthGap = month1 - month2;
            monthDiff = yearGap * 12 + monthGap;
        }else {
            return -getMonthDiff(year2, year1, month2, month1);
        }
        return monthDiff;
    }

    public static int getMonth(String str){

        String[] strs = str.split("-");
        return Integer.valueOf(strs[0]);

    }

    public static int getYear(String str){
        String[] strs = str.split("-");
        return Integer.valueOf(strs[1]);

    }

    public static String getStr(int year, int month){

        return month + "-" + year;

    }

    public static int getMonthDiff(String date1, String date2){
        int year1 = getYear(date1);
        int year2 = getYear(date2);
        int month1 = getMonth(date1);
        int month2 = getMonth(date2);
        return getMonthDiff(year1,year2,month1,month2);
    }

    public static void main(String[] args) {
        System.out.println(DateUtiles.getMonthDiff("2-2021","2-2021"));
        System.out.println(DateUtiles.getMonthDiff("12-1998","2-2021"));
    }
}
