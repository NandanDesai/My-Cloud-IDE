<?php

session_start();
$usn = $_POST["usn"];
$pass = $_POST["pass"];
$dirname = "data";
$filename = $dirname . "/users.json";
$users = json_decode(file_get_contents($filename), true);
$flag = 0;

foreach ($users as $user) {
    if ($user["usn"] == $usn && $user["pass"] == $pass) {
        $flag = 1;
    }
}
if ($flag == 1) {
    $_SESSION["usn"] = $usn;
    $_SESSION["pass"] = $pass;
    $ch = curl_init(); 
	curl_setopt($ch, CURLOPT_URL, "http://localhost:8080?username=".$usn); 
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1); 
	$output = curl_exec($ch); 
	curl_close($ch);   
	header("Location: $output");
} else {
    echo 'Failed to login :( Don\'t have an account yet?<br><br><br>You can sign up to KLETech Cloud IDE <a href="./signup.html">here!</a>';
}
