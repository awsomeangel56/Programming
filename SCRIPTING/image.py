import os
dir_path=input("Enter path: ")
extension=(".pdf",".jpg",".gif")
if not os.path.exists(dir_path):
    print("Path not found")
else:
    for i in os.listdir(dir_path):
        if i.lower().endswith(extension):
            print(i)