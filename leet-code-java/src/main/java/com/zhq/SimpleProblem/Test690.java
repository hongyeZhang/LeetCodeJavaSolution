package com.zhq.SimpleProblem;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/19
 */
public class Test690 {
    static class Employee {
        public int id;

        public int importance;

        public List<Integer> subordinates;
    }



    /**
     * 广度优先遍历
     * AC
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        if (null == employees || employees.size() == 0) {
            return 0;
        }

        HashSet<Integer> visitedEmployee = new HashSet<>();
        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }

        Employee targetEmployee = employeeMap.get(id);
        List<Integer> subordinates = targetEmployee.subordinates;
        Deque<Integer> deque = new LinkedList<>();
        for (Integer subordinate : subordinates) {
            deque.offer(subordinate);
            visitedEmployee.add(subordinate);
        }

        int totalImportance = targetEmployee.importance;
        while (!deque.isEmpty()) {
            Integer currentId = deque.pollFirst();
            Employee currentEmployee = employeeMap.get(currentId);
            totalImportance += currentEmployee.importance;
            List<Integer> subordinateList = currentEmployee.subordinates;
            for (Integer integer : subordinateList) {
                if (!visitedEmployee.contains(integer)) {
                    deque.offer(integer);
                    visitedEmployee.add(integer);
                }
            }
        }

        return totalImportance;
    }





}
