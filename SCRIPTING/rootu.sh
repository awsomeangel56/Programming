if [ $(id -u) -eq 0 ]; then
	echo "User running as root"
	exit 1
else
	echo "User running as non-root"
fi
 
