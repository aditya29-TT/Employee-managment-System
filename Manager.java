
public class Manager extends Employee {
    private int teamSize;

    public Manager(int id, String name, String department, double salary, int teamSize) {
        super(id, name, department, salary); // call Employee's constructor
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    @Override
    public String getExtraInfo() {
        return "Team Size: " + teamSize;
    }
}