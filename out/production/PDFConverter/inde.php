<?php

echo "File has been converted!";
//SEARCH FOR HISTORY CLEAR FILE
$src_dir = getcwd()."/uploads/historyClear/";
//SEARCH FOR RETRIEVE CLEAR FILE
$dest_dir = getcwd()."/uploads/retrieveClear/";

$file_name =  $_FILES['file']['name'];
$tmp_name = $_FILES['file']['tmp_name'];
// This Real Time to Avoid 2 File is being input at the same time.
$file_up_name = time().$file_name;
move_uploaded_file($tmp_name, "uploads/historyClear/".$file_up_name);

// REMOVE EXTENSION TYPE FROM FILE FOR EASY JAVA TO READ
$filename_without_ext = preg_replace('/\\.[^.\\s]{3,4}$/', '', $file_up_name);

//WRITING FILE NAME FOR JAVA TO READ
$myfile = fopen("uploads/ReadPhpToJava.txt", "w") or die("Unable to open file!");
fwrite($myfile, $filename_without_ext);
fclose($myfile);

// JAVA JAR EXECUTE
//$command = "java -jar out/artifacts/JavaDropBox_jar/JavaDropBox.jar ";
//echo shell_exec($command);


?>

