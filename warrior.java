public static class warrior extends Character {
        private int armor;
        private int ragelevel;

        public warrior(String name, int health, int power, int ragelevel, int armor) {
            super(name, health, power);
            this.ragelevel = ragelevel;
            this.armor = armor;
        }

        public int getRagelevel() { return ragelevel; }
        public int getArmor() { return armor; }
        public void setRagelevel(int ragelevel) { this.ragelevel = ragelevel; }
        public void setArmor(int armor) { this.armor = armor; }

        public void ragedattack(Character target) {
            if (this.ragelevel > 50) {
                System.out.println("The warrior is enraged! Attack power increased!");
                setPower(getPower() + 20);
                target.setHealth(target.getHealth() - this.getPower());
                this.ragelevel -= 50;
                System.out.println(getName() + " dealt " + getPower() + " damage to " + target.getName() + "!");
            }
        }

        public void defend(Character target) {
            System.out.println("The warrior steps in to defend! Armor activated!");
            if (this.armor > 0) {
                target.setHealth(target.getHealth() + 20);
                this.armor -= 10;
            }
        }
    }