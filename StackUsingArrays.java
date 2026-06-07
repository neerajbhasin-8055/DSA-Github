import java.util.*;
class StackUsingArrays{
    int[] st;
    int size;
    int top = -1;
    StackUsingArrays(int size){
        this.size = size;
        this.st = new int[size];
    }
    public void push(int x){
        if(isEmpty()){
            System.out.println("Cannot push, stack is full");
            return;
        }
        top++;
        st[top] = x;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return st[top];
    }

    public int pop(){
        if(top == -1){
            System.out.println("Stack is Empty");
            return -1;
        }
        return st[top--];
    }

    public boolean isEmpty(){
        return top == -1;
    }
}