"""Solution for Reverse a Linked List task.

Task:   ../data-structures-reverse-linked-list.pdf
Author: Igor Baiborodine

"""
import os


class SinglyLinkedListNode:
    def __init__(self, node_data):
        self.data = node_data
        self.next = None


class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def insert_node(self, node_data):
        node = SinglyLinkedListNode(node_data)

        if not self.head:
            self.head = node
        else:
            self.tail.next = node

        self.tail = node


def print_singly_linked_list(node, sep, fptr):
    while node:
        fptr.write(str(node.data))

        node = node.next

        if node:
            fptr.write(sep)


# Complete the reverse method below.
def reverse(head):
    current_node = head
    next_node = head.next

    sll = SinglyLinkedList()
    sll.head = head
    sll.tail = head
    sll.tail.next = None

    while next_node:
        after_next_node = next_node.next
        next_node.next = current_node
        sll.head = next_node
        current_node = next_node
        next_node = after_next_node

    return sll.head


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    tests = int(input())

    for tests_itr in range(tests):
        llist_count = int(input())

        llist = SinglyLinkedList()

        for _ in range(llist_count):
            llist_item = int(input())
            llist.insert_node(llist_item)

        llist1 = reverse(llist.head)

        print_singly_linked_list(llist1, ' ', fptr)
        fptr.write('\n')

    fptr.close()

