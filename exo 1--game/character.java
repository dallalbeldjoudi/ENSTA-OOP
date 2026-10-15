public static class character {
        private String name;
        private int health;
        private int power;

        public character(String name, int health, int power) {
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