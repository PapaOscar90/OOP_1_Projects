package nl.rug.oop.rpg;

import java.util.Random;

/**
 * Enemy abstract class
 * Created by saidf on 4/30/2017.
 */
public class Enemy extends NPC {
    private int minAttackDmg;
    private int maxAttackDmg;
    Random rng;

    public Enemy(String descr, String name, int health, int minAttackDmg, int maxAttackDmg) {
        super(descr, name, health);
        this.minAttackDmg = minAttackDmg;
        this.maxAttackDmg = maxAttackDmg;
        rng = new Random();
    }

    public void attack(Player p) {
        int damageDealt = minAttackDmg + rng.nextInt(maxAttackDmg - minAttackDmg);
        p.takeDamage(damageDealt);
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void duel(Player p) {
        while (p.getHealth() > 0 && this.health > 0) {
            try {
                System.out.println("Your health: " + p.getHealth() + "  Enemy health: " + this.health);
                Thread.sleep(HelperClass.COMBAT_SCROLL_SPEED);
                System.out.println("You attack!");
                Thread.sleep(HelperClass.COMBAT_SCROLL_SPEED);
                p.attack(this);
                System.out.println("Your health: " + p.getHealth() + "  Enemy health: " + this.health);
                if (this.health <= 0) {
                    break;
                }
                Thread.sleep(HelperClass.COMBAT_SCROLL_SPEED);
                System.out.println("Enemy attacks!");
                attack(p);
                Thread.sleep(HelperClass.COMBAT_SCROLL_SPEED);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }
        if (p.getHealth() <= 0) {
            System.out.println("You died! But somehow you just magically respawn in the room you started in.");
            p.respawn();
        } else {
            System.out.println("You killed the enemy. It evaporates into thin air! Not without dropping some gold though.");
            p.addGold(Math.round(maxHealth * 2 * rng.nextFloat()));
        }

    }

    public void interact(Player p) {
        duel(p);
    }


}
