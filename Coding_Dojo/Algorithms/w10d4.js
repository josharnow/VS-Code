// Two children : 2N, 2N+1
// Both children should be larger than parent
// Value at index 1 is minimum value of heap

class MinHeap {
    constructor() {
        this.heap = [null]; // first element
    }

    insert(val) {
        this.heap.push(val);
        this.shiftUp();
    }

    shiftUp() {
        if (this.heap.length > 1) {
            let currentIndex = this.heap.length - 1;

            
                // swap current with its parent
                // set current to the index it was moved to
            while (this.heap[currentIndex] < this.heap[Math.floor(currentIndex/2)] && currentIndex > 1) { // while(should shift)
                
                let parentIndex = Math.floor(currentIndex/2);
                let temp = this.heap[currentIndex];
                this.heap[currentIndex] = this.heap[parentIndex];
                currentIndex = parentIndex;
            }
        }
    }

    remove() {
        if(this.heap.length === 1)
            return null;

        const min = this.heap[1];
        const lastNode = this.heap.pop();

        if(this.heap.length === 1) {

            return min;
        }

        heap[1] = lastNode;
        this.shiftDown();
        return min;
    }

    shiftDown() {
        let currentIndex = 1;
        let leftChildIndex = currentIndex * 2;

        while(leftChildIndex < this.heap.length){
            let rightChildIndex = leftChildIndex + 1;
            let smallerIndex = this.heap[leftChildIndex] < this.heap[rightChildIndex]
                ? leftChildIndex
                : rightChildIndex;
            
                if(this.heap[currentIndex] < this.heap[smallerIndex])
                    break
        }
    }

    printMe() {
        // for (let i = 1; i < this.heap.length; ++i) {
        //     console.log(this.heap[i]);
        // }
        const [, ...rest] = this.heap;
        console.log(rest);
    }
}

const testHeap = new MinHeap();

testHeap.insert(1);
testHeap.printMe();
testHeap.insert(5);
testHeap.printMe();
testHeap.insert(7);
testHeap.printMe();
testHeap.insert(9);
testHeap.printMe();
testHeap.insert(3);
testHeap.printMe();
testHeap.insert(4);
testHeap.printMe();
testHeap.insert(-1);
testHeap.printMe();