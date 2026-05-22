package components;


import static com.codeborne.selenide.Selenide.$;

public class CalendarComponents {
    public void setData(String month, String year, String day) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);


        String daySelector = String.format(".react-datepicker__day--%03d", Integer.parseInt(day));
        $(daySelector).click();
    }
}
