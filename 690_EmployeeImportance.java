/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    private HashSet<Integer> visited = new HashSet<>();
    public int getImportance(List<Employee> employees, int id) {
        if (visited.contains(id)) {
            return 0;
        }
        visited.add(id);
        Employee emp = getEmployeeFromId(employees, id);
        if (emp == null)
            return 0;
        int sumImportance = 0;
        for (Integer subId : emp.subordinates) {
            sumImportance += getImportance(employees, subId);
        }
        return emp.importance + sumImportance;
    }
    
    private Employee getEmployeeFromId(List<Employee> employees, int id) {
        for (Employee emp : employees) {
            if (emp.id == id)
                return emp;
        }
        return null;
    }
}
