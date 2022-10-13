import java.util.*;
import java.lang.Override;

class LevelPair {
    Integer first;
    Integer second;

    LevelPair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }
}

class Employee {
    private Integer empId;
    private Integer managerId;
    private String empName;

    Employee(Integer empId, Integer managerId, String empName) {
        this.empId = empId;
        this.managerId = managerId;
        this.empName = empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}

interface OrgChart {
    void print();
}

public class Organization implements OrgChart {
    private List<Employee> employees;

    Organization() {
        employees = new ArrayList<>();
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public static void main(String[] args) {
        /*
        Input:
            <emp count>
            <empid> <managerid> <empname>
         */
        Scanner scanner = new Scanner(System.in);

        int empCount = Integer.parseInt(scanner.nextLine());

        List<Employee> emps = new ArrayList<>();
        for (int i = 0; i < empCount; i++) {
            String[] empLine = scanner.nextLine().split(" ");
            Employee employee = new Employee(Integer.parseInt(empLine[0]),
                    Integer.parseInt(empLine[1]),
                    empLine[2]);
            emps.add(employee);
        }

        Organization org = new Organization();

        org.setEmployees(emps);

        org.print();
    }

    @Override
    public void print() {
        HashMap<Integer, List<Integer>> managers = new HashMap<>();
        HashMap<Integer, String> empNames = new HashMap<>();
        Stack<LevelPair> st = new Stack<>();
        ArrayList<String> chart = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();

        for (Employee emp : this.employees) {
            List<Integer> empIds = new ArrayList<>();

            if (managers.containsKey(emp.getManagerId())) {
                empIds = managers.get(emp.getManagerId());
            }

            empIds.add(emp.getEmpId());

            if (emp.getManagerId() != 0)
                managers.put(emp.getManagerId(), empIds);
            else
                // push top level employees first
                st.push(new LevelPair(emp.getEmpId(), 0));

            empNames.put(emp.getEmpId(), emp.getEmpName());
        }

        while (!st.isEmpty()) {
            LevelPair pair = st.pop();
            int mng = pair.first;
            int curLevel = pair.second;

            if (!visited.contains(mng) && managers.containsKey(mng)) {
                List<Integer> emps = managers.get(mng);

                for (int i = 0; i < emps.size(); i++) {
                    st.push(new LevelPair(emps.get(i), curLevel + 1));
                }
            }

            String spaces = "", pat = "";
            for (int i = 1; i <= curLevel; i++) {
                spaces = spaces + "\t";
                pat = pat + "|_";
            }

            chart.add(spaces + pat + empNames.get(pair.first));

            visited.add(mng);
        }

        System.out.println("org chart");
        for (String str : chart) {
            System.out.println(str);
        }
    }
}
