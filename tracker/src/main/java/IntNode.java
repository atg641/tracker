

  class IntNode {
        int item;
        IntNode next;
        IntNode prev;

        IntNode(IntNode prev, int element, IntNode next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }