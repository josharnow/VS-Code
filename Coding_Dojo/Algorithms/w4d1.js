// singly linked lists
// ListNode class: we'll be using this

class ListNode {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

// var x = new ListNode(7);

// var y = new ListNode(17);
// x.next = y;

// var z = new ListNode(3);
// y.next = z;

class SinglyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
    }
    // addToFront - adds a node with the given value to the head of the list
    addToFront(value) {

        var newNode = new ListNode(value);

        if (this.head == null && this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        }

        else {
            newNode.next = this.head;
            this.head = newNode;
        }

    }
    // addToBack - adds a node with the given value to the tail of the list
    addToBack(value) {

        var newNode = new ListNode(value);

        if (this.head == null && this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        }

        else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }
    // contains - returns true if target is in the linked list (as a node value),
    // false otherwise
    contains(target) {
        var runner = this.head;

        while (runner != null) {

            if (runner.value == target) {
                return true;
            }
            runner = runner.next;
        }

        return false;
    }

    // display()
    // return a string with the value of every node from the
    // linked list - like "3 - 7 - 13 - 4 - 8"
    display() {
        var runner = this.head;
        var output = '';

        while (runner != null) {
            if (runner == this.tail) {
                output += runner.value;
            }
            else {
                output += runner.value + ' - ';
            }
            runner = runner.next;
        }

        return output;
    }

    removeFront() {
        if (this.head == null && this.tail == null) {
            return undefined;
        }
        else {
            let x = this.head;
            this.head = this.head.next;
            x.next = null;
            return x.value;
        }
    }

    removeBack() {
        if (this.head == null && this.tail == null) {
            return undefined;
        }

        // if (this.head == this.tail) {
        //     let temp = this.head;

        // }

        let runner = this.head;
        let x = this.tail;
        while (runner != null) {
            if (runner.next == this.tail) {
                this.tail = runner;
                this.tail.next = null;
                return x.value;
            }
            runner = runner.next;
        }


        for (let runner = this.head; runner < this.tail; runner++) {
            if (this.head.next == this.tail) {

            }
        }
    }

    findMinNode() {
        let runner = this.head;
        let minValue = this.head;
        while (runner != null) {
            if (minValue.value < runner.value) {
                minValue = runner;
            }
            runner = runner.next;
        }
        return minValue;
        // return false;
        // return false;
        // runner = head
    }

    findMaxNode() {

    }

    secondToLast() {
    }
}

function generateNewList(length, min_value, max_value) {
    var newSLL = new SinglyLinkedList();
    for (let i = 0; i < length; i++) {
        let x = Math.round((Math.random() * max_value) - min_value);
        if (x < 0) {
            x = x * (-1);
        }
        newSLL.addToFront(x);
    
    }
    return newSLL;
}

var newSLL = new SinglyLinkedList();

newSLL.addToBack(27);
newSLL.addToFront(8);
newSLL.addToFront(4);
newSLL.addToFront(13);
newSLL.addToFront(7);
newSLL.addToFront(3);
newSLL.addToBack(14);

console.log(newSLL.display());
console.log(newSLL.contains(13));
console.log(newSLL.contains(99));

console.log(newSLL.head);
console.log(newSLL.tail);

newSLL.removeFront();
newSLL.removeBack();
console.log(newSLL.head);
console.log(newSLL.tail);


console.log(newSLL.removeBack());
console.log(newSLL.display());
console.log(generateNewList(6,2,5).display());
console.log(newSLL.findMinNode());