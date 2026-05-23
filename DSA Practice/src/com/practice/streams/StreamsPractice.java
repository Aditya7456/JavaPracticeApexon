package com.practice.streams;

import java.sql.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee{
    String name;
    String dept;
    Integer salary;
    String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Employee(String name, String dept, Integer salary, String role) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", role='" + role + '\'' +
                '}';
    }
}

public class StreamsPractice {
    public static void main(String[] args) {

        //Question - 1
        /*
		 * 1. Top K Frequent Elements
				Input
				nums = [1,1,1,2,2,3], k = 2
				Output [1,2]
				Requires: groupingBy + counting + sorting
		 */
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        List<Integer> elements = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n->n, Collectors.counting()))
                        .entrySet()
                                .stream()
                                        .sorted(Comparator.comparingLong(Map.Entry<Integer,Long>::getValue).reversed())
                                                .limit(k)
                                                        .map(Map.Entry<Integer,Long>::getKey)
                                                                .toList();


        //System.out.println(elements);

        // Question - 2
        /*
            2. Longest String in List
            Input : ["apple", "banana", "kiwi"]
            Output : "banana"
         */
        String[] fruits = {"apple","banana","kiwi","pineapple"};

        String str = Arrays.stream(fruits)
                        .sorted(Comparator.comparing(String::length).reversed())
                                .limit(1)
                                        .findFirst()
                                                .get();

        //System.out.println(str);

        // Question - 3
        /*
            3. Group Anagrams
            Input
            ["eat","tea","tan","ate","nat","bat"]
            Output
            [
            ["eat","tea","ate"],
            ["tan","nat"],
            ["bat"]
            ]
         */
        List<String> words = List.of("eat","tea","tan","ate","nat","bat");
        Collection<List<String>> groupOfAnagrams =
                words.stream()
                        .collect(Collectors.groupingBy(
                                word -> {
                                    char[] chars = word.toCharArray();
                                    Arrays.sort(chars);
                                    return new String(chars);
                                }

                        ))
                        .values();
        //System.out.println(groupOfAnagrams);

        //Question - 4
        /*
            4. Find All Duplicates (Optimized)
            Input
            [4,3,2,7,8,2,3,1]
            Output
            [2,3]
            👉 Avoid O(n²)
         */
        List<Integer> numbers = List.of(4,1,3,2,7,8,2,3,1); // [2,3]
