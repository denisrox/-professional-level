import java.io.Serializable;

public class Player implements Serializable {
    private int MaxHitPoint, СurrentHitPoints,armor, LVL;
    private double attakPower;
    public Player(int MaxHitPoint,int armor, double attakPower)
    {
        LVL=1;
        this.MaxHitPoint=MaxHitPoint;
        СurrentHitPoints=MaxHitPoint;
        this.attakPower=attakPower;
        this.armor=armor;
    }

    public void setLVL(int LVL) {
        this.LVL = LVL;
    }

    public void damage(int damage) {
        СurrentHitPoints -= damage;
    }
    public void showInfo(){
        System.out.println("HP="+СurrentHitPoints+"/"+MaxHitPoint+" | LVL="+LVL+" | Armor="+armor+ " | attakPower="+attakPower);
    }
}