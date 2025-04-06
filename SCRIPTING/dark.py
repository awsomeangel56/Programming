import requests
import tldextract
usrl=input("Enter url to check: ")
try:
    ext=tldextract.extract(usrl)
    tld=ext.suffix
    if tld in("onion","i2p","bit"):
        print("Part of dark web")
    else:
        print("not part of dark web")
except requests.exceptions.RequestException:
    print("Invalid URL")

