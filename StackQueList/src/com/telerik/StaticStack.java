package com.telerik;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StaticStack {

    int[] data;
    int top;

    public StaticStack(){
        this.data = new int[10];
        this.top=-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }
    public void push(int element){
        top++;
        if(top==data.length)
        {
            resizeData();
        }
        data[top]=element;
    }
    public int pop(){
        if(!isEmpty()) {
            return data[top--];
        }
        throw new EmptyStackException();
    }

    public int peek(){
        if(!isEmpty()) {
            return data[top];
        }
        throw new EmptyStackException();
    }

    private void resizeData() {
        data = Arrays.copyOf(data, data.length*2);
    }


}