//              Set<Integer> set = new HashSet<>();
//        List<Integer> duplicateNumbers =
//                numbers.stream()
//                        .filter(n-> !set.add(n))
//                        .toList();

        List<Integer> duplicateNumbers =
                numbers.stream()
                        .collect(Collectors.groupingBy(
                                        n->n,
                                        Collectors.counting()
                                ))
                                .entrySet()
                                        .stream()
                                                .filter(e-> e.getValue()>1)
                                                        .map(Map.Entry::getKey)
                                                                .toList();


        //System.out.println(duplicateNumbers);

        // Question - 5
        /*
            5. Employee Highest Salary per Department
            Input
            Employee(name, dept, salary)
            [
                ("A","IT",1000),
                ("B","IT",2000),
                ("C","HR",1500)
            ]
            Output
            {
                IT -> ("B",2000),
                HR -> ("C",1500)
            }
         */
        List<Employee> emplList1 = List.of(
                new Employee("Alice",   "Engineering", 90000, "Developer"),
                new Employee("Bob",     "Engineering", 75000, "Tester"),
                new Employee("Charlie", "HR",          60000, "Recruiter"),
                new Employee("David",   "Finance",     85000, "Analyst"),
                new Employee("Eve",     "Engineering", 95000, "Developer"),
                new Employee("Frank",   "HR",          70000, "Manager"),
                new Employee("Grace",   "Finance",     90000, "Manager"),
                new Employee("Hank",    "Engineering", 120000,"Lead"),
                new Employee("Ivy",     "Finance",     65000, "Analyst"),
                new Employee("John",    "HR",          55000, "Intern")
        );
        Map<String,Optional<Employee>> map = emplList1.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                        ));

        //System.out.println(map);

        // Question - 6
        /*
            6. Flatten Nested Map
            Input
            Map<String, List<Integer>>
            {
            "A": [1,2],
            "B": [3,4]
            }
            Output
            [1,2,3,4]
         */
        Map<String, List<Integer>> listMap = new LinkedHashMap<>();
        listMap.put("A",List.of(1,2));
        listMap.put("B",List.of(3,4));
        listMap.values()
                                    .stream()
                                    .flatMap(List::stream)
                                    .toList();

        // Question - 7
        /*
            7. Find First Non-Repeating Character
                Input : "swiss"
                Output : 'w'
         */
        String str1 = "swiss";
        Character result = str1.chars()
                            .mapToObj(c->(char)c)
                            .collect(Collectors.groupingBy(
                                    ch -> ch,
                                    LinkedHashMap::new,
                                    Collectors.counting()
                            ))
                            .entrySet()
                            .stream()
                            .filter(e->e.getValue()<2)
                            .map(Map.Entry::getKey)
                            .findFirst()
                                    .orElse(null);
       // System.out.println(result);

        // Question - 8
        /*
                8. Merge Two Lists and Remove Duplicates
        Input : [1,2,3], [3,4,5]
        Output : [1,2,3,4,5]
         */
        List<List<Integer>> list = List.of(List.of(1,2,3),List.of(3,4,5));
        List<Integer> res = list.stream()
                .flatMap(Collection::stream)
                .distinct()
                .toList();
        //System.out.println(res);

        // Question - 9
        /*
        9. Find Second Highest Salary
                Input : [1000,2000,3000,4000]
                Output : 3000
         */
        int[] nums1 = {1000,2000,3000,4000};
        Integer  res2 =Arrays.stream(nums1)
                                        .boxed()
                                        .sorted(Comparator.reverseOrder())
                                        .skip(1)
                                        .findFirst()
                                        .orElse(null);
        //System.out.println(res2);

        // Question - 10
        /*
        10. Partition Employees by Salary > 2000
                Input
                [1000,3000,2500,1500]
                Output
                {
                 true -> [3000,2500],
                 false -> [1000,1500]
}
         */
        List<Integer> nums2 = List.of(1000,3000,2500,1500);
        Map<Boolean,List<Integer>> map2 = nums2.stream()
                .collect(Collectors.partitioningBy(sal->sal>2000));
