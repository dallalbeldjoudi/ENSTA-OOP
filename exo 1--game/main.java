public class main {

    // Base Character Class
    public static class Character {
        private String name;
        private int health;
        private int power;

        public Character(String name, int health, int power) {
            this.name = name;
            this.health = health;
            this.power = power;
        }

        public String getName() { return name; }
        public int getHealth() { return health; }
        public int getPower() { return power; }
        public void setName(String name) { this.name = name; }
        public void setHealth(int health) { this.health = health; }
        public void setPower(int power) { this.power = power; }

        public void attack(Character target) {
            target.setHealth(target.getHealth() - this.power);
            System.out.println("WOW! " + this.name + " attacked " + target.getName() + " for " + this.power + " damage!");
            this.power = Math.max(0, this.power - 10);
        }
    }

    // EvilGuy Class
    public static class EvilGuy extends Character {
        public EvilGuy(String name, int health, int power) {
            super(name, health, power);
        }
    }

    // Healer Class
    public static class Healer extends Character {
        private int healingpower;

        public Healer(String name, int health, int power, int healingpower) {
            super(name, health, power);
            this.healingpower = healingpower;
        }

        public int getHealingpower() { return healingpower; }
        public void setHealingpower(int healingpower) { this.healingpower = healingpower; }

        public void heal(Character target) {
            if (this.healingpower > 0) {
                if (target.getHealth() < 20) {
                    System.out.println("U're out of health? Dw! The healer is in action!");
                }
                target.setHealth(target.getHealth() + this.healingpower);
                System.out.println(getName() + " healed " + target.getName() + " for " + this.healingpower + " HP!");
                this.healingpower = 0;
            }
        }
    }

    // Warrior Class
    public static class Warrior extends Character {
        private int armor;
        private int ragelevel;

        public Warrior(String name, int health, int power, int ragelevel, int armor) {
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
                System.out.println("The warrior is enraged! Attack power is UP!");
                setPower(getPower() + 20);
                target.setHealth(target.getHealth() - this.getPower());
                this.ragelevel -= 50;
                System.out.println(getName() + " dealt " + getPower() + " damage to " + target.getName() + "!");
            }
        }

        public void defend(Character target) {
            System.out.println("The warrior is defending! Armor UP!");
            if (this.armor > 0) {
                target.setHealth(target.getHealth() + 20);
                this.armor -= 10;
            }
        }
    }

    // Main Method Execution
    public static void main(String[] args) {
        System.out.println("=== Welcome to the Game! ===\n");

        // Initial Stats
        Character hero = new Character("Dallal", 100, 50);
        Warrior warrior = new Warrior("Warrior", 100, 50, 100, 50);
        Healer healer = new Healer("Healer", 100, 50, 60);
        EvilGuy evilGuy = new EvilGuy("Evil Guy", 100, 15);

        System.out.println("--- Starting Stats ---");
        System.out.println("Hero Data: " + hero.getName() + " | Health: " + hero.getHealth() + " | Power: " + hero.getPower());
        System.out.println("Warrior Data: " + warrior.getName() + " | Health: " + warrior.getHealth() + " | Power: " + warrior.getPower() + " | Rage Level: " + warrior.getRagelevel() + " | Armor: " + warrior.getArmor());
        System.out.println("Healer Data: " + healer.getName() + " | Health: " + healer.getHealth() + " | Power: " + healer.getPower() + " | Healing Power: " + healer.getHealingpower());
        System.out.println("Evil Guy Data: " + evilGuy.getName() + " | Health: " + evilGuy.getHealth() + " | Power: " + evilGuy.getPower());
        System.out.println();

        // Turn 1
        System.out.println("--- Turn 1 ---");
        System.out.println("HEY! " + evilGuy.getName() + " is attacking " + hero.getName() + "!");
        evilGuy.attack(hero);
        System.out.println(hero.getName() + " health is now: " + hero.getHealth() + "\n");

        // Turn 2
        System.out.println("--- Turn 2 ---");
        System.out.println("Let's see if the warrior can defend the character!");
        warrior.defend(hero);
        System.out.println("PHEW! " + hero.getName() + " health is now: " + hero.getHealth() + ", and the warrior's armor is now: " + warrior.getArmor() + "\n");

        // Turn 3
        System.out.println("--- Turn 3 ---");
        System.out.println("Someone is giving the evil guy more energy!");
        evilGuy.setPower(evilGuy.getPower() + 70);
        System.out.println("Evil Guy power increased to: " + evilGuy.getPower());
        evilGuy.attack(hero);
        System.out.println("The character is low on health! It is now: " + hero.getHealth() + "\n");

        // Turn 4
        System.out.println("--- Turn 4 ---");
        healer.heal(hero);
        System.out.println("The character's health is now: " + hero.getHealth() + "\n");

        // Turn 5
        System.out.println("--- Turn 5 ---");
        System.out.println("Let's finish the evil guy with a raged attack from the warrior!");
        warrior.ragedattack(evilGuy);
        System.out.println("Evil Guy remaining health: " + evilGuy.getHealth() + "\n");

        System.out.println("=== The Evil Guy is defeated! We won! ===");
    }
}