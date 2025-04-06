if pgrep -x "bash" </dev/null; then
	echo "Script is running"
else
	echo "No scripts running"
fi