//        map2.forEach((bool,tempList)->{
//            if(bool) System.out.println("Greater than 2000");
//            else System.out.println("Less than 2000");
//            tempList.forEach(System.out::println);
//        });

        // Question - 11
        /*
        11. Find Most Frequent Word
            Input
            ["java","python","java","java","go"]
            Output
            "java"
         */
        List<String> lang = List.of("java","python","java","java","go");
        String str3 = lang.stream()
                                    .collect(Collectors.groupingBy(
                                            Function.identity(),
                                            LinkedHashMap::new,
                                            Collectors.counting()
                                    ))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(()-> new RuntimeException("no frequent element found"));
        //System.out.println(str3);

        // Question - 12
        /*
        12. Convert List to Map (Handle Duplicate Keys)
                Input
                [("A",1), ("A",2), ("B",3)]
                Output
                {
                 A -> 3,
                 B -> 3
                }
                👉 Merge values
         */
        List<Map.Entry<String,Integer>> list2 =
                List.of(Map.entry("A",1),
                        Map.entry("A",2),
                        Map.entry("B",3));
        Map<String,Integer> map3 = list2.stream()
                                        .collect(Collectors.groupingBy(
                                                Map.Entry::getKey,
                                                Collectors.summingInt(Map.Entry::getValue)
                                        ));
        //System.out.println(map3);

        // Question - 13
        /*
        13. Find Common Elements Between Two Lists
                Input
                [1,2,3,4], [3,4,5,6]
                Output
                [3,4]
         */
        List<Integer> list1 = List.of(1,2,3,4);
        List<Integer> list3 = List.of(3,4,5,6);
        List<Integer> res1 = list3.stream()
                                .filter(list1::contains)
                                .toList();
        //System.out.println(res1);

        // Question - 14
        /*
        14. Find All Palindromes in List
            Input
            ["madam","racecar","apple"]
            Output
            ["madam","racecar"]
         */
        List<String> list4 = List.of("madam","racecar","apple");
        List<String> res3 = list4.stream()
                                .filter(s-> s.equals(new StringBuilder(s).reverse().toString()))
                                .toList();
        //System.out.println(res3);

        // Question - 15
        /*
        15. Sort Map by Value (Descending)
            Input
            {A=10, B=30, C=20}
            Output
            {B=30, C=20, A=10}
         */
        Map<Character,Integer> map1 = Map.of('A',10,'B',30,'C',20);
        Map<Character,Integer> sortedMap =
                map1.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (a,b)->a,
                                LinkedHashMap::new
                        ));
        //System.out.println(sortedMap);

        // Question - 16
        /*
        16. Nested Grouping (Department → Role)
                Input
                Employee(name, dept, role)
                Output
                {
                 IT -> {Dev -> [...], QA -> [...]},
                 HR -> {Recruiter -> [...]}
}
         */
        List<Employee> emplList2 = List.of(
                new Employee("Alice",   "Engineering", 90000, "Developer"),
                new Employee("Bob",     "Engineering", 75000, "Tester"),
                new Employee("Charlie", "HR",          60000, "Recruiter"),
                new Employee("David",   "Finance",     85000, "Analyst"),
                new Employee("Eve",     "Engineering", 95000, "Developer"),
                new Employee("Frank",   "HR",          70000, "Manager"),
                new Employee("Grace",   "Finance",     90000, "Manager"),
                new Employee("Hank",    "Engineering", 120000,"Lead"),
                new Employee("Ivy",     "Finance",     65000, "Analyst"),
                new Employee("John",    "HR",          55000, "Intern")
        );
        Map<String,Map<String,List<Employee>>> map4 = emplList2.stream()
                                    .collect(Collectors.groupingBy(
                                            Employee::getDept,
                                            Collectors.groupingBy(Employee::getRole)
                                    ));
        //System.out.println(map4);

        // Question - 17
        /*
        17. Find All Substrings Using Streams
            Input
            "abc"
            Output
            ["a","b","c","ab","bc","abc"]
         */
        String str2 = "abc";
        List<String> res4 =
                IntStream.range(0,str2.length())
                        .boxed()
                        .flatMap(i->
                                IntStream.rangeClosed(i+1,str2.length())
                                        .mapToObj(j->str2.substring(i,j)))
                        .toList();
        //System.out.println(res4);'

        // Question - 18
        /*
        18. Sliding Window Maximum (Stream-style thinking)
            Input
            [1,3,-1,-3,5,3,6,7], k=3
            Output
            [3,3,5,5,6,7]
            👉 Why is streams not good for this problem?
         */
        List<Integer> list5 = List.of(1,3,-1,-3,5,3,6,7);
        int window = 3;
        List<Integer> res5 = IntStream.range(0,list5.size()-window+1)
                                .mapToObj(i->
                                        list5.subList(i,i+window)
                                                .stream()
                                                .mapToInt(Integer::intValue)
                                                .max()
                                                .getAsInt())
                                .toList();
        //System.out.println(res5);

        // Question - 19
        /*
        🧩 19. Custom Collector (Average Salary per Dept)
            Input
            Employee(dept, salary)
            Output
            {
             IT -> avg,
             HR -> avg
            }
         */
        Map<String,Double> res6 = emplList2.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.averagingInt(Employee::getSalary)
                ));
        //System.out.println(res6);

        // Question - 20
        /*
        🧩 20. Detect Cycle-like Pattern (Advanced)
                Input
                [1,2,3,1,2,3,1]
                Output
                true
                👉 Identify repeating sequence pattern
         */
        List<Integer> list6 = List.of(1,2,3,1,2,3,1);

        // Question - 21
        /*
        List<String> transactions = Arrays.asList(
            "u1,apple,PURCHASE,3",
            "u1,apple,RETURN,1",
            "u1,banana,PURCHASE,2",
            "u2,apple,PURCHASE,5",
            "u2,banana,RETURN,2"
        );
        ✅ Expected Output
        {
          u1={apple=2, banana=2},
          u2={apple=5, banana=-2}
        }
         */
        List<String> transactions = Arrays.asList(
                "u1,apple,PURCHASE,3",
                "u1,banana,PURCHASE,2",
                "u1,apple,RETURN,1",

                "u2,apple,PURCHASE,5",
                "u2,banana,RETURN,2",

                "u3,apple,PURCHASE,4",
                "u3,banana,PURCHASE,3",

                "u4,apple,PURCHASE,10",

                "u5,banana,RETURN,5",
                "u5,apple,PURCHASE,2",

                "u6,apple,PURCHASE,7",
                "u6,banana,PURCHASE,1"
        );
        Map<String,Map<String,Integer>> res7 = transactions.stream()
                .map(tr->tr.split(",")) // array -> {userId,itemName,transactType,quantity}
                .collect(Collectors.groupingBy(
                        tr->tr[0], // group by userId
                        Collectors.groupingBy(
                                tr-> tr[1], // nestedGroup by itemName
                                Collectors.summingInt((tr)->{
                                    int qnty = Integer.parseInt(tr[3]);
                                    return tr[2].equals("RETURN") ? -qnty : qnty;
                                })
                        )
                ));
//        for(Map.Entry<String,Map<String,Integer>> e : res7.entrySet()){
//            System.out.println(e.getKey());
//            Map<String,Integer> tempMap = e.getValue();
//            for(Map.Entry<String,Integer> em:tempMap.entrySet()){
//                System.out.println(em.getKey() + " " + em.getValue());
//            }

        // Question - 22
        /*
        🔥 You Need To Do:
        👉 For each user
        👉 Find the item with highest net quantity
         */
        Map<String,String> res8 = transactions.stream()
                .map(tr->tr.split(","))
                .collect(Collectors.groupingBy(
                        tr->tr[0],
                        Collectors.groupingBy(
                                tr->tr[1],
                                Collectors.summingInt((tr) ->{
                                    int qty = Integer.parseInt(tr[3]);
                                    return tr[2].equals("PURCHASE") ?  qty : -qty;
                                })
                        )
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue()
                                .entrySet()
                                .stream()
                                .max(
                                        Comparator.comparingInt(Map.Entry<String,Integer>::getValue)
                                                .thenComparing(Map.Entry::getKey,Comparator.reverseOrder())
                                )
                                .get()
                                .getKey()


                ));
        //System.out.println(res8);

        List<String> res9 = transactions.stream()
                .map((tr -> tr.split(",")))
                .collect(Collectors.groupingBy(
                        tr->tr[0], // first group them by user name like u1
                       Collectors.summingInt(tr->{
                           int qty = Integer.parseInt(tr[3]);
                           return tr[2].equals("PURCHASE") ? qty : -qty;
                       })
                ))
                        .entrySet()
                                .stream()
                                        .sorted(Comparator.comparingInt(Map.Entry<String,Integer>::getValue).reversed().thenComparing(Map.Entry::getKey))
                                                .limit(3)
                                                        .map(Map.Entry::getKey).toList();



        System.out.println(res9);

    }
}
