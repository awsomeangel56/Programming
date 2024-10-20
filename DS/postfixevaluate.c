#include <stdio.h>
#include <string.h>
#include <ctype.h>
char s[10];
int top=-1;
void push(char itm){
s[++top]=itm;
}
int pop(){
return s[top--];
}
void main(){
char exp[20],*ptr;
int o1,o2,sol,n;
printf("Enter postfix expression: ");
fgets(exp,20,stdin);
ptr=exp;
while(*ptr!='\0'){
if (*ptr==' '){
ptr++;
continue;}
if (isdigit(*ptr)){
int num=0;
while(isdigit(*ptr)){
n=*ptr-48;
num=(num*10)+n;
ptr++;
}
push(num);}
else{
o1=pop();
o2=pop();
switch(*ptr){
case '+': sol=o1+o2;
break;
case '-': sol=o2-o1;
break;
case '*' : sol=o2*o1;
break;
case '/' : sol=o2/o1;
break;
}
push(sol);
ptr++;
}
}
printf("solution :%d \n",pop());} 

//5 5 + 22 -//
