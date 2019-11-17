
<!DOCTYPE html>
<html>

</head>
<body>
	<form action="index.php" method="GET">
		Student's name: <input type="text" name="stname">
		Tutor's name: <input type="text" name="tname">
		Feedback: <input type="text" name="f">
		<br>
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
	$st = $_GET['stname'];
	$t = $_GET['tname'];
	$fd = $_GET['f'];
	
}

$sql = "insert into review (`s`, `student name`, `tutor name`, `feedback`) values (null, '$st', '$t', '$fd')";

$query =  mysqli_query($con, $sql);

$m = "SELECT * FROM review ";

$records = mysqli_query($con, $m);
echo "<hr>";
while($row = mysqli_fetch_array($records))
{
	echo "<tr>";
		//echo "entry number ";
		//echo " ";
		//echo "<td>". $row['s'].    "</td>";
		//echo "    ";
		//echo " :  ";
		echo "<br>";
		echo "name of student:";
		echo "<td>". $row['student name'].    "</td>";
		echo "<br>";
		echo "name of tutor:";
		echo "<td>". $row['tutor name'].    "</td>";
		echo "<br>";
		echo "feedback:";
		echo "<td>". $row['feedback'].    "</td>";
		
		echo "<br>";
		echo "<br>";
	echo "</tr>";
}


?>

