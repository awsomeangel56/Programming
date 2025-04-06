#!/bin/bash 
l=0 
w=0 
c=0 
while read line; do 
l=$((l+1)) 
c=$((c+${#line})) 
for word in $line; do 
w=$((w+1))
done 
done 
echo "Lines: $l Words: $w Characters: $c" 