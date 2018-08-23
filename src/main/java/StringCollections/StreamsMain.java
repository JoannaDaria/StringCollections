package StringCollections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsMain {
    public static void main(String[] args) {

        Collection<String> names = StringCollections.names();
        System.out.println(zadanie9(names));

    }

    //        Napisz metodę, która zwróci wszystkie imiona o długości co najwyżej 4, zapisane małymi literami.
    private static Collection<String> zadanie1(Collection<String> names) {
        return names.stream()
                .distinct()
                .filter(name -> name.length() <= 4)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    //        Napisz metodę, która zwróci wszystkie imiona zaczynające się na literę B, bez powtórzeń.
    private static List<String> zadanie2(Collection<String> names) {
        return names.stream()
                .distinct()
                .filter(name -> name.startsWith("B"))
                .collect(Collectors.toList());
    }

    //        Napisz metodę, która zwróci początkowe trzy litery imion, bez powtórek, uppercasem.
    private static List<String> zadanie3(Collection<String> names) {
        return names.stream()
                .map(name -> name.substring(0,3).toUpperCase())
                .distinct()
                .collect(Collectors.toList());
    }

    //        Napisz metodę, która zwróci 10 najdłuższych imion, malejąco względem rozmiaru.
    private static List<String> zadanie4(Collection<String> names) {
        return names.stream()
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

//        Zadanie 5
//        Napisz metodę, która zwróci 5 najkrótszych imion, malejąco względem rozmiaru i rosnąco względem
//        ostatniej litery imienia.
//        Zadanie 6
//        Napisz metodę, która odwróci kolejność liter we wszystkich imionach i zostawi tylko te, które mają w
//        sobie literę A wśród pierwszych trzech liter oryginalnego imienia.
//        Zadanie 7
//        Napisz metodę, która zwróci Map<String, Integer>, gdzie kluczami będą imiona, a wartościami będzie
//        liczba wystąpień.
//        Zadanie 8
//        Napisz metodę, która zwróci listę wszysstkich liter (ale List<String> - po prostu niech te Stringi będą
//        długości 1), które są użyte w imionach.
    private static List<String> zadanie8 (Collection<String> names){
        return names.stream()
                .flatMap(name -> Arrays.stream(name.split("")))
                .distinct()
                .collect(Collectors.toList());
    }

//        Zadanie 9
//        Napisz metodę, która zwróci listę wszysstkich liter (ale List<String> - po prostu niech te Stringi będą
//        długości 1), które są użyte w imionach zaczynających się na B i o długości 4 lub 5.
    private static List<String> zadanie9 (Collection <String> names) {
        return names.stream()
                .filter(name -> name.startsWith("B") && name.length()==3 || name.length()==7)
                .flatMap(name -> Arrays.stream(name.split("")))
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
