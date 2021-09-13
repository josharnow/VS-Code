class Card {
    constructor(name, cost) {
        this.name = name;
        this.cost = cost;
    }
}

class Unit extends Card {
    constructor(name, cost, power, res) {
        super(name, cost);
        this.power = power;
        this.res = res;
    }
    attack(target) { // reduce {target} {res} by {power}
        console.log(`Attacking ${target.name}: ${target.res} resilience - ${this.power} damage = ${target.res - this.power} resilience`)
        target.res -= this.power;
    }
    showStats() {
        console.log(`Name: ${this.name}`);
        console.log(`Cost: ${this.cost}`);
        console.log(`Power: ${this.power}`);
        console.log(`Resilience: ${this.res}`);
        return `Name: ${this.name} | Cost: ${this.cost} | Power: ${this.power} | Resilience: ${this.res}`;
    }
}

class Effect extends Card {
    constructor(name, cost, text, stat, magnitude) {
        super(name, cost);
        this.text = text;
        this.stat = stat;
        this.magnitude = magnitude;
    }
    showStats() {
        console.log(`Name: ${this.name}`);
        console.log(`Cost: ${this.cost}`);
        console.log(`Text: ${this.text}`);
        console.log(`Stat: ${this.stat}`);
        this.magnitude >= 0
            ? console.log(`Magnitude: +${this.magnitude}`)
            : console.log(`Magnitude: ${this.magnitude}`);
        return this.magnitude >= 0
            ? `Name: ${this.name} | Cost: ${this.cost} | Text: ${this.text} | Stat: ${this.stat} | Magnitude: +${this.magnitude}`
            : `Name: ${this.name} | Cost: ${this.cost} | Text: ${this.text} | Stat: ${this.stat} | Magnitude: ${this.magnitude}`;
    }
    play(target) {
        if (target instanceof Unit) { // implement card text here
            console.log(`${this.text}`);
            if (this.stat === "Resilience") {
                this.magnitude >= 0
                    ? console.log(`${target.name}: ${target.res} resilience + ${this.magnitude} magnitude = ${target.res + this.magnitude} resilience`)
                    : console.log(`${target.name}: ${target.res} resilience - ${this.magnitude * -1} magnitude = ${target.res + this.magnitude} resilience`);
                target.res += this.magnitude;
            } else if (this.stat === "Power") {
                this.magnitude >= 0
                    ? console.log(`${target.name}: ${target.power} power + ${this.magnitude} magnitude = ${target.power + this.magnitude} power`)
                    : console.log(`${target.name}: ${target.power} power - ${this.magnitude * -1} magnitude = ${target.power + this.magnitude} power`);
                target.power += this.magnitude;
            }
        } else {
            throw new Error("Target must be a unit!");
        }
    }
}

const rbNinja = new Unit("Red Belt Ninja", 3, 3, 4);
const hardAlgorithm = new Effect("Hard Algorithm", 2, "Increase target's resilience by 3", "Resilience", 3);
hardAlgorithm.play(rbNinja);

const bbNinja = new Unit("Black Belt Ninja", 4, 5, 4);
const unhandledPromiseRejection = new Effect("Unhandled Promise Rejection", 1, "Reduce target's resilience by 2", "Resilience", -2);
unhandledPromiseRejection.play(rbNinja);

const pairProgramming = new Effect("Pair Programming", 1, "Increase target's power by 2", "Power", 2);
pairProgramming.play(rbNinja);

rbNinja.attack(bbNinja);

// rbNinja.showStats();
// bbNinja.showStats();
// hardAlgorithm.showStats();
// unhandledPromiseRejection.showStats();
// pairProgramming.showStats();


// attack(target) { // reduce {target} {res} by {power}
//     target.res -= this.power;
// }