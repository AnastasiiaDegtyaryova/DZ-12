package org.example;

public class Man extends Person {

    public Man(String firstName, String lastName, int age, double possessions) {
        super(firstName, lastName, age, possessions);
    }

    public boolean isRetired() {
        return this.age > 65;
    }

    public void registerPartnership(Woman woman) {
        this.partner = woman;
        woman.setPartner(this);
        woman.setLastName(this.lastName);
    }

    public void deregisterPartnership(boolean revertLastName) {
        if (this.partner != null && this.partner instanceof Woman) {
            Woman woman = (Woman) this.partner;
            if (revertLastName) {
                woman.setLastName(woman.getMaidenName());
            }
            woman.setPartner(null);
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
}




