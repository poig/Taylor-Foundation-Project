#include <iostream>
using namespace std;
struct Node {
    int data;
    Node *next;
    Node *prev;
};

void initNode(Node *tmpHead, int n) {
    tmpHead->data = n;
    tmpHead->next = NULL;
    tmpHead->prev = NULL;
}

void addNode(Node *cur, int n) {
    while (cur->next != NULL)
        cur = cur->next;
    Node *newNode = new Node;
    newNode->data = n;
    newNode->next = NULL;
    cur->next = newNode;
    newNode->prev = cur;
}

void displayList(Node *cur) {
    while (cur != NULL) {
        cout << cur->data << " ";
        cur = cur->next; 
    }
    cout << endl;
}

void displayReverse(Node *cur) {
    cout << "R ";
    //going infront
    while (cur->next != NULL)
        cur = cur->next;
    // strat going backward
    while (cur != NULL) {
        cout << cur->data << " ";
        cur = cur->prev; 
    }
    cout << endl;
}

void addFront(Node **tmpHead, int n) {
    Node *newNode = new Node;
    newNode->data = n;
    newNode->next = *tmpHead;    
    newNode->prev = NULL;
    *tmpHead = newNode;
    newNode->next->prev = newNode;
}

void removeNode(Node *cur) {
    if (cur->next == NULL)
        cout << "Single Node! RemoveNode aborted!\n";
    else {
        while (cur->next->next != NULL)
            cur = cur->next; 
        delete cur->next;
        cur->next = NULL;
    }
}

void removeFront(Node **tmpHead) {
    if ((*tmpHead)->next == NULL)
        cout << "Single Node! RemoveFront aborted!\n";
    else {
        *tmpHead = (*tmpHead)->next;
        delete (*tmpHead)->prev;
        (*tmpHead)->prev = NULL;
    }
}

int getTotalNode(Node *cur) {
    int count = 0;
    while (cur != NULL) {
        count++;
        cur = cur->next; 
    }
    return count;
}

int main() {
    Node *head = new Node;
    initNode(head, 22);
    addNode(head, 33);
    cout  << " " << head->data;//->data;
    //    
    //displayList(head);
    //displayReverse(head);
    //addFront(&head, 11);
    //displayList(head);
    //displayReverse(head);
    //removeNode(head);
    //displayList(head);
    //displayReverse(head);
    //removeFront(&head);
    //displayList(head);
    //displayReverse(head);
    //cout << "COUNT = " << getTotalNode(head);
    return 0;
}