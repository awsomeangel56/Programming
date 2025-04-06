n=int(input("Enter no. to check: "))
num=str(n)
if num==num[::-1]:
    print("Pallindrome")
else:
    print("Not pallindrome")f