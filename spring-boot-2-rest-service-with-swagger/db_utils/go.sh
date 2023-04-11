exec docker run --name sqlclient -it --network host --rm mysql mysql -hlocalhost -uspringuser --port 3306  --protocol=TCP -pThePassword
