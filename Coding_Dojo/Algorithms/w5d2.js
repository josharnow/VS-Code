class ListNode {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class SLLStack {
    constructor() {
        this.head = null;
        this.tail = null;
    }
}

class SinglyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
    }

class ArrayStack {
    constructor() {
        this.contents = [];
    }

    push(value) {
        var newNode = new ListNode(value)
        if (this.head === null && this.tail === null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode
        }
    }

    pop() {
        if (this.head === null && this.tail === null) {
            return undefined;
        }
        if (this.head === this.tail) {
            var temp = this.head;
            this.head = null;
            this.tail = null;
            return temp.value;
        } else {
            var temp = this.head.next;
            var oldHead = this.head;
            this.head.next = null;
            this.head = temp;
        }
        return oldHead.value;
    }

    top() {
        if (this.head === null && this.tail === null) {
            return undefined;
        } else {
            return this.head.value;
        }
    } // Returns top value w/o removing it

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

    isEmpty() {
        if (this.head === null & this.tail === null) {
            return true;
        }
        return false;
    }

    size() {
        if (this.head === null & this.tail === null) {
            return null;
        }
        var runner = this.head;
        var counter = 0;
        return this.contents.length;
    } // Returns the size of the stack
} // LIFO

var stack = new ArrayStack();
console.log(stack.push(2));
console.log(stack.push(5));
console.log(stack.push(7));
console.log(stack.contains(5));
console.log(stack.top());
console.log(stack.isEmpty());
console.log(stack.size())