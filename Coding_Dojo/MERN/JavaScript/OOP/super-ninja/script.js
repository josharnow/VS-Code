// import { Ninja } from '../ninja/script.js'

class Ninja { // Parent class Ninja
    constructor(name, health, speed = 3, strength = 3) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
    }

    sayName() { // As an arrow function: sayName = () => console.log(`${this.name}`);
        console.log(`${this.name}`);
    }

    showStats() {
        console.log(`Name: ${this.name}`);
        console.log(`Health: ${this.health}`);
        console.log(`Speed: ${this.speed}`);
        console.log(`Strength: ${this.strength}`);
        return `Name: ${this.name} | Health: ${this.health} | Speed: ${this.speed} | Strength: ${this.strength}`;
    }

    drinkSake() {
        this.health += 10;
        console.log(`Your new health is ${this.health}`);
        return `Your new health is ${this.health}`;
    }
}

class Sensei extends Ninja { // creates a child class Sensei that inherits from the parent class Ninja
    constructor(name, wisdom = 10) { // adds an attribute: wisdom - defaults to 10
        super(name, 200, 10, 10);
        this.wisdom = wisdom;
    }

    speakWisdom() { // creates a method: speakWisdom()
        console.log("What one programmer can do in one month, two programmers can do in two months.");
    }
}

// Extend the Ninja class and create the Sensei class. A Sensei should have 200 Health, 10 speed, and 10 strength by default. In addition, a Sensei should have a new attribute called wisdom, and the default should be 10. Finally, add the speakWisdom() method. speakWisdom() should call the drinkSake() method from the Ninja class, before console.logging a wise message.
// // example output
const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
// -> "What one programmer can do in one month, two programmers can do in two months."
superSensei.showStats();
// -> "Name: Master Splinter, Health: 210, Speed: 10, Strength: 10"