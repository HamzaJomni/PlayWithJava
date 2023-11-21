package edu.esprit.game.levels;

import edu.esprit.game.utils.Data;
import edu.esprit.game.models.Employee;

import java.util.List;
import java.util.Set;
import java.util.*;
import java.util.stream.Collectors;


public class Level3 {
	public static void main(String[] args) {
	List<Employee> employees = Data.employees();

	/* TO DO 1: Retourner une chaine de caract�re qui contient tous les noms des employ�s */
	String names = employees.stream().map(Employee :: getName).reduce("", String::concat);
	System.out.println(names);
	/* TO DO 2: Retourner une chaine de caract�re qui contient tous les noms des employ�s en majuscule separ�s par # */
	String namesMajSplit = employees.stream().map(employee -> employee.getName().toUpperCase()).reduce("#", String::concat);
	System.out.println(namesMajSplit);
	/*TO DO 3: Retourner une set d'employ�s*/
	Set<Employee> emps = employees.stream().collect(Collectors.toSet());
	System.out.println(emps);
	/* TO DO 4: Retourner une TreeSet d'employ�s (tri par nom) */
	TreeSet<Employee> emps2 = employees.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName))));
	System.out.println(emps2);
	/* TO DO 5: Retourner une Map qui regroupe les employ�s par salaire */
	Map<Integer, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getSalary));
	System.out.println(map);
	/* TO DO 6: Retourner une Map qui regroupe les nom des employ�s par salaire */
	Map<Integer, String> mm = employees.stream().collect(Collectors.toMap(Employee::getSalary, Employee::getName, (name1, name2) -> name1 + ", " + name2));
	System.out.println(mm);
	/* TO DO 7: Retourner le  min, max,average, sum,count des salaires */
	String s = employees.stream().collect(Collectors.collectingAndThen(
			Collectors.mapping(Employee::getSalary, Collectors.summarizingInt(Integer::intValue)),
			stats -> String.format("Min: %d, Max: %d, Average: %.2f, Sum: %d, Count: %d",
			stats.getMin(), stats.getMax(), stats.getAverage(), stats.getSum(), stats.getCount())
	));
	System.out.println(s);
	}
}
