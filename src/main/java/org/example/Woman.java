package org.example;

public class Woman extends Person {
    private String maidenName;

    public Woman(String firstName, String lastName, int age, double possessions) {
        super(firstName, lastName, age, possessions);
        this.maidenName = lastName;
    }

    public boolean isRetired() {
        return this.age > 60;
    }

    public void registerPartnership(Man man) {
        this.partner = man;
        man.setPartner(this);
        this.maidenName = this.lastName;
        this.setLastName(man.getLastName());
    }

    public void deregisterPartnership(boolean revertLastName) {
        if (this.partner != null && this.partner instanceof Man) {
            Man man = (Man) this.partner;
            if (revertLastName) {
                this.setLastName(this.maidenName);
            }
            man.setPartner(null);
        }
        this.partner = null;
    }

    public void dividePossessions() {
        if (this.partner != null) {
            double totalPossessions = this.possessions + this.partner.getPossessions();
            this.setPossessions(totalPossessions / 2);
            this.partner.setPossessions(totalPossessions / 2);
        }
    }

    public String getMaidenName() {
        return maidenName;
    }
}

