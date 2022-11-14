import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
//        First level: 1. Создайте объект класса LocalDate, указывая дату своего рождения.
//а) Вывести на консоль день недели, день в году, месяц, год.
//б) Создайте  объект класса LocalDate, представляющий текущее время.
//в) Сравните его со своим днем рождения используя методы isAfter(), isBefore().

        LocalDate birthDate = LocalDate.of(1990, Month.APRIL, 21);
        System.out.println(birthDate);
        LocalDate currentTime = LocalDate.now();
        System.out.println(currentTime);
        System.out.println(birthDate.isAfter(currentTime));
        System.out.println(birthDate.isBefore(currentTime));

//Распечатать график праздников на текущий год используя форматирование.

        String[] holidays = {"Saturday, January, 1, 2022", "Thursday, January, 6, 2022",
                "Sunday, April, 17, 2022", "Monday, April, 18, 2022",
                "Sunday, May, 1, 2022", "Tuesday, May, 3, 2022",
                "Sunday, June, 5, 2022",
                "Thursday, June, 16, 2022", "Monday, August, 15, 2022",
                "Tuesday, November, 1, 2022", "Friday, November, 11, 2022",
                "Sunday, December, 25, 2022", "Monday, December, 26, 2022"};
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM, dd, yyyy");
        for (String holiday : holidays) {
            try {
                Date date = sdf.parse(holiday);
                System.out.println(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
