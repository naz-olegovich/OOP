package OOP;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 9130
 * C11 = 0   2 Визначити клас автомобіль, який складається як мінімум з 5-и полів.
 **/


public class Lab4_modified {
    public static void main(String[] args) {
        Student[] arr = {new Student("Yarick", "Vodila", "man", 1, 82),
                new Student("Vlad", "Kabachok", "man", 4, 91),
                new Student("Nastya", "Bat", "woman", 2, 99),
                new Student("Bob", "Corn", "man", 3, 77),
                new Student("Inokentiy", "Volunskiy", "man", 1, 60)
        };

        //Сортування за допомогою нижче визначеного класу і вивід даних за допомогою форматування
        Arrays.sort(arr, new sort_course());
        System.out.println("Масив сортований по курсу студента за зростанням:");
        for (int i = 0; i < arr.length; i++) {
            System.out.format("Ім'я: %-8s  Прізвище: %-10s  Стать: %-5s  Курс:%-1d  Середян оцінка: %-2d\n", arr[i].name, arr[i].surname, arr[i].gender, arr[i].course, arr[i].average_mark);
        }

        //Сортування за допомогою нижче визначеного класу і вивід даних за допомогою форматування
        Arrays.sort(arr, new sort_mark());
        System.out.println("\n\nМасив сортований по середній оцінці студента за спаданням:");
        for (int i = 0; i < arr.length; i++) {
            System.out.format("Ім'я: %-8s  Прізвище: %-10s  Стать: %-5s  Курс:%-1d  Середян оцінка: %-2d\n", arr[i].name, arr[i].surname, arr[i].gender, arr[i].course, arr[i].average_mark);
        }
        //Сортування за алфавітом
        Arrays.sort(arr, new sort_name());
        System.out.println("\n\nМасив сортований за алфавітом:");
        for (int i = 0; i < arr.length; i++) {
            System.out.format("Ім'я: %-8s  Прізвище: %-10s  Стать: %-5s  Курс:%-1d  Середян оцінка: %-2d\n", arr[i].name, arr[i].surname, arr[i].gender, arr[i].course, arr[i].average_mark);
        }

    }
}


//Визначення класу для сортування по курсу за зростанням
class sort_course implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.course - o2.course;
    }
}

//Визначення класу для сортування по середній оцінці за спаданням
class sort_mark implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.average_mark - o1.average_mark;
    }
}


//Визначення класу для сортування по імені за алфавітом
class sort_name implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.codePointAt(0) - o2.name.codePointAt(0);
    }
}