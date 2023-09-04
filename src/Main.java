//������� 2. ������ 1. ������ � �������

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 30/*10_000_000*/; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        persons.stream()
                .forEach(System.out::println);

        System.out.println("Task 1");
        //����� ���������� ������������������ (�.�. ����� ������ 18 ���).
        persons.stream()
                .filter(x -> (x.getAge() < 18))
                //.collect(Collectors.toList())
                .count();
        
        //�������� ������ ������� ����������� (�.�. ������ �� 18 � �� 27 ���).
        System.out.println("Task 2");
        persons.stream()
                .filter(x -> (x.getSex() == Sex.MAN))
                .filter(x -> (x.getAge() > 18) && (x.getAge() < 27))
                .collect(Collectors.toList());

//�������� ��������������� �� ������� ������ ������������ ��������������� ����� � ������ ������������ � �������
// (�.�. ����� � ������ ������������ �� 18 �� 60 ��� ��� ������ � �� 65 ��� ��� ������).
        System.out.println("Task 3");
        persons.stream()
                .filter(x ->
                        ((x.getSex() == Sex.MAN) && (x.getAge() > 18) && (x.getAge() < 65)) ||
                                ((x.getSex() == Sex.WOMAN) && (x.getAge() > 18) && (x.getAge() < 60))
                )
                .filter(x -> x.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}