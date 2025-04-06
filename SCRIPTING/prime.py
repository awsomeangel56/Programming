n=int(input("Enter a number: "))
if n<2:
    print("Not a prime")
    exit()
t=1
for i in range(2,n):
    if n%i==0:
        t=0
        break
if t==1:
    print("Prime")
else:
    print("Not prime")