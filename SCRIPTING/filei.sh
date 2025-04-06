read -p "Enter file name to check integrity: " file
calhash(){
	sha256sum "$file" | awk '{print $1}'
	}
if [ ! -f "$file" ]; then
	echo "File does not exist"
	exit 1
fi
original=$(calhash)
read -p "Make changes"
new=$(calhash)
if [ "$original" = "$new" ]; then 
	echo "File is intact"
else
	echo "File has been modified"
fi
