public class Player extends Entity {

    private int numberOfHeals;
    private final float maxHealth;

    public Player(int attack, int defence, int healthPoints, int minDamage, int maxDamage) {
        super(attack, defence, healthPoints, minDamage, maxDamage);
        numberOfHeals = 0;
        maxHealth = healthPoints;
    }

    public void heal() {
        if(numberOfHeals < 4) {
            setHealthPoints((float) (getHealthPoints() * 1.3));
            if(getHealthPoints() > maxHealth)
                setHealthPoints(maxHealth);
            numberOfHeals++;
            System.out.println("Ваше здоровье восстановлено. Текущее здоровье: " + getHealthPoints());
        }
        else {
            System.out.println("Вы больше не можете себя исцелить :(");
        }
    }
}
