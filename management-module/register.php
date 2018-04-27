<?php

session_start();

$usn = $_POST["usn"];
$pass = $_POST["pass"];
$dirname = "data";


$filename = $dirname . "/users.json";
if (!is_readable($dirname) || !is_writeable($dirname)) {
    exit("check file permissions on 'data' directory");
}

if (file_exists($filename)) {
    
	
    $users = json_decode(file_get_contents($filename), true);
    $flag = 0;

    foreach ($users as $user) {
        if ($user["usn"] == $usn) {
            $flag = 1;
        }
    }
    if ($flag == 1) {
        echo 'USN already registered. <a href="./login.html">Click here to login</a>';
    } else {

        mkdir("./user_files/" . $usn, 0777);
        if (system("cp -a raw_IDE user_files/$usn/ 2>&1")) {
            echo "failed to register :(";
        } else {
			$usr["usn"] = $usn;
    		$usr["pass"] = $pass;
            array_push($users, $usr);
            file_put_contents($filename, json_encode($users));
            $_SESSION["usn"]=$usn;
            $_SESSION["pass"]=$pass;
            header("Location: setup.html");
			
        }
    }
} else {
    $user["usn"] = $usn;
    $user["pass"] = $pass;
    mkdir("./user_files/" . $usn, 0777);
    if (system("cp -a raw_IDE user_files/$usn/ 2>&1")) {
        echo "failed to register :(";
    } else {
        file_put_contents($filename, json_encode(array($user)));
        $_SESSION["usn"]=$usn;
        $_SESSION["pass"]=$pass;
        header("Location: setup.html");
    }
}
