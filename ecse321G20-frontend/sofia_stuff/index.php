
<!DOCTYPE html>
<html>

</head>
<body>
	<form action="index.php" method="GET">
		name: <input type="text" name="name">
		<input type="submit" name="submit" value="add">
	</form>

<?php
$host= 'localhost';
$user= 'root';
$pass= 'usbw';
$db = 'test';

$con=mysqli_connect($host, $user, $pass, $db);




if(isset($_GET['submit']))
{
	$rn = $_GET['name'];
	
}
$sql = "insert into try(s_no, name) values (null, '$rn')";

$query =  mysqli_query($con, $sql);

$m = "SELECT * FROM try ";

$records = mysqli_query($con, $m);
echo "<hr>";
while($row = mysqli_fetch_array($records))
{
	echo "<tr>";
		//echo "entry number ";
		//echo " ";
		//echo "<td>". $row['s_no'].    "</td>";
		//echo "    ";
		//echo " :  ";
		echo "<br>";
		echo "name of student:";
		echo "<td>". $row['name'].    "</td>";
		echo "<br>";
		echo "<br>";
	echo "</tr>";
}


?>

