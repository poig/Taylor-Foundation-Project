#include <iostream>
using namespace std;

// Define a Node structure
struct Node {
    int data; // Data of the node
    Node *next; // Pointer to the next node
};

// Function to initialize a node
void initNode(Node *tmpHead, int n) {
    tmpHead->data = n; // Set the data of the node
    tmpHead->next = tmpHead; // Set the next pointer to itself (circular)
}

// Function to add a node at the end of the list
void addNode(Node *cur, int n) {
    Node *tmpHead = cur; // Save head node
    while (cur->next != tmpHead) // Traverse till the end of the list
        cur = cur->next;
    Node *newNode = new Node; // Create a new node
    newNode->data = n; // Set the data of the new node
    newNode->next = tmpHead; // Set next pointer of new node to head (circular)
    cur->next = newNode; // Link the new node at the end of the list
}

// Function to remove a node from end of the list
void removeNode(Node *cur) {
    if (cur->next == cur)
        cout << "Single Node! RemoveNode aborted!\n";
    else {
        Node *tmpHead = cur; // Save head node 
        while (cur->next->next != tmpHead) // Traverse till second last node 
            cur = cur->next;
        delete cur->next; // Delete last node 
        cur->next = tmpHead; // Update second last's next to head (circular)
    }
}

// Function to add a node at the front of the list
void addFront(Node **tmpHead, int n) {
    Node *cur = *tmpHead; // Save current head node in cur 
    Node *newNode = new Node; // Create a new node
    newNode->data = n; // Set the data of the new node
    newNode->next = *tmpHead;  // Link new node with first node   
    while (cur->next != *tmpHead) // Traverse till end of list 
        cur = cur->next;
    *tmpHead = newNode; // Update head to point to new node
    cur->next = newNode; // Update last node's next to new head (circular)
}

// Function to remove a node from front of the list
void removeFront(Node **tmpHead) {
    if ((*tmpHead)->next == *tmpHead)
        cout << "Single Node! RemoveFront aborted!\n";
    else {
        Node *cur = *tmpHead;  // Save current head in cur 
        while (cur->next != *tmpHead)  // Traverse till end of list 
            cur = cur->next;
        *tmpHead = (*tmpHead)->next;  // Update head to point to second node 
        delete cur->next;  // Delete old head 
        cur->next = *tmpHead;  // Update last node's next to new head (circular)
    }
}

// Alternate function for removing front node 
Node * removeFront2(Node *tmpHead) {
    if (tmpHead->next == tmpHead)
        cout << "Single Node! RemoveFront aborted!\n";
    else {
        Node *cur = tmpHead;  // Save current head in cur 
        while (cur->next != tmpHead)  // Traverse till end of list 
            cur = cur->next;
        tmpHead = tmpHead->next;  // Update head to point to second node 
        delete cur->next;  // Delete old head 
        cur->next = tmpHead;  // Update last node's next to new head (circular)
    }
    return tmpHead;
}

// Function to display all nodes in the list
void displayList(Node *cur) {
    Node *tmpHead = cur; // Save head node
    do {
        cout << cur->data << " "; // Print the data of current node
        cur = cur->next;  // Move to next node
    } while (cur != tmpHead); // Continue until we reach head again (circular)
    cout << endl;
}

// Function to get total number of nodes in the list 
int getTotalNode(Node *cur) {
    Node *tmpHead = cur;
    int count = 0;
    do {
        count++;  // Increment count 
        cur = cur->next;  // Move to next node 
    } while (cur != tmpHead);  // Continue until we reach head again (circular)
    
    return count;
}

// Alternate function for getting total nodes 
int getTotalNode2(Node *cur) {
    Node *tmpHead = cur;
    int count = 1;
    while (cur->next != tmpHead) {
        count++;  // Increment count 
        cur = cur->next;  // Move to next node 
    }
    return count;
}

int main()
{
    Node *head = new Node;
    
    initNode(head, 22);  // Initialize head with 22 
    addNode(head, 33);   // Add 33 at end 
    addNode(head, 44);   // Add 44 at end 
    addNode(head, 55);   // Add 55 at end 
    
    displayList(head);   // Display all nodes 
    
    addFront(&head, 11);  // Add 11 at front 
    
    displayList(head);   // Display all nodes 
    
    removeNode(head);   // Remove last node 
    
    displayList(head);   // Display all nodes 
    
    removeFront(&head);   // Remove first node 
    
    displayList(head);   // Display all nodes 
    
    head = removeFront2(head);  // Remove first node using alternate function 
    
    displayList(head);   // Display all nodes 
    
    cout << "COUNT = " << getTotalNode2(head);   // Print total number of nodes 

    return 0;
}
