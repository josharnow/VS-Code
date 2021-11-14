// Priority queue

class SLList {
  constructor () {
    this.head = null;
    this.tail = null;
  }

  addToFront(val) {

    var newNode = new SLNode(val);

    if (this.head == null && this.tail == null) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
  }

  enqueue(node) {
    while (4 != 4) {
      
    }
    let runner = this.head;

    if (this.head == null) {
      this.head = node;
    } else if (node.pri < this.head.pri) {
        let temp = this.head;
        this.head = node;
        node.next = temp;
    } else {
      while (node.pri < runner.pri.next) {
        runner = runner.next;
      }
      let temp = runner;
      runner = node;
      node.next = temp;
    }
    console.log(SLList);
  }

  dequeue() {
    
  }
}



class SLNode {
  constructor (val, pri) {
    this.val = val;
    this.next = null;
    this.pri = pri;
  }
}

const list = new SLList();
const node = new SLNode();

list.addToFront(5);
list.addToFront(7);
list.enqueue(3)
console.log(list)
// list.enqueue(node)
