package EnglishCenter;

class Student {
    private String name;
    private int id;
    private String dob;


    public Student(String name, int id, String dob) {
        this.name = name;
        this.id = id;
        this.dob = dob;
    }
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDob() {
        return dob;
    }
}