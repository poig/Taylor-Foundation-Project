1) pointer
2) single linked
3) double linked
4) circular linked list
5) static stack
6) dynamic queue

test format
1) print out result
2) complexity
3) comprehensive reason how the algorithm work

Bring pen and spare pen


Week 01
Lecture Week 01
   - Problems, Algorithm, Programs

Simple Linked List Operations
   - declare, initialize, add(F/B), remove(F/B), display, count

Double Linked List Operations
   - declare, initialize, add(F/B), remove(F/B), display, reversed display

Circular Linked List Operations
   - declare, initialize, add(F/B), remove(F/B), display, count
   
- advantages and disadvantages among Single, Double, and Circular operations

what is Stack behavior, its something first in first out(FIFO) or first in last out(FILO)

Stack operations (static) 
   - declare, initialize, isFull, isEmpty, pop, push, display, stackSize

what is Queue behavior

Queue operations (dynamic) 
   - declare, initialize, isEmpty, enqueue, dequeue, display, queueSize


**Singly Linked List:**
- Advantages¹²:
  * Dynamic data structure: It can grow and shrink at runtime by allocating and deallocating memory.
  * No memory wastage: Efficient memory utilization can be achieved since the size of the linked list increases or decreases at runtime.
  * Efficient for large data: When working with large datasets linked lists play a crucial role as it can grow and shrink dynamically.
  * Scalability: Contains the ability to add or remove elements at any position.
- Disadvantages¹²:
  * More memory is required in the linked list as compared to an array.
  * Traversal is more time-consuming as compared to an array. Direct access to an element is not possible.
  * Reverse traversing is very difficult.

**Doubly Linked List:**
- Advantages³⁴:
  * Reversing the doubly linked list is very easy.
  * It can allocate or reallocate memory easily during its execution.
  * The traversal of this doubly linked list is bidirectional which is not possible in a singly linked list.
  * Deletion of nodes is easy as compared to a Singly Linked List.
- Disadvantages³⁴:
  * It uses extra memory when compared to the array and singly linked list.
  * Since elements in memory are stored randomly, therefore the elements are accessed sequentially no direct access is allowed.
  * Traversing a doubly linked list can be slower than traversing a singly linked list.
  * Implementing and maintaining doubly linked lists can be more complex than singly linked lists.

**Circular Linked List:**
- Advantages⁵⁶⁷⁸:
  * No requirement for a NULL assignment in the code. The circular list never points to a NULL pointer unless fully deallocated.
  * Circular linked lists are advantageous for end operations since beginning and end coincide.
- Disadvantages⁵⁶⁷⁸:
  * Circular lists are complex as compared to singly linked lists.
  * If not handled carefully, then the code may go in an infinite loop.
  * Harder to find the end of the list. 

Each type of linked list has its own strengths and weaknesses, and the choice between them depends on the specific requirements of your program. For example, if you need efficient insertions/deletions at both ends of the list, a doubly-linked list would be a good choice. If you need to save memory, a singly-linked list would be better. If you need to cycle through items repeatedly, a circular linked list would be ideal.
