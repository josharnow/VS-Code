// Reverse a singly linked list

class Node {
  constructor(valueInput) {
    this.value = valueInput;
    this.next = null;
  }
}

class SLL {
  constructor() {
    this.head = null;
  }

  addToFront(value) {
    var node = new Node(value);
    node.next = this.head;
    this.head = node;
    return this;
  }

  display() {
    let result = "";
    let runner = this.head;
    while (runner != null) {
      result += `${runner.value}--> `;
      runner = runner.next;
    }
    console.log(result);
  }

  reverseList() {
    let runner = this.head;
    let prevNode = null;

    while(runner.next != null) {
      let tempPointer = runner.next;

    }
  }
}


reverseListRecursive(runner = this.head, previousNode = null) {
  if (runner == null) {
    this.head = previousNode;
    return this;
  }

  var temp = runner.next;
  runner.next = previousNode;
  return this.reverseListRecursive(temp, runner);


}

const list = new SLL;
list.display();
