read -p "Enter username" user
while ! who | grep "$user"; do
	sleep 5
done
echo "$user logged in"
	
