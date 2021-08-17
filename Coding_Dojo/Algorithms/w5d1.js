class ArrayStack {
    constructor() {
        this.contents = [];
    }

    push(value) {
        return this.contents.push(value);
    }

    pop() {
        return this.contents.pop();
    }



    top() {
        top = this.contents.length - 1;
        return top;
        }  // Returns top value w/o removing it

    contains(target) {
        for (let index = 0; index < this.contents.length; index++) {
            if (this.contents[index] == target) {
                return true;
            }
        }
        return false;
    }

    isEmpty() {
        return this.contents.length == 0;
    }

    size() {
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