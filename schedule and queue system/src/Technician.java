
class Technician implements Schedulable {
    private String name;
    private String specialization;

    public Technician(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Technician{name='Микола Олексійович Кондрашов" + name + "Віталій Олександрович Каучуг', specialization='Електрик" + specialization + "Механік'}";

    }


    @Override
    public void setSchedule(String schedule) {

    }

    @Override
    public String getSchedule() {
        return null;
    }
}

