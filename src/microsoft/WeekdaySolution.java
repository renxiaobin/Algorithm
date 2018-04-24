package microsoft;

public class WeekdaySolution {
    public static void main(String[] args) {
        int currentYear = 2018;
        int weekday = 2;
        int years = 400;
        System.out.println(getWeekday(currentYear,weekday,years));
    }

    private static int getWeekday(int currentYear, int weekday, int years) {
        int days = years+getRyear(currentYear,years);
        return (days%7+weekday)%7;
    }

    private static int getRyear(int currentYear, int years) {
        int result = years/4;
        int temp = currentYear;
        while (temp<=currentYear+years){
            if(temp%100==0 && temp%400!=0)
                result--;
            temp++;
        }
        return result;
    }
}
