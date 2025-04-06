read -p "Enter a num: " num
rev_num=$(echo "$num" | rev)
if [ "$num" = "$rev_num" ]; then
	echo "pallindrome"
else
	echo "not pallindrome" 
fi
