import random
def mil(n):
    if n in [2,3]:
        return True
    if n<2 or n%2==0:
        return False
    r=0
    k=10
    d=n-1
    while d%2==0:
        r+=1
        d//=2
    for _ in range(k):
        a=random.randint(2,n-2)
        x=pow(a,d,n)
        if x==1 or x==n-1:
            continue
        for _ in range(r-1):
            x=pow(x,2,n)
            if x==n-1:
                break
            else:
                return False
    return True
n=int(input("Enter a number to check using miller rabin test: "))
if mil(n):
    print("Number is probably prime")
else:
    print("Number is definitely composite")