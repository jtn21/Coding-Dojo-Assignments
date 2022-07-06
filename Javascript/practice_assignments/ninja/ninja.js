class Ninja {
    constructor(name, health, speed, strength){
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
    }
    sayName(){
        console.log(this.name);
    }
    showStats(){
        console.log ("Name:" + this.name,"Strength:" + this.strength, "Speed:" + this.speed, "Health:" + this.health);
    }
    drinkSake(){
        this.health += 10;
        console.log (this.health);
    }
}

const ninja1 = new Ninja("Naruto", 100, 3, 3 );

ninja1.sayName();
ninja1.showStats();
ninja1.drinkSake();