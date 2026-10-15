public static class healer extends Character {
        private int healingpower;

        public healer(String name, int health, int power, int healingpower) {
            super(name, health, power);
            this.healingpower = healingpower;
        }

        public int getHealingpower() { return healingpower; }
        public void setHealingpower(int healingpower) { this.healingpower = healingpower; }

        public void heal(Character character) {
            if (this.healingpower > 0) {
                if (character.getHealth() < 20) {
                    System.out.println("Low health detected! The Healer springs into action!");
                }
                character.setHealth(character.getHealth() + this.healingpower);
                System.out.println(getName() + " healed " + character.getName() + " for " + this.healingpower + " HP!");
                this.healingpower = 0;
            }
        }
    }