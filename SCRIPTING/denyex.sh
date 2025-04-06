echo "Enter executable to protect: "
read file
if [ ! -f $file ]; then
	echo "File not found"
else
	chmod -x $file
	echo "Execution denied"
fi
