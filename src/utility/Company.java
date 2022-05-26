package utility;

public class Company extends TaxPayer{

    private int numberEmployees;

    public Company(String name, Double anualIncome, int numberEmployees) {
        super(name, anualIncome);
        this.numberEmployees = numberEmployees;
    }

    public int getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(int numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    @Override
    public double tax() {
        double total = 0.0;
        if (getNumberEmployees() >= 10) {
            total = getAnualIncome() * 0.14;
        }
        else {
            total = getAnualIncome() * 0.16;
        }
        return total;
    } 

    public String toString() {
        return String.format(" %.2f %n", tax());
    }
    
}
