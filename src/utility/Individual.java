package utility;

public class Individual extends TaxPayer {

    private Double healthExp;
    private Individual[] list;

    public Individual(String name, Double anualIncome, Double healthExp) {
        super(name, anualIncome);
        this.healthExp = healthExp;
    }

    public Individual[] getList() {
        return this.list;
    }

    public void setList(Individual[] list) {
        this.list = list;
    }


    public Double getHeathExp() {
        return healthExp;
    }

    public void setHeathExp(Double healthExp) {
        this.healthExp = healthExp;
    }

    @Override
    public double tax() {
        double baseTax;
        if (getAnualIncome() < 20000){
            baseTax = getAnualIncome() * 0.15;
        }
        else {
            baseTax = getAnualIncome() * 0.25;
        }
        baseTax = baseTax - (getHeathExp() * 0.5);
        
        if (baseTax < 0.0) {
            return 0.0;
        } else
            return baseTax;
    }

    public String toString() {
        return String.format("%s : %.2f", getName(), tax());
    }

    
    
}
