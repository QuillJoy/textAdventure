public abstract class Entity {
    protected String name;
    protected int health;






    /* getter and setters */

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    
}
