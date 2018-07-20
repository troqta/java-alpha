package telerik;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> firstSubordinates = new ArrayList<>();
        firstSubordinates.add(2);
        firstSubordinates.add(3);

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, 5, firstSubordinates));
        employees.add(new Employee(2, 3, new ArrayList<>()));
        employees.add(new Employee(3, 3, new ArrayList<>()));

        System.out.println(new Solution().getImportance(employees, 1));
    }


    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

        public int getId() {
            return id;
        }

        public int getImportance() {
            return importance;
        }

        public List<Integer> getSubordinates() {
            return subordinates;
        }
    }

    ;

    static class Solution {
        public int getImportance(List<Employee> employees, int id) {
            int importanceValue = 0;

            Employee employee = getEmployeeById(employees, id);
            if (employee == null) {
                return importanceValue;
            }
            importanceValue = employee.importance;
            for (int subordinateId : employee.subordinates) {
                importanceValue += getImportance(employees, subordinateId);
            }

            return importanceValue;
        }

        public Employee getEmployeeById(List<Employee> employees, int id) {
            return employees
                    .stream()
                    .filter(x -> x.id == id)
                    .findFirst()
                    .orElse(null);

        }
    }
}
