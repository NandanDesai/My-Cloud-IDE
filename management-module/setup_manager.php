<?php

session_start();
$usn = $_SESSION["usn"];
$pass = $_SESSION["pass"];
$proj=$_POST["proj"];

file_put_contents("./user_files/".$usn."/raw_IDE/data/cur_user",$usn);

header("Location: process.php?usn=$usn&pass=$pass&proj=$proj");


