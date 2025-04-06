def passchk(p):
    rate=0
    l=len(p)
    if l>=8:
        rate+=1
    if l>=12:
        rate+=1
    if any(c.isupper() for c in p):
        rate+=1
    if any(c.islower() for c in p):
        rate+=1
    if any(c.isdigit() for c in p):
        rate+=1
    if any(c in "!@#$%^&*()_+-=" for c in p):
        rate+=1
    return rate
p=input("Enter password to check: ")
pas=passchk(p)
print("Password complexity is: ",pas,"/10")
