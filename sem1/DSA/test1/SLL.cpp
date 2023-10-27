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
    tmpHead->next = NULL; // Set the next pointer to NULL
}

// Function to add a node at the end of the list
void addNode(Node *cur, int n) {
    while (cur->next != NULL) // Traverse till the end of the list
        cur = cur->next;
    Node *newNode = new Node; // Create a new node
    newNode->data = n; // Set the data of the new node
    newNode->next = NULL; // Set the next pointer of new node to NULL
    cur->next = newNode; // Link the new node at the end of the list
}

// Function to display all nodes in the list
void displayList(Node *cur) {
    while (cur != NULL) { // Traverse till the end of the list
        cout << cur->data << " "; // Print the data of current node
        cur = cur->next;  // Move to next node
    }
    cout << endl;
}

// Function to add a node at the front of the list
void addFront(Node **tmpHead, int n) {
    Node *newNode = new Node; // Create a new node
    newNode->data = n; // Set the data of the new node
    newNode->next = *tmpHead;  // Link new node with first node   
    *tmpHead = newNode; // Update head to point to new node
}

// Function to remove a node from end of the list
void removeNode(Node *cur) {
    if (cur->next == NULL)
        cout << "Single Node! RemoveNode aborted!\n";
    else {
        while (cur->next->next != NULL) // Traverse till second last node
            cur = cur->next;
        delete cur->next; // Delete last node
        cur->next = NULL; // Update second last's next to NULL
    }
}

// Function to remove a node from front of the list
void removeFront(Node **tmpHead) {
    if ((*tmpHead)->next == NULL)
        cout << "Single Node! RemoveFront aborted!\n";
    else {
        Node *oldHead = *tmpHead; // Save current head node in oldHead 
        *tmpHead = oldHead->next; // Update head to point to second node 
        delete oldHead; // Delete old head node 
    }
}

// Function to get total number of nodes in the list 
int getTotalNode(Node *cur) {
    int count = 0;
    while (cur != NULL) { // Traverse till end of list 
        count++;  // Increment count 
        cur = cur->next;  // Move to next node 
    }
    return count;
}

int main()
{
    Node *head = new Node;
    
    initNode(head, 20);  // Initialize head with 20 
    addNode(head, 30);   // Add 30 at end 
    addNode(head, 40);   // Add 40 at end 
    
    displayList(head);   // Display all nodes 
    
    addFront(&head, 10);  // Add 10 at front 
    
    displayList(head);   // Display all nodes 
    
    removeNode(head);   // Remove last node 
    
    displayList(head);   // Display all nodes 
    
    removeFront(&head);   // Remove first node 
    
    displayList(head);   // Display all nodes 
    
    cout << "COUNT = " << getTotalNode(head);   // Print total number of nodes 

    return 0;
}