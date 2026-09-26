public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(int id, String name, String department, double salary, String programmingLanguage) {
        super(id, name, department, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String getRole() {
        return "Developer";
    }

    @Override
    public String getExtraInfo() {
        return "Language: " + programmingLanguage;
    }
}