#include <stdio.h>
#include <string.h>
#include <ctype.h>
char s[10];
int top=-1;
void push(char itm){
    s[++top]=itm;
}
char pop(){
    return s[top--];
}
int prec(char op){
    switch(op){
        case '(':
        case '#': return 0;
        case '+':
        case '-': return 1;
        case '*':
        case '/': return 2;
    }
}
void main(){
    char inf[20],post[20],sym;
    int i,k;
    printf("Enter the infix expression: ");
    scanf("%s",inf);
    s[++top]='#';
    for(i=0,k=0;inf[i]!='\0';i++){
        sym=inf[i];
        if(isalpha(sym)){
            post[k++]=sym;
            continue;
        }
        if(sym=='('){
            push(sym);
            continue;
        }
        if(sym==')'){
            while((s[top]=pop())!='(')
                post[k++]=sym;
                continue;
        }
        while((prec(sym))<=prec(s[top]))
            post[k++]=pop();
            push(sym);
    }  
    while(s[top]!='#')
        post[k++]=pop();
        post[k]='\0';
    printf("Infix: %s\nPostfix: %s\n",inf,post);
}
