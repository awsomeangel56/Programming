read -p "Enter filename to reverse: " file
mapfile -t lines < "$file"
for((i=12;i>=0;i--)); do
	echo "${lines[i]}"
done
