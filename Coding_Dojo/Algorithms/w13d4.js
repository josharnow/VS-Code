class NodeDLL {
  constructor(value) {
    this.value = value;
    this.next = null;
    this.prev = null;
  }
}


class DLL {
  constructor() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  addToFront(value) {
    var node = new NodeDLL(value);
    if (!this.head) {
      this.head = node;
      this.tail = node;
    }
    else {
      node.next = this.head;
      this.head.prev = node;
      this.head = node;
    }
    this.length++
    return this;
  }

  addtoBack(value) {
    var node = new NodeDLL(value);
    if (!this.tail) {
      this.tail = node;
      this.head = node;
    }
    else {
      node.prev = this.tail;
      this.tail.next = node;
      this.tail = node;
    }
    this.length++
    return this;
  }

  removeFromFront() {
    if (!this.head) {
      console.log("List is empty!")
      return this;
    }
    this.head = this.head.next
    this.head.prev.next = null;
    this.head.prev = null;
    this.length--;
    return this;
  }

  removeFromBack() {
    if (!this.tail) {
      console.log("List is empty!")
      return this;
    }
    this.tail = this.tail.prev;
    this.tail.next.prev = null;
    this.tail.next = null;
    this.length--;
    return this;
  }

  printList() {
    let runner = this.head;
    while (runner) {
      console.log(runner.value);
      runner = runner.next;
    }
  }
  printListBackwards() {
    let runner = this.tail;
    while (runner) {
      console.log(runner.value);
      runner = runner.prev;
    }
  }
  reverseList() {
    let runner = this.head;
    if (!this.head) {
      return this;
    }
    while (runner) {
      let temp = runner.next;
      runner.next = runner.prev;
      runner.prev = temp;
      runner = temp;
    }
    temp = this.head
    this.head = this.tail;
    this.tail = temp;

    return this;
  }
  reverseListRecursive(runner = this.head) {
    let temp = this.head;
    if (!runner) {
      this.head = this.tail;
      this.tail = temp;
      return this;
    }
    let nextNode = runner.next;
    runner.next = runner.prev;
    runner.prev = temp;
    return this.reverseListRecursive(nextNode);
  }
}

const list = new DLL;
list.addToFront(5);
list.addToFront(7);
list.addToFront(9);
list.printList();
list.reverseListRecursive();
list.printList();