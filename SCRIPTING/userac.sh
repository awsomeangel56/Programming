whitelist=("user","chigga","bilal")
current=$(whoami)
if [[ ! "${whitelist[@]}" =~ "$current" ]]; then
	echo "Permission denied"
else
	echo "Permitted"
fi

