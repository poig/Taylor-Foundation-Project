#include <iostream>
using namespace std;

#define MAXS 5

struct Stack {
    int top;
    int data[MAXS];
};

bool isFull(int tmpTop) {
    return (tmpTop == (MAXS-1));
}

bool isEmpty(int tmpTop) {
    return (tmpTop == -1);
}

void displayStack(Stack tmpStack) {
    if (isEmpty(tmpStack.top))
        cout << "Stack is empty!\n";
    else {
        for (int k = 0; k <= tmpStack.top; k++)
            cout << tmpStack.data[k] << " ";
        cout << "TOP\n";
    }   
}

void push(Stack *ptrStack, int n) {
    if (isFull(ptrStack->top))
        cout << "Stack is full! Push aborted.\n";
    else {
        ptrStack->top++;
        ptrStack->data[ptrStack->top] = n;
    }
}

int pop(Stack *ptrStack) {
    int data = -1;
    if (isEmpty(ptrStack->top))
        cout << "Stack is empty! Pop aborted.\n";
    else {
        data = ptrStack->data[ptrStack->top];
        ptrStack->top--;
    }
    return data;
}

int getStackSize(Stack tmpStack) {
    return (tmpStack.top + 1);
}

int main()
{
    Stack aStack;
    aStack.top = -1;
    push(&aStack, 22);
    push(&aStack, 33);
    push(&aStack, 44);
    displayStack(aStack);
    cout << "POP = " << pop(&aStack) << endl;
    cout << "POP = " << pop(&aStack) << endl;
    displayStack(aStack);
    cout << "SIZE = " << getStackSize(aStack) << endl;
    return 0;
}
