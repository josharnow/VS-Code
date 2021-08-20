class SLLQueue {
    constructor() {
        this.head = null;
        this.tail = null;
    }

    enqueue(value) {
        if (this.head == null && this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    dequeue() {
        var holder = this.head;
        if (this.head == null && this.tail == null) {
            return "empty";
        } 
        if (this.head == this.tail) {
            
            this.head == null;
            this.tail == null;
            return holder.value;
        }
        this.head =
        }
    }

    front() {
        if (this.head == null && this.tail == null) {
            return "empty";
        } else {
            return this.head.value;
        }
    } 

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
    
    }

    size() {
        var counter = 0;
        var runner = this.head;
        while (runner != null) {
            counter += 1;
            runner = runner.next;
        }
        return cou
        
    compareQueues(queue2) {
        var array1 = [];
        var array2 = [];
        var runner1 = this.head;
        var runner2 = queue2.head;
        while (runner1 =! null) {
            if (condition) {
                
            }
            array1.push(runner1.value);
            runner1 = runner1.next;
        }
    }
}


display() {

}

var stack = new ArrayStack();
console.log(stack.push(2));
console.log(stack.push(5));
console.log(stack.push(7));
console.log(stack.contains(5));
console.log(stack.top());
console.log(stack.isEmpty());
console.log(stack.size())

enqueue()

dequeue()

var queue_A = new SLLQueue();