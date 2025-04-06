count=1
for file in *; do
	if [ -f "$file" ]; then
		current=$(date -r "$file")
		echo "$current $file $count"
		count=$((count+1))
	fi
done
