class Ninja {
    constructor(name, health, speed = 3, strength = 3) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
    }

    sayName() {
        console.log(`${this.name}`);
    }
    // As arrow function: sayName = () => console.log(`${this.name}`);

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

const ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
ninja1.showStats();
ninja1.drinkSake();

// Create a Ninja class
// add an attribute: name
// add an attribute: health
// add a attribute: speed - give a default value of 3
// add a attribute: strength - give a default value of 3
// add a method: sayName() - This should log that Ninja's name to the console
// add a method: showStats() - This should show the Ninja's name, strength, speed, and health.
// add a method: drinkSake() - This should add + 10 Health to the Ninja