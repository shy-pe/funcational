package stream.majorleague;

public class Salary {
    private int year;
    private String team;
    private String league;
    private String player;
    private long salary;

    public Salary(String s, String team, String league, String player, long salary) {}
    public Salary(int year, String team, String league, String player, long salary) {
        this.year = year;
        this.team = team;
        this.league = league;
        this.player = player;
        this.salary = salary;
    }

    public int getYear() {
        return year;
    }

    public String getTeam() {
        return team;
    }

    public String getLeague() {
        return league;
    }

    public String getPlayer() {
        return player;
    }

    public long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "year=" + year +
                ", team='" + team + '\'' +
                ", league='" + league + '\'' +
                ", player='" + player + '\'' +
                ", salary=" + salary +
                '}';
    }
}
