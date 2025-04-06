import hashlib
s=input("Enter string: ")
hashval=hashlib.md5(s.encode()).hexdigest()
print(hashval)