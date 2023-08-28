//������� 2. ������ 1. ������ � �������

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        //����� ���������� ������������������ (�.�. ����� ������ 18 ���).
        long countYoung = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println(countYoung);
/*
//�������� ������ ������� ����������� (�.�. ������ �� 18 � �� 27 ���).
        persons.stream()
                .filter() man
                .filter() age
                .map()
                .collect(Collectors.toList());

//�������� ��������������� �� ������� ������ ������������ ��������������� ����� � ������ ������������ � ������� (�.�. ����� � ������ ������������ �� 18 �� 60 ��� ��� ������ � �� 65 ��� ��� ������).
        persons.stream()
                .filter()
                .sorted(Comparator.comparing())
                .collect();
*/

//System.out.println(persons);

    }
}