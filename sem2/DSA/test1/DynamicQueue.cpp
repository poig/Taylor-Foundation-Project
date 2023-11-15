#include <iostream>
using namespace std;
struct Node {
    int data;
    Node *next;
};

bool isEmpty(Node *tmpFront) {
    return (tmpFront == NULL);    
}

void enqueue(Node **tmpFront, int n) {
    Node *newNode = new Node;
    newNode->data = n;
    newNode->next = NULL;    
    if (isEmpty(*tmpFront))
        *tmpFront = newNode; 
    else {
        Node *cur = *tmpFront;
        while (cur->next != NULL)
            cur = cur->next;
        cur->next = newNode;
    }
}

void displayQueue(Node *cur) {
    if (isEmpty(cur))
        cout << "Queue is empty! Nothing to display.\n";
    else {
        cout << "FRONT ";
        while (cur != NULL) {
            cout << cur->data << " ";
            cur = cur->next; 
        }
        cout << endl;
    }
}


int dequeue(Node **tmpFront) {
    int data = -1;
    if (isEmpty(*tmpFront))
        cout << "Queue is empty! Dequeue aborted!\n";
    else {
        Node *oldFront = *tmpFront;
        *tmpFront = oldFront->next;
        data = oldFront->data;
        delete oldFront;
    }
    return data;
}

int getQueueSize(Node *cur) {
    int count = 0;
    while (cur != NULL) {
        count++;
        cur = cur->next; 
    }
    return count;
}

int main()
{
    Node *front = NULL;
    displayQueue(front);
    cout << "SIZE = " << getQueueSize(front) << endl;
    enqueue(&front, 10);
    enqueue(&front, 20);
    enqueue(&front, 30);
    enqueue(&front, 40);
    displayQueue(front);
    cout << "SIZE = " << getQueueSize(front) << endl;
    cout << "DEQUEUE " << dequeue(&front) << endl;
    cout << "DEQUEUE " << dequeue(&front) << endl;
    displayQueue(front);
    cout << "SIZE = " << getQueueSize(front)<< endl;
    return 0;
}