#include <stdio.h>
#include <string.h>
#include <ctype.h>
char s[20];
int top=-1;
void push(int itm){
    s[++top]=itm;
}
int pop(){
    return s[top--];
}
int evaluatePost(char* post){
    int i;
    int op1,op2;
    char sym;
    for(i=0;post[i]!='\0';i++){
        sym=post[i];
        if(isdigit(sym)){
            push(sym-'0');
        }
        else{
            op2=pop();
            op1=pop();
            switch(sym){
                case '+': push(op1+op2);
                break;
                case '-': push(op1-op2);
                break;
                case '*':push(op1*op2);
                break;
                case '/':push(op1/op2);
                break;
            }
        }
    }
    return pop();
}
int main(){
    char post[20];
    printf("Enter postfix expression: ");
    scanf("%s",post);
    int result=evaluatePost(post);
    printf("Postfix expression is:%s ",post);
    printf("Evaluation result: %d",result);

return 0;
}
