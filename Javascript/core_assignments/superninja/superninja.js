class Ninja {
    constructor(name, health, speed, strength){
        this.name = name;
        this.health = health;
        this.speed = 3;
        this.strength = 3;
    }
    sayName(){
        console.log("My name is" + " " + this.name);
    }
    showStats(){
        console.log ("Name:" + this.name,"Strength:" + this.strength, "Speed:" + this.speed, "Health:" + this.health);
    }
    drinkSake(){
        this.health += 10;
        console.log (this.health);
    }
}

const ninja1 = new Ninja("Naruto", 100, this.speed, this.strength );

ninja1.sayName();
ninja1.showStats();
ninja1.drinkSake();

class Sensei extends Ninja {
    constructor(name){
        super(name, 200, 10, 10);
        this.wisdom = 10;
    }
    speakWisdom() {
        super.drinkSake()
        console.log("Wise message goes here")
    }
}

const superSensei = new Sensei("Master Roshi")
superSensei.sayName();
superSensei.showStats();
superSensei.speakWisdom();
superSensei.showStats();