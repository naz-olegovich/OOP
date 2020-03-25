package Lab4;

public class Student {
    //Визначення полів класу
    public String name;
    public String surname;
    public String gender;
    public int course;
    public int average_mark;

    //Метод ініціалізації (Конструктор) класу
    public Student (String s_name, String s_surname, String s_gender, int s_course, int s_averadge_mark){
        name = s_name;
        surname = s_surname;
        gender = s_gender;
        course = s_course;
        average_mark = s_averadge_mark;
    }
}
